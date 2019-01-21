import java.io.*;
import java.util.Scanner;

/**
 * Created by mandarin on 04.03.2017.
 */


public class MainClass1 {
    public static boolean isTriangle(int a, int b, int c) {
        return ((a + b) > c) && ((a + c) > b) && ((b + c) > a);
    }

    public static void main(String[] args) {
        try {
            if (args.length != 4) {
                System.err.print("INVALID AMOUNT OF ARGUMENTS");
            }

            if ((args[0] == null) || (args[1] == null)) {
                throw new NullPointerException();
            }

//            File inputFile = new File(args[0]);
            File outputFile = new File(args[3]);

//            FileReader fr = new FileReader(inputFile);
            FileWriter fw = new FileWriter(outputFile);

//            Scanner sc = new Scanner(inputFile);
            Integer[] ints = new Integer[3];

            for (int i = 0; i < 3; ++i){
//                ints[i] = sc.nextInt();
                ints[i] = new Integer(args[i]);
                System.out.println("readed " + ints[i]);
                if (ints[i] == null){
                    throw new NullPointerException(
                            "INVALID COUNT OF ARGUMENTS. SIDES OF TRIANGLE EXPECTED.");
                }
            }

//            fw.write("Sides: " + ints[0] + ", " + ints[1] + ", " + ints[2] + '\n');
            System.out.println("Sides: " + ints[0] + ", " + ints[1] + ", " + ints[2] + '\n');

            if (isTriangle(ints[0], ints[1], ints[2])) {
                System.out.println("Sides form a triangle");
            } else {
                System.out.println("Sides don't form a triangle");
            }
            fw.close();
//            fr.close();

        } catch (NumberFormatException catchErr) {
            System.err.print("ARGUMENTS MUST ME INTEGER. VARIABLE " + catchErr + "ISN'T VALID NUMBER");
            System.exit(2);
        } catch (FileNotFoundException e) {
            System.err.println(e);
        } catch (IOException e) {
            System.err.println(e);
        } catch (NullPointerException e) {
            System.err.println(e);
        } catch (Exception e){
            System.err.println("INVALID ARGUMENTS. Something went wrong");
        }
    }
}