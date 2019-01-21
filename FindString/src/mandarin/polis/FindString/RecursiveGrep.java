package mandarin.polis.FindString;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by mandarin on 28.04.17.
 */

public class RecursiveGrep {

    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            throw new IllegalStateException();
        }

        //искомая строка
        String requiredString = args[2];
        if (requiredString == null) {
            throw new NullPointerException();
        }
        //выходной файл, в нем найденные строки
        File outFile = new File(args[1]);
        if (!outFile.exists()){
            throw new IOException();
        }
        FileWriter fw = new FileWriter(outFile);

        //чтение из файла, в котором пути до файлов поиска
        LineNumberReader lineReader = new LineNumberReader(
                new BufferedReader(
                        new FileReader(args[0])));

        String fileTextName;
        while ((fileTextName = lineReader.readLine()) != null) {
            Path path = Paths.get(fileTextName);
            Files.walkFileTree(path, new SimpleFileVisitor<Path>() {
                //указываем откуда начтнаем, сама заходит в файл

                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    //read from file required string
                    LineNumberReader lineTextReader = new LineNumberReader(
                            new BufferedReader(
                                    new FileReader(file.toFile())));

                    String tmpString;
                    for (; ; ) {
                        tmpString = lineTextReader.readLine();
                        if (tmpString == null) {
//                    throw new IOException();
                            break;
                        }

                        if (tmpString.contains(requiredString)) {
                            fw.write("line #" + lineReader.getLineNumber() + " " + file + '\n');
                        }

                    }

                    return FileVisitResult.CONTINUE;
                }
            });
        }
    }


}