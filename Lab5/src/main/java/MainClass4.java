
import java.util.ArrayList;

public class MainClass4 {

//    static File file;
//    static FileWriter fw;

    public static void print(String string) {
        try {
            System.out.println(string);

        } catch (Exception e){
            System.err.println("INVALID ARGUMENTS. Something went wrong: " + e);
        }

    }

    public static void main(String args[]) {
        try {

//            file = new File(args[2]);
//            fw = new FileWriter(file);


            if (args.length == 2) {
                int numberOfTeachers = Integer.parseInt(args[0]);
                int numberOfStudents = Integer.parseInt(args[1]);

                if (numberOfTeachers < 0 || numberOfStudents < 0) {
                    throw new InputExcept(1);
                }

                ArrayList<Students> arrayStudents[] = new ArrayList[numberOfTeachers];

                for (int i = 0; i < numberOfTeachers; i++) {
                    arrayStudents[i] = new ArrayList<Students>();
                }

                for (int i = 1, j = 0; i <= numberOfStudents; i++, j++) {
                    arrayStudents[j].add(new Students(("Student " + i)));

                    if (j == (numberOfTeachers - 1)) {
                        j = -1;
                    }
                }
//        for (int i = 0; i < numberOfTeachers; i++) {
//          for (int j = 0; j < arrayStudents[i].size(); j++) {
//            System.out.print(arrayStudents[i].get(j).thread.getName() + " ");
//          }
//          System.out.println();
//        }
                Teachers arrayTeachers[] = new Teachers[numberOfTeachers];

                for (int i = 0; i < numberOfTeachers; i++) {
                    arrayTeachers[i] = new Teachers(("Teacher " + (i + 1)), arrayStudents[i]);
                }

                if (numberOfTeachers != 1) {

                    for (int i = 0; i < numberOfTeachers; i++) {
                        if ((i + 1) != numberOfTeachers) {
                            arrayTeachers[i].setNext(arrayTeachers[i + 1]);
                        } else {
                            arrayTeachers[i].setNext(arrayTeachers[0]);
                        }
                    }
                } else {
                    arrayTeachers[0].setNext(null);
                }

                for (int i = 0; i < numberOfTeachers; i++) {
                    arrayTeachers[i].thread.start();
                }

                arrayTeachers[0].callNotify();

                try {

                    for (int i = 0; i < numberOfTeachers; i++) {
                        arrayTeachers[i].thread.join();
                    }

                } catch (InterruptedException e) {
                    System.err.println("INVALID ARGUMENTS. Something went wrong: " + e);
                }
                MainClass4.print("main ended");
            } else {
                throw new InputExcept(0);
            }

//            fw.close();

        } catch (InputExcept e) {
            System.err.print("Exception: " + e);

            for (String x : args) {
                System.err.print(" '" + x + "'");
            }

            System.exit(1);

        } catch (NumberFormatException e) {
            System.err.println("Exception: " + e);
        } catch (Exception e){
            System.err.println("INVALID ARGUMENTS. Something went wrong: " + e);
        }
    }
}
