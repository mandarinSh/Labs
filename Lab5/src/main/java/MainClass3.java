/**
 * Created by mandarin on 04.03.2017.
 */
public class MainClass3 {
//
//    static File file;
//    static FileWriter fw;

    public static void print(String string) {
        try {
            System.out.println(string);

        } catch (Exception e){
            System.err.println(e);
        }

    }

    public static void main(String[] args) {

        try {

//            if (args.length != 1) {
//                fw.write("INVALID AMOUNT OF ARGUMENTS");
//            }
//
//            file = new File(args[0]);
//            fw = new FileWriter(file);

            UserClass userClass = new UserClass();
            int parameter = 1000;

            Incrementor1 thread1 = new Incrementor1(userClass, parameter);
            Thread thread2 = new Thread(new Incrementor2(userClass, parameter));

            thread1.start();
            thread2.start();

            //fw.close();

        } catch (Exception e){
            System.err.println("INVALID ARGUMENTS. Something went wrong: " + e);
        }
    }
}
