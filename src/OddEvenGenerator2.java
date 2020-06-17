public class OddEvenGenerator2 {
    private volatile boolean isEven;

    public OddEvenGenerator2(boolean isEven) {
        this.isEven = isEven;
    }

    public synchronized void printOdd(int i) {
        while(isEven) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+": "+i);
        isEven = true;
        notify();
    }

    public synchronized void printEven(int i) {
        while(!isEven) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(Thread.currentThread().getName()+": "+i);
        isEven = false;
        notify();
    }
}


class OddEvenTask implements Runnable {
    boolean isEven;
    OddEvenGenerator2 g;

    public OddEvenTask(boolean isEven, OddEvenGenerator2 g) {
        this.isEven = isEven;
        this.g = g;
    }

    @Override
    public void run() {
        int i = isEven ? 0 : 1;
        while (!Thread.interrupted()) {
            if(isEven) {
                g.printEven(i);
            } else {
                g.printOdd(i);
            }
            i += 2;
        }
    }
}


class Test2 {
    public static void main(String[] args) {
        OddEvenGenerator2 g = new OddEvenGenerator2(true);
        new Thread(new OddEvenTask(true, g),"EVEN").start();
        new Thread(new OddEvenTask(false, g),"ODD").start();
    }
}
