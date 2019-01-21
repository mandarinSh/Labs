/**
 * Created by mandarin on 04.03.2017.
 */


public class Main {
    public static boolean isTriangle(int a, int b, int c) {
        return ((a + b) > c) && ((a + c) > b) && ((b + c) > a);
    }

    public static void main(String[] args) {
        try {
            if (args.length != 3) {
                System.err.print("INVALID AMOUNT OF ARGUMENTS");
            }

            if ((args[0] == null) || (args[1] == null)) {
                throw new NullPointerException();
            }

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


        } catch (NumberFormatException catchErr) {
            System.err.print("ARGUMENTS MUST ME INTEGER. VARIABLE " + catchErr + "ISN'T VALID NUMBER");
            System.exit(2);

        } catch (NullPointerException e) {
            System.err.println(e);
        } catch (Exception e){
            System.err.println("INVALID ARGUMENTS. Something went wrong");
        }
    }
}