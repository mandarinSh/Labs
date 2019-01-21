//package mandarin.polis;
//
//import java.util.EnumMap;
//
///**
// * Created by mandarin on 06.04.17.
// */
//
//public class Calculator {
//
//    interface Expression {
//        double evaluate(double value);
//    }
//
//
//    class Variable implements Expression {
//
//        @Override
//        public double evaluate(double value) {
//            return value;
//        }
//    }
//
//    abstract class BinaryOperation implements Expression {
//
//        Expression left;
//        Expression right;
//
//        BinaryOperation(Expression left,
//                        Expression right) {
//            this.left = left;
//            this.right = right;
//        }
//    }
//
//    class Add extends BinaryOperation {
//
//        Add(Expression left, Expression right) {
//            super(left, right);
//        }
//
//        @Override
//        public double evaluate(double x) {
//            return left.evaluate(x) + right.evaluate(x);
//        }
//    }
//
//    class Minus extends BinaryOperation {
//
//        Minus(Expression left, Expression right) {
//            super(left, right);
//        }
//
//        @Override
//        public double evaluate(double x) {
//            return left.evaluate(x) - right.evaluate(x);
//        }
//    }
//
//    class Multiply extends BinaryOperation {
//
//        Multiply(Expression left, Expression right) {
//            super(left, right);
//        }
//
//        @Override
//        public double evaluate(double x) {
//            return left.evaluate(x) * right.evaluate(x);
//        }
//    }
//
//    class Divide extends BinaryOperation {
//
//        Divide(Expression left, Expression right) {
//            super(left, right);
//        }
//
//        @Override
//        public double evaluate(double x) {
//            double rightResult = right.evaluate(x);
//            if (rightResult == 0.0) {
//                throw new DontDivideByZero("не делите на ноль");
//            }
//            return left.evaluate(x) / right.evaluate(x);
//        }
//    }
//
//    class Const implements Expression {
//
//        private final int value;
//
//        public Const(int value) {
//            this.value = value;
//        }
//
//        @Override
//        public double evaluate(double value) {
//            return value;
//        }
//    }
//
//    class Bracket implements Expression {
//
//        @Override
//        public double evaluate(double value) {
//            //char zeroChar =
//        }
//    }
//
//    /*
//    void evaluation(double x) {
//        // (2 + (x * 3))
//        double result = new Add(new Const(2),
//                new Multiply(new Variable(), new Const(3))).evaluate(1);
//        System.out.println(result);
//    }
//    */
//
//    //end of primitives
//
//
//
//    /**
//     * Функция, принимающая на вход арифметическое выражение и возвращающая объект типа
//     * {@link Expression}.
//     * @param input входное арифметическое выражение
//     * @return распаршенное выражение в виде {@link Expression}
//     */
//    Expression parse(String input) {
//        Expression result = null;
//        // парсим строку input в result
//
//
//
//        return result;
//    }
//
//    void run() {
//        Expression test1 = parse("5 ** (x)");
//        System.out.println(test1.evaluate(5)); // Output: "Некорректная запись"
//
//        Expression test2 = parse("-3 * x + 4");
//        System.out.println(test1.evaluate(5)); // Output: -11
//
//        Expression test3 = parse("5 *      ( x - 2 ) +      3");
//        System.out.println(test1.evaluate(5)); // Output: 18
//    }
//
//    public static void main(String[] args){
//        new Calculator().run();
//    }
//}
