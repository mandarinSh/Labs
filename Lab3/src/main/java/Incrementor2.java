/**
 * Created by mandarin on 06.03.2017.
 */

public class Incrementor2 implements Runnable {
    UserClass userClass;
    int param;

    Incrementor2 (UserClass userClass, int param){
        this.userClass = userClass;
        this.param = param;
    }
    @Override
    public void run(){
            for (int i = 0; i < param; ++i) {
                userClass.inc1000();
            }
    }
}
