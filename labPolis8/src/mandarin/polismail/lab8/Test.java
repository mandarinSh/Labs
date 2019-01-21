package mandarin.polismail.lab8;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.*;

/**
 * Created by mandarin on 05.05.17.
 */
public class Test {

    public static void createFields(Field[] fields, StringBuilder builder){
       try {
           if (fields == null){
               return;
           }
           String name;
           String type;
           int modifiers;

           for (Field field : fields) {

               name = field.getName();
               type = field.getType().toString();
               modifiers = field.getModifiers();

               builder.append("\n" + " ");
               builder.append(Modifier.toString(modifiers));
               builder.append(" " + type + " " + name + ";\n");
           }

       } catch (Exception e){
           System.out.println(e);
       }
    }

    public static void createConstructors(Constructor<?>[] constrs, StringBuilder builder, String className){
        try{

            String name;
//            String type;
            int modifiers;

            for (Constructor<?> constructor : constrs){
                name = className;
                modifiers = constructor.getModifiers();

                builder.append("\n ");
                builder.append(Modifier.toString(modifiers));
                builder.append(" " + name + "(");

                if (constructor.getParameterCount() != 0){
                    Class<?>[] parameters = constructor.getParameterTypes();
                    String paramType;
                    for(Class<?> params : parameters){
                        paramType = params.getClass().toString();
                        builder.append(paramType);
                    }
                }

                builder.append("){}\n");
            }


        } catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args) throws ClassNotFoundException, IOException {
//        String clazz = "java.lang.Object";

        String clazz = "java.lang.Integer";
        Class cls = Class.forName(clazz);

        String newClass = cls.getSimpleName() + "Impl";
        StringBuilder builder = new StringBuilder();
        builder.append("public class " + newClass);
        builder.append(" {");
        builder.append("\n");

        Field[] fields = cls.getDeclaredFields();
        Method[] methods = cls.getDeclaredMethods();
        Constructor<?>[] constrs = cls.getConstructors();

        createFields(fields, builder);
        createConstructors(constrs, builder, newClass);



        builder.append("}");

        System.out.println(builder.toString());

        File file = new File(newClass + ".java");
        file.createNewFile();
        try (FileWriter fw = new FileWriter(file)){
            fw.write(builder.toString());
        }

    }

}
