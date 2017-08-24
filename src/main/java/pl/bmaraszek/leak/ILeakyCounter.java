package pl.bmaraszek.leak;

public interface ILeakyCounter {
    String message();
    int getCounter();
    int increment();
    ILeakyCounter copy(ILeakyCounter other);
    ILeak leak();
}
