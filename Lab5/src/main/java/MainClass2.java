/**
 * Created by mandarin on 04.03.2017.
 */
public class MainClass2 {
//    static File file;
//    static FileWriter fw;

    public static void print(String string) {
        try {
            System.out.println(string);

        } catch (Exception e){
            System.err.println(e);
        }

    }

    public static void main(String[] args){
        try {

//            if (args.length != 1) {
//                fw.write("INVALID AMOUNT OF ARGUMENTS");
//            }

//            file = new File(args[0]);
//            fw = new FileWriter(file);

            B b = new B();
            b.b1();
            b.i2();
            b.a1();
            b.i1();

            MainClass2.print("\n");

            I1 iClass;
            iClass = b;
            ((B) iClass).b1();
            ((B) iClass).i2();
            ((B) iClass).a1();
            ((B) iClass).i1();

//            fw.close();
        } catch (Exception e) {
            System.err.println("INVALID ARGUMENTS. Something went wrong: " + e);
        }

    }
}
