package Designs.APIRateLimiter.SlidingWindowLogs;

import java.util.HashMap;
import java.util.Map;

public class SlidingWindowLogs {

    private Map<String, ClientLogData> clients;

    private static final int REQUESTS_PER_SECOND = 5; // throttling limit

    private SlidingWindowLogs() {
        clients = new HashMap<>();
    }

    private static class SingletonInstanceHolder {
        private static final SlidingWindowLogs INSTANCE = new SlidingWindowLogs();
    }

    public static SlidingWindowLogs getInstance() {
        return SlidingWindowLogs.SingletonInstanceHolder.INSTANCE;
    }

    @Override
    protected SlidingWindowLogs clone() throws CloneNotSupportedException{
        return getInstance();
    }

    protected SlidingWindowLogs readResolve() {
        return getInstance();
    }

    private void initializeClientMap(String clientId) {
        clients.put(clientId, clients.getOrDefault(clientId, new ClientLogData(new long[REQUESTS_PER_SECOND])));
    }

    public synchronized boolean allowRequest(String clientId) {
        initializeClientMap(clientId);

        return add(clientId);
    }

    private boolean add(String clientId) {
        long now = System.currentTimeMillis();

        ClientLogData clientLogData = clients.get(clientId);

        long[] timeStamps = clientLogData.getTimeStamps();
        int front = clientLogData.getFront();
        int rear = clientLogData.getRear();

        int length = timeStamps.length;

        boolean isRequestAllowed = false;
        if(front == -1) {
            ++front;
            ++rear;
            timeStamps[rear] = now;
            isRequestAllowed = true;
            System.out.println("One");
        } else if((rear != (length - 1)) && ((rear + 1) != front)) { // if queue not full
            timeStamps[++rear] = now;
            isRequestAllowed = true;
            System.out.println("Two");
        } else if(now - timeStamps[front] <= 1000) { // when request should not be allowed
            isRequestAllowed = false;
            System.out.println("Three");
        } else { // when request is allowed (not throttled)
            rear = (rear + 1) % length;
            timeStamps[rear] = now;
            if(front == rear) {
                front = (front + 1) % length;
            }
            isRequestAllowed = true;
            System.out.println("Four");
        }

        clientLogData.setTimeStamps(timeStamps);
        clientLogData.setFront(front);
        clientLogData.setRear(rear);

        return isRequestAllowed;
    }


}
