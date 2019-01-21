/**
 * Created by mandarin on 31.03.17.
 */
public abstract class OperationAbstract{
    Main.Operand left;
    Main.Operand right;
    OperationAbstract(Main.Operand left, Main.Operand right){
        this.right = right;
        this.left = left;

    }
    //public abstract double eval(double x);
}