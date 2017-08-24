package pl.bmaraszek.dynamic;

public interface ICounter {
    String message();
    int getCounter();
    int increment();
    ICounter copy(ICounter other);
}
