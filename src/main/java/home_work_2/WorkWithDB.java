package home_work_2;

import java.sql.DriverManager;
import java.sql.*;

public class WorkWithDB {

    private static Connection connection;
    private static Statement statement;
    private final String file = "DZ_update.txt";

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
        select(tableName, "Marley");
        update(tableName, "Marley", 100);
        delete(tableName, "Bob");
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
        String sql = "SELECT score from " + tableName + " WHERE name = '" + studName + "';";
        try {
            ResultSet rs = statement.executeQuery(sql);
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

    private static void delete (String tableName, String studName){
        String sql = "DELETE from " + tableName + " WHERE name = '" + studName + "';";
        try {
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static void updateDataFromTXT(String tableName, String fileName){
    }

    private static void disconnect(){
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
