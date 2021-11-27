package Designs.APIRateLimiter.SlidingWindowLogs;

import lombok.Data;

@Data
public class ClientLogData {
    private long[] timeStamps;
    private int front;
    private int rear;

    public ClientLogData(long[] timeStamps) {
        this.timeStamps = timeStamps;
        front = -1;
        rear = -1;
    }


}
