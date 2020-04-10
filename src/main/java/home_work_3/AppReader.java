package home_work_3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class AppReader {
    public static void main(String[] args) {
        File file = new File("src/main/java/home_work_3/data/book.txt");
        long t = System.currentTimeMillis();
        try(FileInputStream fis = new FileInputStream(file)){
            byte[] arr = new byte[1800];
            int x;

            while((x = fis.read(arr)) > 0){
                System.out.println(new String(arr, 0, x));
            }
        } catch (IOException e){
            e.printStackTrace();
        }
        System.out.println("Время выполнения: " + (System.currentTimeMillis() - t));
    }
}
