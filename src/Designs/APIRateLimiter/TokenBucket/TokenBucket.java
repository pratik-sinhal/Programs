package Designs.APIRateLimiter.TokenBucket;

import Designs.Logger.ApplicationClasses.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * TokenBucket class is singleton
 */
public class TokenBucket {
    private final long refillRate;
    private final long maxBucketSize;

    private Map<String, ClientTokenData> clients;

    private TokenBucket(long maxBucketSize, long refillRate) {
        this.refillRate = refillRate;
        this.maxBucketSize = maxBucketSize;
        clients = new HashMap<>();
    }

    private static class SingletonInstanceHolder {
        private static final TokenBucket INSTANCE = new TokenBucket(2, 2);
    }

    public static TokenBucket getInstance() {
        return SingletonInstanceHolder.INSTANCE;
    }

    @Override
    protected TokenBucket clone() throws CloneNotSupportedException{
        return getInstance();
    }

    protected TokenBucket readResolve() {
        return getInstance();
    }

    private void initializeClientMap(String clientId) {
        clients.put(clientId, clients.getOrDefault(clientId, new ClientTokenData(maxBucketSize, System.currentTimeMillis())));
    }

    public synchronized boolean allowRequest(String clientId) {
        initializeClientMap(clientId);
        refillTokens(clientId);

        ClientTokenData clientTokenData = clients.get(clientId);
        double currentBucketSize = clientTokenData.getCurrentBucketSize();
        if(currentBucketSize >= 1) {
            --currentBucketSize;
            clientTokenData.setCurrentBucketSize(currentBucketSize);
            return true;
        }

        return false;
    }

    private void refillTokens(String clientId) {
        long now = System.currentTimeMillis();

        ClientTokenData clientTokenData = clients.get(clientId);

        long lastRefillTimestamp = clientTokenData.getLastRefillTimestamp();
        double tokensToAdd = (now - lastRefillTimestamp) * refillRate / Math.pow(10,3);
        System.out.println(Thread.currentThread().getName() + " tokens to add = " + tokensToAdd);
        clientTokenData.setCurrentBucketSize(Math.min((clientTokenData.getCurrentBucketSize() + tokensToAdd), maxBucketSize));
        System.out.println(Thread.currentThread().getName() + " current bucket Size = " + clientTokenData.getCurrentBucketSize());
        clientTokenData.setLastRefillTimestamp(now);
    }
}
