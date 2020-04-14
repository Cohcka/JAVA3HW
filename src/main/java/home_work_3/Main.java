package home_work_3;

import java.io.*;
import java.util.*;

public class Main {
    public static void main (String[] args){
        File path = new File ("src/main/java/home_work_3/data");
        File fileTXT = new File ("src/main/java/home_work_3/data/text.txt");

        // Create file and write
        try {
            if(!fileTXT.exists()){
            path.mkdirs();
            fileTXT.createNewFile();
            }
            FillCharFile(60, fileTXT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Read file
        try {
            readFileToConsole(fileTXT);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Create 5 files
        File file1 = new File("src/main/java/home_work_3/data/text1.txt");
        File file2 = new File("src/main/java/home_work_3/data/text2.txt");
        File file3 = new File("src/main/java/home_work_3/data/text3.txt");
        File file4 = new File("src/main/java/home_work_3/data/text4.txt");
        File file5 = new File("src/main/java/home_work_3/data/text5.txt");
        try {
            file1.createNewFile();
            FillCharFile(100, file1);
            file2.createNewFile();
            FillCharFile(100, file2);
            file3.createNewFile();
            FillCharFile(100, file3);
            file4.createNewFile();
            FillCharFile(100, file4);
            file5.createNewFile();
            FillCharFile(100, file5);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // File merge
        File resultFile = new File("src/main/java/home_work_3/data/result_File.txt");
        try {
            if(resultFile.exists()){
                resultFile.delete();
            }
            resultFile.createNewFile();
            ArrayList<InputStream> al = new ArrayList<>();
            al.add(new FileInputStream(file1));
            al.add(new FileInputStream(file2));
            al.add(new FileInputStream(file3));
            al.add(new FileInputStream(file4));
            al.add(new FileInputStream(file5));

            SequenceInputStream sis = new SequenceInputStream(Collections.enumeration(al));
            FileOutputStream fos = new FileOutputStream(resultFile,true);
            int x;
            while((x = sis.read()) != -1){
                fos.write((char) x);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void FillCharFile (int size, File file) throws IOException {
        StringBuffer data = new StringBuffer();
        for(int i = 0; i < size-1; i++){
            Random rnd = new Random();
            data.append((char)(rnd.nextInt(26)+65));
        }
        FileWriter wrt = new FileWriter(file);
        BufferedWriter bwrt = new BufferedWriter(wrt);
        bwrt.write(data.toString(), 0, size-1);
        bwrt.flush();
        bwrt.close();
        wrt.close();
    }

    public static void readFileToConsole (File file) throws IOException {
        FileReader fr = new FileReader(file);
        BufferedReader bfr = new BufferedReader(fr);

        String currentLine;
        System.out.print("Read from file: ");
        while((currentLine = bfr.readLine()) != null){
            System.out.println(currentLine);
        }
        bfr.close();
        fr.close();
    }
}
