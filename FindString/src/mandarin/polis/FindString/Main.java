package mandarin.polis.FindString;

import java.io.*;

/**
 * Created by mandarin on 28.04.17.
 */


//java RecursiveGrep <входной файл> <выходной файл> <искомая строка>

public class Main {
    public static void main(String[] args){
        try{
            if (args.length != 3) {
                throw new IllegalStateException();
            }

            //искомая строка
            String requiredString = args[2];
            if (requiredString == null){
                throw new NullPointerException();
            }

            //чтение из файла, в котором пути до файлов поиска
            LineNumberReader lineReader = new LineNumberReader(
                    new BufferedReader(
                            new FileReader(args[0])));


            //выходной файл, в нем найденные строки
            File outFile = new File(args[1]);
            if (!outFile.exists()){
                throw new IOException();
            }
            FileWriter fw = new FileWriter(outFile);


            String fileTextName;
            while ((fileTextName = lineReader.readLine()) != null) {

                //read from file required string
                LineNumberReader lineTextReader = new LineNumberReader(
                        new BufferedReader(
                                new FileReader(fileTextName)));

                String tmpString;
                for (; ; ) {
                    tmpString = lineTextReader.readLine();
                    if (tmpString == null) {
//                    throw new IOException();
                        break;
                    }

                    if (tmpString.contains(requiredString)) {
                        fw.write("line #" + lineReader.getLineNumber() + " " + fileTextName + '\n');
                    }

                }
            }

            fw.close();
            lineReader.close();

        }catch(Exception e){
            System.out.println(e);
        }

    }
}
