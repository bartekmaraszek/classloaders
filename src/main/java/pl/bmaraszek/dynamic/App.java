package pl.bmaraszek.dynamic;

public class App {

    private static ICounter counter1;
    private static ICounter counter2;

    public static void main( String[] args ) throws Exception {
        counter1 = CounterFactory.newInstance();

        while(true) {
            counter2 = CounterFactory.newInstance().copy(counter2);
            System.out.println("1. " + counter1.message() + " = " + counter1.increment());
            System.out.println("2. " + counter2.message() + " = " + counter2.increment());
            System.out.println();
            Thread.currentThread().sleep(2000);
        }
    }

}