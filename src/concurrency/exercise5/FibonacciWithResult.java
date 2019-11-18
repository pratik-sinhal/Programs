package concurrency.exercise5;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by pratik_s on 24/8/16.
 */
public class FibonacciWithResult implements Generator<Integer>, Callable<Integer> {

    private Integer count;
    private static Integer taskCount = 0;
    private final Integer taskId = taskCount++;

    public FibonacciWithResult(Integer count) {
        this.count = count;
    }

    private Integer getFibonacci(Integer n) {
        if(n < 2) {
            return 1;
        }
        return getFibonacci(n-2) + getFibonacci(n-1);
    }

    @Override
    public Integer next(Integer n) {
        return getFibonacci(n);
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("Starting task " + taskId);
        Integer sum = 0;
        for (int i = 0; i < count; i++) {
            sum = sum + next(i);
            Thread.yield();
        }
        System.out.println("Ending task " + taskId);
        return sum;
    }

    public static void main(String[] args) {
        ExecutorService executerService = Executors.newCachedThreadPool();
        List<Future<Integer>> results = new ArrayList<Future<Integer>>();
        for (int i = 0; i < 3; i++) {
            FibonacciWithResult fibonacciWithResult = new FibonacciWithResult(5);
            results.add(executerService.submit(fibonacciWithResult));
        }
        for (Future<Integer> future: results) {
            try {
                // get() will block until complete
                System.out.println("Sum for task " + future.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}
