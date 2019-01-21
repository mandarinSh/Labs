
public class Students implements Runnable {
    Thread thread;

    Students(String name) {
        this.thread = new Thread(this, name);
    }

    public void run() {
        System.out.println(" --- " + thread.getName());
    }
}
