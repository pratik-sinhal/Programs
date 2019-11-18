package concurrency.exercise2;

/**
 * public class Fibonacci implements Generator<Integer> {
     private int count = 0;
     public Integer next() { return fib(count++); }
     private int fib(int n) {
     if(n < 2) return 1;
     return fib(n-2) + fib(n-1);
     }
     public static void main(String[] args) {
     Fibonacci gen = new Fibonacci();
     for(int i = 0; i < 18; i++)
     System.out.print(gen.next() + " ");
     }
 }
 */
public class Fibonacci implements Runnable, Generator<Integer> {
    private Integer count;
    private static Integer taskCount = 0;
    private final Integer taskId = taskCount++;

    public Fibonacci(Integer count) {
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
    public void run() {
        System.out.println("Starting task " + taskId);
        for (int i = 0; i < count; i++) {
            System.out.println("Task " + taskId + " next fibonacci is " + next(i));
            Thread.yield();
        }
        System.out.println("Ending task " + taskId);
        return;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(new Fibonacci(5));
            t.start();
        }
        System.out.println("Starting program execution");
    }
}
