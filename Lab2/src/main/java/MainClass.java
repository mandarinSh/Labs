/**
 * Created by mandarin on 04.03.2017.
 */
public class MainClass {
    public static void main(String[] args){
        B b = new B();
        b.b1();
        b.i2();
        b.a1();
        b.i1();

        System.out.println();

        I1 iClass;
        iClass = b;
        ((B) iClass).b1();
        ((B) iClass).i2();
        ((B) iClass).a1();
        ((B) iClass).i1();

    }
}
