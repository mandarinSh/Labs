/**
 * Created by mandarin on 31.03.17.
 */
public class Main {

    interface Operand{

        double eval();

    }

    public class Divide extends OperationAbstract{

        Divide(Operand left, Operand right){
            super(left, right);
        }

        @Override
        public double eval(double x){
            return left.eval(x) / right.eval(x);
        }

    }

    public class Minus extends OperationAbstract{

        private int operand1, operand2;
        double result;

        Minus(int operand1, int operand2){
            this.operand1 = operand1;
            this.operand2 = operand2;
            this.result = operand1 - operand2;
        }

        @Override
        public double eval(){
            return result;
        }

    }

    public class Multiple extends OperationAbstract{

        private int operand1, operand2;
        double result;

        Multiple(int operand1, int operand2){
            this.operand1 = operand1;
            this.operand2 = operand2;
            this.result = operand1 * operand2;
        }

        @Override
        public double eval(){
            return result;
        }

    }

    public class Variable implements Operand{



        @Override
        public double eval(double x) {
            return x;
        }

    }

    public class Add extends OperationAbstract{

        private int operand1, operand2;
        double result;

        int Add(int operand1, int operand2){
            this.operand1 = operand1;
            this.operand2 = operand2;
            this.result = operand1 + operand2;
        }

        @Override
        public double eval(double x){
            return left.eval(x) + right.eval(x);
        }

    }

    public class Const implements Operand{

        double value;

        Const(int value){
            this.value = value;
        }

        @Override
        public double eval() {
            return value;
        }
    }

    public static void main(String[] args){

        // (x^2 + 40*x - 50) / 10
        int x = 2;

        new Divide(new Minus(new Add(new Multiple(new Variable(), new Variable()),
                new Multiple(new Variable(), new Const(40))), new Const(50)),
                new Const(10)).eval(x);
    }
}
