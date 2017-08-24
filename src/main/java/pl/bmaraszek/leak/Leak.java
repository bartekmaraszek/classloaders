package pl.bmaraszek.leak;

public class Leak implements ILeak {

    private ILeak leak;

    public Leak(ILeak leak) {
        this.leak = leak;
    }

    @Override
    protected void finalize() {
        System.out.println("Leak GC-ed");
    }
}
