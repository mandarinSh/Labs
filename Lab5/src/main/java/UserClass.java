/**
 * Created by mandarin on 06.03.2017.
 */

public class UserClass {
    private volatile int value = 0;
    private volatile int count = 0;

    public synchronized void inc10() {
        value += 10;
        count++;
//        System.out.println("value = " + value + " " + Thread.currentThread().getName() + "  " + count);
          MainClass3.print("value = " + value + " " + Thread.currentThread().getName() + "  " + count + '\n');
           try {
                this.wait();
            } catch(final InterruptedException e){
               System.exit(1);
            }

        notify();
    }
    public synchronized void inc1000(){
        value += 1000;
        count++;
        MainClass3.print("value = " + value + " " + Thread.currentThread().getName() + "  " + count + '\n');
        notify();
            try {
                this.wait();
            } catch (final InterruptedException e) {
                System.exit(1);
            }

    }
}
