import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.Scanner;

/**
 * Created by mandarin on 03.05.17.
 */
public class MyLabs extends JFrame {
    private JButton lab1Button = new JButton("Lab1");
    private JButton lab2Button = new JButton("Lab2");
    private JButton lab3Button = new JButton("Lab3");
    private JButton lab4Button = new JButton("Lab4");

    private JTextArea inputField = new JTextArea(3, 2);
    private JLabel inLabel = new JLabel("Input:");

    private static JTextArea outputField = new JTextArea(10, 2);
    private JLabel outLabel = new JLabel("Output:");

    private JLabel helpLabel1 = new JLabel("Lab1: Input File, Output File;");
    private JLabel helpLabel2 = new JLabel("Lab2: Output File;");
    private JLabel helpLabel3 = new JLabel("Lab3: Output File;");
    private JLabel helpLabel4 = new JLabel("Lab4: Teachers, Students, outFile;");


    private JScrollPane scrollPane = new JScrollPane(outputField);
//    private JPanel jPanel = new JPanel();

    String inputParams;
    Integer[] sides;

    public MyLabs() {
        super("MyLabs");
        this.setBounds(500, 200, 600, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();

        container.setLayout(new GridBagLayout());
        container.setBackground(Color.pink);

        container.add(helpLabel1, new GridBagConstraints(3, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        container.add(helpLabel2, new GridBagConstraints(3, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        container.add(helpLabel3, new GridBagConstraints(3, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));
        container.add(helpLabel4, new GridBagConstraints(3, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        container.add(inLabel, new GridBagConstraints(0, 4, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        inputField.setLineWrap(true);
        inputField.setBackground(Color.white);
        JScrollBar scroll = new JScrollBar();
        inputField.add(scroll);
        inputField.setWrapStyleWord(true);
        container.add(inputField, new GridBagConstraints(0, 5, 4, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        container.add(outLabel, new GridBagConstraints(0, 6, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        outputField.setMaximumSize(new Dimension(100,100));
        outputField.setAutoscrolls(true);
        outputField.setBackground(Color.white);
        outputField.setLineWrap(true);
        outputField.setWrapStyleWord(true);

//        container.add(outputField, new GridBagConstraints(2, 3, 1, 1, 1, 1,
//                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
//                new Insets(2, 2, 2, 2), 0, 0));

        scrollPane.createVerticalScrollBar();
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        container.add(scrollPane, new GridBagConstraints(0, 7, 4, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 40, 40));

        lab1Button.addActionListener(new ButtonEventListener1());
        container.add(lab1Button, new GridBagConstraints(0, 0, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        lab2Button.addActionListener(new ButtonEventListener2());
        container.add(lab2Button, new GridBagConstraints(0, 1, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        lab3Button.addActionListener(new ButtonEventListener3());
        container.add(lab3Button, new GridBagConstraints(0, 2, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

        lab4Button.addActionListener(new ButtonEventListener4());
        container.add(lab4Button, new GridBagConstraints(0, 3, 1, 1, 1, 1,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(2, 2, 2, 2), 0, 0));

//        jPanel.add(container);
//        jPanel.getAccessibleContext();
//
//        jPanel.setVisible(true);
    }


    class ButtonEventListener1 implements ActionListener {

        String inFileName, outFileName;

        private void newInstance() throws MalformedURLException, ClassNotFoundException,
                IllegalAccessException, NoSuchMethodException, InvocationTargetException {

            URL url = new File(".").toURI().toURL();
            String className = "MainClass1";
            ClassLoader cl = new URLClassLoader(new URL[]{url});
            Class clazz = Class.forName(className);
            Method method = clazz.getMethod("main", String[].class);
            method.invoke(null, (Object) new String[]{
                sides[0].toString(),
                sides[1].toString(),
                sides[2].toString(),
                inputParams
            });

        }

        public void actionPerformed(ActionEvent actionEvent) {
            try {
//                String inputParams;
                inputParams = inputField.getText();
//                inputParams += "  /home/mandarin/IdeaProjects/Lab5/src/main/java/isTriangle.txt";
//                Scanner scannerPath = new Scanner(inputParams);
//                inFileName = scannerPath.next();
//                outFileName = scannerPath.next();
//                File file = new File(outFileName);
//                this.newInstance();

                Scanner scanner = new Scanner(inputParams);
                for (int i = 0; i < 3; ++i){
                    sides[i] = scanner.nextInt();
                }
                inputParams = "/home/mandarin/IdeaProjects/Lab5/src/main/java/isTriangle.txt";
//                String outStr = "";
//                StringBuilder sBuilder = new StringBuilder(outStr);
//                while (scanner.hasNext()) {
//                    sBuilder.append(scanner.next());
//                    sBuilder.append(" ");
//                }
//                outputField.setText(sBuilder.toString());
                this.newInstance();

            } catch (Exception e) {
                System.out.println("INVALID ARGUMENTS. Something went wrong: " + e);
            }
        }
    }

    class ButtonEventListener2 implements ActionListener {

        String outFileName;
        File outputFile;

        private void newInstance() throws MalformedURLException, ClassNotFoundException,
                IllegalAccessException, NoSuchMethodException, InvocationTargetException {

            URL url = new File(".").toURI().toURL();
            String className = "MainClass2";
            ClassLoader cl = new URLClassLoader(new URL[]{url});
            Class clazz = Class.forName(className);
            Method method = clazz.getMethod("main", String[].class);
            method.invoke(null, (Object) new String[]{

            });

        }

        public void actionPerformed(ActionEvent actionEvent) {
            try {

//                outFileName = inputField.getText();
                outFileName = "/home/mandarin/IdeaProjects/Lab5/src/main/java/outLab2.txt ";
                outputFile = new File(outFileName);

                this.newInstance();
                Scanner scanner = new Scanner(outputFile);
                String outStr = "";
                StringBuilder sBuilder = new StringBuilder(outStr);

                while (scanner.hasNext()) {
                    sBuilder.append(scanner.nextLine());
                    sBuilder.append(" \n");

                }

                outputField.setText(sBuilder.toString());

            } catch (Exception e) {
                System.out.println("INVALID ARGUMENTS. Something went wrong: " + e);
            }
        }
    }

    class ButtonEventListener3 implements ActionListener {

        String outFileName;
        File outputFile;

        private void newInstance() throws MalformedURLException, ClassNotFoundException,
                IllegalAccessException, NoSuchMethodException, InvocationTargetException {

            URL url = new File(".").toURI().toURL();
            String className = "MainClass3";
            ClassLoader cl = new URLClassLoader(new URL[]{url});
            Class clazz = Class.forName(className);
            Method method = clazz.getMethod("main", String[].class);
            method.invoke(null, (Object) new String[]{
            });

        }

        public void actionPerformed(ActionEvent actionEvent) {
            try {

//                outFileName = inputField.getText();
                outFileName = " /home/mandarin/IdeaProjects/Lab5/src/main/java/outLab2.txt ";
                outputFile = new File(outFileName);

                this.newInstance();
                Scanner scanner = new Scanner(outputFile);
                String outStr = "";
                StringBuilder sBuilder = new StringBuilder(outStr);

                while (scanner.hasNext()) {
                    sBuilder.append(scanner.nextLine());
                    sBuilder.append(" \n");

                }

                outputField.setText(sBuilder.toString());

            } catch (Exception e) {
                System.out.println("INVALID ARGUMENTS. Something went wrong: " + e);
            }

        }
    }

    class ButtonEventListener4 implements ActionListener {
        String outFileName;
        File outputFile;
        String teachers, students;

        private void newInstance() throws MalformedURLException, ClassNotFoundException,
                IllegalAccessException, NoSuchMethodException, InvocationTargetException {

            URL url = new File(".").toURI().toURL();
            String className = "MainClass4";
            ClassLoader cl = new URLClassLoader(new URL[]{url});
            Class clazz = Class.forName(className);
            Method method = clazz.getMethod("main", String[].class);
            method.invoke(null, (Object) new String[]{
                    teachers,
                    students
            });


        }

        public void actionPerformed(ActionEvent actionEvent) {
            try {

                String inputString = inputField.getText();
                Scanner inScan = new Scanner(inputString);
                teachers = inScan.next();
                students = inScan.next();
//                outFileName = inScan.next();
                outFileName = " /home/mandarin/IdeaProjects/Lab5/src/main/java/outLab2.txt ";
                outputFile = new File(outFileName);

                this.newInstance();
                Scanner scanner = new Scanner(outputFile);
                String outStr = "";
                StringBuilder sBuilder = new StringBuilder(outStr);

                while (scanner.hasNext()) {
                    sBuilder.append(scanner.nextLine());
                    sBuilder.append(" \n");

                }

                outputField.setText(sBuilder.toString());

            } catch (Exception e) {
                System.out.println("INVALID ARGUMENTS. Something went wrong: " + e);
            }

        }
    }

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            MyLabs app = new MyLabs();
            app.setPreferredSize(new Dimension(600, 400));

            PrintStream printStream = new PrintStream(new CustomOutputStream(outputField));
            System.setOut(printStream);
            System.setErr(printStream);

            app.setVisible(true);

//            app.pack();
        } catch (Exception e) {
            System.out.println("INVALID ARGUMENTS. Something went wrong: " + e);
        }
    }

}
