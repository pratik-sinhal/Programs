import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

class ProducerBQ implements Runnable{

    private BlockingQueue<Integer> blockingQueue;
    private int poisonPill;

    public ProducerBQ(BlockingQueue<Integer> blockingQueue, int poisonPill) {
        this.blockingQueue = blockingQueue;
        this.poisonPill = poisonPill;
    }

    @Override
    public void run(){
        try {
            produceNumbers();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void produceNumbers() throws InterruptedException{
        for (int i = 0; i < 100; i++) {
            blockingQueue.put(ThreadLocalRandom.current().nextInt(100));
        }
        blockingQueue.put(poisonPill);
    }
}

class ConsumerBQ implements Runnable{

    private BlockingQueue<Integer> blockingQueue;
    private int poisonPill;

    public ConsumerBQ(BlockingQueue<Integer> blockingQueue, int poisonPill) {
        this.blockingQueue = blockingQueue;
        this.poisonPill = poisonPill;
    }

    @Override
    public void run(){
        try {
            consumeNumbers();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void consumeNumbers() throws InterruptedException{
        while(true) {
            int number = blockingQueue.take();
            System.out.println(Thread.currentThread().getName() + " result: " + number);
            if(number == poisonPill)
                break;
        }
    }
}

public class BlockingQueueBQ {

    public static void main(String[] args) {
        int BOUND = 10;
        int NUM_PRODUCERS = 8;
        int NUM_CONSUMERS = 4;
        int poisonPill = Integer.MAX_VALUE;

        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(BOUND);

        for (int i = 0; i < NUM_PRODUCERS; i++) {
            new Thread(new ProducerBQ(blockingQueue, poisonPill)).start();
        }

        for (int j = 0; j < NUM_CONSUMERS; j++) {
            new Thread(new ConsumerBQ(blockingQueue, poisonPill)).start();
        }
    }

}
