/**
 * Created by mandarin on 04.03.2017.
 */
public class MainClass {
    public static void main(String[] args) {
        UserClass userClass = new UserClass();
        int parameter = 1000;

        Incrementor1 thread1 = new Incrementor1(userClass, parameter);
        Thread thread2 = new Thread(new Incrementor2(userClass, parameter));

        thread1.start();
        thread2.start();
    }
}
