/**
 * Created by mandarin on 16.05.17.
 */

import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Solution {
    // В качестве условной бесконечности
    // выберем достаточно большое число 10^9
    private static final int INF = 1000 * 1000 * 1000;

//    int vertexCount;
//
//    int[][] g = new int[vertexCount][vertexCount];
//    int[][] next = new int[vertexCount][vertexCount];


    public static void main(String[] args) {
        try {
            Solution solution = new Solution();

            File file = new File(args[0]);
            FileReader fr = new FileReader(file);
            // Вызываем процедуру решения задачи
            solution.solve(fr);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void showPath(int i, int j, int[][] g, int[][]next){
        if (g[i][j] == INF){
            System.out.println("No way found");
        }
        int c = i;
        while (c != j){
            System.out.print(" " + c);
            c = next[c][j];
        }
        System.out.print(" " + j);
    }

    private void solve(FileReader fr) {
        // Для считывания воспользуемся классом Scanner
        // Для вывода - классом PrintWriter
        try {

//        Scanner scanner = new Scanner(System.in);
            Scanner scanner = new Scanner(fr);
            PrintWriter printWriter = new PrintWriter(System.out);

            // Считываем число вершин графа
            int vertexCount = scanner.nextInt();


            // Граф будем хранить в матрице смежности
            int[][] g = new int[vertexCount][vertexCount];
            int[][] next = new int[vertexCount][vertexCount];

            for (int i = 0; i < vertexCount; i++) {
                for (int j = 0; j < vertexCount; j++) {
                    // Считываем вес ребра между вершинами
                    // i и j соответственно
                    g[i][j] = scanner.nextInt();

                    // По условию если g[i][j] = 0, то это
                    // означает, что дуги из i в j нет;
                    // в этом случае расстояние между этими
                    // вершинами бесконечно велико
                    if (g[i][j] == 0) {
                        g[i][j] = INF;
                    }
                }
            }


            // Согласно алгоритму будем обновлять
            // ответ для каждой пары вершин i и j,
            // перебирая промежуточную вершину k
            for (int k = 0; k < vertexCount; k++) {
                for (int i = 0; i < vertexCount; i++) {
                    for (int j = 0; j < vertexCount; j++) {
                        g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
//                        if ((g[i][k] + g[k][j]) < g[i][j]){
//                            g[i][j] = g[i][k] + g[k][j];
//                            next[i][j] = g[i][k];
//                        }
                    }
                }
            }

            for (int k = 0; k < vertexCount; k++) {
                for (int i = 0; i < vertexCount; i++) {
                    for (int j = 0; j < vertexCount; j++) {
                      //  g[i][j] = Math.min(g[i][j], g[i][k] + g[k][j]);
                        if ((g[i][k] + g[k][j]) < g[i][j]){
                            //g[i][j] = g[i][k] + g[k][j];
                            next[i][j] = g[i][k];
                        }
                    }
                }
            }

            // Для каждой пары вершин выведем величину
            // кратчайшего пути от i до j, или 0,
            // если j не достижима из i
            for (int i = 0; i < vertexCount; i++) {
                for (int j = 0; j < vertexCount; j++) {
                    if (g[i][j] == INF) {
                        printWriter.print(0 + " ");
                    } else {
                        printWriter.print(g[i][j] + " ");
                    }
                }

                printWriter.println();
            }
            printWriter.close();


//            showPath(2, 4, g, next);
            int i = 2;
            int j = 4;
            if (g[i][j] == INF){
                System.out.println("No way found");
            }
            int c = i;
            while (c != j){
                System.out.print(" " + c);
                c = next[c][j];
            }
            System.out.print(" " + j);

            scanner.close();


        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
