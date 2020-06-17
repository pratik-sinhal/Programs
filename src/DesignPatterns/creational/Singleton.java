package DesignPatterns.creational;

class Singleton
{
    private static final long serialVersionUID = 1L;

    private Singleton() {
        if(InstanceHolder.instance != null) {
            throw new IllegalStateException("instance already created");
        }
    }

    private static class InstanceHolder {
        private static final Singleton instance = new Singleton();
    }

    public static Singleton getInstance() {
        return InstanceHolder.instance;
    }

    protected Object readResolve() {
        return getInstance();
    }

    protected Object clone() throws CloneNotSupportedException {
        //throw new CloneNotSupportedException("Cloning of this class is not allowed");
        return getInstance();
    }

    public static void main(String[] args) {

    }
}
