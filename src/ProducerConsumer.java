
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;


/**
 * Simple Java Program to test Producer Consumer Design Pattern 
 * using  wait, notify and notifyAll() methods 
 *
 * @author CodePumpkin
 *
 */
public class ProducerConsumer {

	public static void main(String[] args) throws InterruptedException {
				
		final Queue sharedQ = new LinkedList<Integer>();
		
		Thread consumerThread = new Thread(new Consumer(sharedQ, 4), "CONSUMER");
		Thread producerThread = new Thread(new Producer(sharedQ, 4), "PRODUCER");
		
		producerThread.start();
		consumerThread.start();
		
		producerThread.join();		
	}
}

/**
 * Producer Thread will keep producing values for Consumer.
 * 
 * It will use wait() method when Queue is full and 
 * use notify() method to send notification to Consumer Thread.
 * 
 * @author CodePumpkin
 *
 */
class Producer implements Runnable
{
	private final Queue sharedQ;
	private int maxSize;
	
	public Producer(Queue sharedQ, int maxSize)
	{
		this.sharedQ = sharedQ;
		this.maxSize = maxSize;
	}
	
	@Override
	public void run(){
		try {
		  while(!Thread.interrupted()){
			synchronized (sharedQ) {
			  while(sharedQ.size()==maxSize)
			  {            
				  System.out.println("Queue is full");
				  sharedQ.wait();            
			  }
			  Random random = new Random(); 
			  int number = random.nextInt(100);
			  System.out.println("Producing value " + number);
			  sharedQ.add(number);
			  sharedQ.notify();
			}
		  }
		} catch (InterrupedException e) {
		}
	}
}

/**
 * Consumer Thread will consumer values form shared queue. 
 * 
 * It will use wait() method to wait if queue is empty. 
 * 
 * It will also use notify method to send notification 
 * to producer thread after consuming values from queue. 
 * 
 * @author CodePumpkin
 *
 */
class Consumer implements Runnable
{
	private final Queue sharedQ;
	private int maxSize;
	
	public Consumer(Queue sharedQ, int maxSize)
	{
		this.sharedQ = sharedQ;
		this.maxSize = maxSize;
	}
	
	@Override
	public void run(){
		try {
		  while(!Thread.interrupted()){
			synchronized (sharedQ) {
				while(sharedQ.isEmpty()){
					System.out.println("Queue is Empty");
					sharedQ.wait();
				}
				int number = (int) sharedQ.poll();
				System.out.println("removing Element " + number);
				sharedQ.notify();
			}
		} catch(InterrupedException e) {
		}
	}
}
