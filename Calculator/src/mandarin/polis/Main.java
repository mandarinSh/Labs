package mandarin.polis;

import java.io.File;
import java.io.FileWriter;

/**
 * Created by mandarin on 10.04.17.
 */
public class Main {

    public static void main(String[] args){//x=4       x = 2         ==-17         x=0             x=0,x=2
        String[] formulas = new String[] { "5+X" , "(5/3-X/3)*7", "-5+(4*(-3))", "(X)", "-5+)(", "5/X+(8-8)"};
        MyParser p = new MyParser();
        p.setVariable("X", 2.0 );

        try{
            File file = new File("res.txt");
            FileWriter fw = new FileWriter(file);

            for( int i = 5; i < formulas.length; i++){
                try{
                    //fw.write(p.Parse(formulas[i]));
                    System.out.println( formulas[i] + "=" + p.Parse( formulas[i] ) );
                }catch(Exception e){
                    System.err.println( "Error while parsing '"+formulas[i]+"' with message: " + e.getMessage() );
                }

                break;
            }
        }catch (Exception e){

        }
    }

}
