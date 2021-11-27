package Designs.APIRateLimiter.TokenBucket;

public class ClientTokenData {
    private double currentBucketSize;
    private long lastRefillTimestamp;

    public ClientTokenData(double currentBucketSize, long lastRefillTimestamp) {
        this.currentBucketSize = currentBucketSize;
        this.lastRefillTimestamp = lastRefillTimestamp;
    }

    public double getCurrentBucketSize() {
        return currentBucketSize;
    }

    public void setCurrentBucketSize(double currentBucketSize) {
        this.currentBucketSize = currentBucketSize;
    }

    public long getLastRefillTimestamp() {
        return lastRefillTimestamp;
    }

    public void setLastRefillTimestamp(long lastRefillTimestamp) {
        this.lastRefillTimestamp = lastRefillTimestamp;
    }
}
