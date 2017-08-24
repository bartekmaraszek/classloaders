package pl.bmaraszek.leak;

public class LeakyCounter implements ILeakyCounter {

    private int counter;
    private ILeak leak;

    private static final long[] cache = new long[100000];

    public String message() { return "Version 10"; }
    public int getCounter() { return counter; };
    public int increment() { return counter++; }

    public ILeakyCounter copy(ILeakyCounter other) {
        if(other != null) {
            counter = other.getCounter();
            leak = other.leak();
        }
        return this;
    }

    public ILeak leak() {
        return new Leak(leak);
    }

    @Override
    protected void finalize() {
        System.out.println("LeakyCounter GC-ed");
    }
}
