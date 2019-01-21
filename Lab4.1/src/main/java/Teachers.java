

import java.util.ArrayList;

class Teachers implements Runnable {

    Thread thread;
    Teachers next;
    private ArrayList<Students> students;

    Teachers(String name, ArrayList<Students> students) {
        this.thread = new Thread(this, name);
        this.students = students;
        //System.out.println(thread.getName());
    }

    void setNext(Teachers next) {
        this.next = next;
    }

    int getNumberOfStudents() {
        return students.size();
    }

    synchronized void callNotify() {
        notify();
    }

    void callStudent() {
        students.get(0).thread.start();

        try {
            students.get(0).thread.join();
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        students.remove(0);
    }

    synchronized public void run() {

        if (next != null) {
            try {
                wait();
            } catch (InterruptedException e) {
                System.out.println(e);
            }

            while (students.size() != 0) {
                System.out.print(thread.getName());
                callStudent();
                next.callNotify();

                try {
                    wait();
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }

            next.callNotify();
        } else {

            while (students.size() != 0) {
                System.out.print(thread.getName());
                callStudent();
            }

        }
        //System.out.println("Ended: " + thread.getName());
    }
}
