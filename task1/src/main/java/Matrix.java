/**
 * Created by mandarin on 15.05.17.
 */
public class Matrix {

    public static void main(String[] args){
        try {

            if ((args.length != 1) || (args[0] == null)){
                throw new NullPointerException();
            }

            int dim = Integer.parseInt(args[0]);
            int[][] matrix = new int[dim][dim];

            for (int i = 0; i < dim; ++i){
                for (int j = 0; j < dim; ++j){
                    if ((i == j) || ((i + j) == (dim - 1))){
                        matrix[i][j] = 1;
                    } else {
                        matrix[i][j] = 0;
                    }
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println('\n');
            }


        } catch (Exception e){
            System.err.println(e);
        }
    }

}
