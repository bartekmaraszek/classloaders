package pl.bmaraszek.dynamic;

public class Counter implements ICounter {

    private int counter;

    public String message() { return "DYNAMIC:::"; }
    public int getCounter() { return counter; }
    public int increment() { return counter++; }

    public ICounter copy(ICounter other) {
        if(other != null) counter = other.getCounter();
        return this;
    }
}
