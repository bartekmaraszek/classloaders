package pl.bmaraszek.leak;

public class AppLeak {

    private static ILeakyCounter counter1;
    private static ILeakyCounter counter2;

    public static void main(String[] args) throws Exception {
        counter1 = LeakyCounterFactory.newInstance();

        while(true) {
            counter2 = LeakyCounterFactory.newInstance().copy(counter2);
            System.out.println("1. " + counter1.message() + " = " + counter1.increment());
            System.out.println("2. " + counter2.message() + " = " + counter2.increment());
            System.out.println();
            Thread.currentThread().sleep(1000);
        }
    }
}
