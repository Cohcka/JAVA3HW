package home_work_7;

import java.io.*;
import java.lang.reflect.*;
import java.net.*;

public class TestClass {

    public static void main(String[] args){
        try {
            start(new DemoClass());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        try {
            CheckHW();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void start(Object obj) throws IllegalAccessException, InvocationTargetException {
        Class ch = obj.getClass();
        Method[] methods = ch.getDeclaredMethods();

        int countAfter = 0;
        int countBefore = 0;

        for(Method o : methods) {
            if(o.isAnnotationPresent(BeforeSuite.class)){
                countBefore++;
                if(countBefore > 1){
                    throw new RuntimeException();
                }
            }else if(o.isAnnotationPresent(AfterSuite.class)){
                countAfter++;
                if(countAfter > 1){
                    throw new RuntimeException();
                }
            }
        }

        for(Method o : methods) {
            if(o.isAnnotationPresent(BeforeSuite.class)){
                o.getAnnotation(BeforeSuite.class);
                o.invoke(ch);
            }
        }

        for(Method o : methods) {
            if (o.isAnnotationPresent(Test.class)){
                o.getAnnotation(Test.class).priority();
                o.invoke(ch);
            }
        }

        for(Method o : methods){
            if (o.isAnnotationPresent(AfterSuite.class)) {
                o.getAnnotation(AfterSuite.class);
                o.invoke(ch);
            }
        }
    }

    public static void CheckHW () throws MalformedURLException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
        File file = new File("D:/123");
        String[] str = file.list();

        for (String  s : str) {
            String[] mass = s.split("\\.");
            if (!mass[1].equalsIgnoreCase("class")) {
                throw new RuntimeException(s, new Exception());
            }
            Class ch = URLClassLoader.newInstance(new URL[] {file.toURL()}).loadClass(mass[0]);
            Constructor constructor = ch.getConstructor(String.class);
            Object hw = constructor.newInstance();
            Method[] methods = ch.getDeclaredMethods();
            for(Method o : methods) {
                if(o.getName().indexOf("calculate") != -1){
                    o.invoke(hw,2, 3, 4, 5);
                }
            }



        }
    }
}
