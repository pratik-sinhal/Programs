public class OddEvenGenerator {
    int i;

    public OddEvenGenerator(int i) {
        this.i = i;
    }

    public int generateNumber() {
        return ++i;
    }
}


class OddGenerator implements Runnable {
    OddEvenGenerator generator;

    public OddGenerator(OddEvenGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (generator) {
                    while ((generator.i & 1) != 0)
                        generator.wait();
                    System.out.println(Thread.currentThread().getName() + ": " + generator.generateNumber());
                    generator.notify();
                }
            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}

class EvenGenerator implements Runnable {
    OddEvenGenerator generator;

    public EvenGenerator(OddEvenGenerator generator) {
        this.generator = generator;
    }

    @Override
    public void run() {
        try {
            while (!Thread.interrupted()) {
                synchronized (generator) {
                    while ((generator.i & 1) == 0)
                        generator.wait();
                    System.out.println(Thread.currentThread().getName() + ": " + generator.generateNumber());
                    generator.notify();
                }
            }
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}

class Test {
    public static void main(String[] args) {
        OddEvenGenerator generator = new OddEvenGenerator(0);
        new Thread(new OddGenerator(generator)).start();
        new Thread(new EvenGenerator(generator)).start();
    }
}


