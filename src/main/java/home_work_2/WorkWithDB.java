package home_work_2;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;

public class WorkWithDB {

    private static Connection connection;
    private static Statement statement;
    private static final String file = "DZ_update.txt";

    public static void main (String[] args){
        final String tableName = "Students";
        try {
            connect();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        createNewTable(tableName);
        insert(tableName, "Bob", 12);
        insert(tableName, "Marley", 75);
        insert(tableName, "Viki", 15);
        insert(tableName, "Mark", 55);
        insert(tableName, "Max", 5);
        insert(tableName, "Sid", 75);

        select(tableName, "Marley");
        update(tableName, "Marley", 100);
        delete(tableName, "Sid");
        updateDataFromTXT(tableName, file);
        disconnect();
    }

    private static void connect() throws ClassNotFoundException, SQLException {
        Class.forName("org.sqlite.JDBC");
        connection = DriverManager.getConnection("jdbc:sqlite:myDB.db");
        statement = connection.createStatement();
    }

    private static void createNewTable(String tableName){
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName + " ("
                + " id integer PRIMARY KEY,"
                + " name String NOT NULL,"
                + " score int NOT NULL);";
        try {
            statement.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void insert(String tableName, String studName, int score){
        String sql = "INSERT INTO " + tableName + "(name, score) VALUES(?,?);";
        try {
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString (1, studName);
            pstmt.setInt(2, score);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void select(String tableName, String studName){
        String sql = "SELECT id, name, score from " + tableName + " WHERE name = '" + studName + "';";
        try {
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()){
                System.out.println(rs.getInt(1)+ " " + rs.getString(2)+ " " + rs.getString(3));
            }
            // вывести на экран результаты поиска
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void update (String tableName, String studName, int setScore){
        String sql = "UPDATE " + tableName + " SET score = " + setScore + " WHERE name = '" + studName + "';";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void update (String tableName, String id, String setScore){
        String sql = "UPDATE " + tableName + " SET score = " + setScore + " WHERE id = " + id + ";";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void delete (String tableName, String studName){
        String sql = "DELETE from " + tableName + " WHERE name = '" + studName + "';";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateDataFromTXT(String tableName, String fileName){
        StringBuffer bodyFile = new StringBuffer();
        try {
            FileInputStream fis = new FileInputStream(fileName);
            int i;
            while ((i=fis.read()) != -1){
                bodyFile.append((char)i);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String[] data = bodyFile.toString().split("\n");
        String[][] data2 = new String[data.length][];
        for (int i = 0; i < data.length; i++) {
            data2[i] = data[i].split("  ", 3);
        }

        for (int i = 0; i < data2.length; i++) {
            update(tableName, data2[i][0], data2[i][2]);
        }
    }

    private static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
