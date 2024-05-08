/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
/**
 *
 * @author kjh
 */
public class MySqlDBManager extends DBManager {
    
    public static DBManager getInstance() {
        if (instance == null) {
            instance = new MySqlDBManager();
        }
        return instance;
    }

    public MySqlDBManager() {
        super();
    }
    public void loadDriver() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void openConnection() {
        try {
            String url = "jdbc:mysql://192.168.0.23/projectA";
            String userId = "rlawjggns";
            String userPass = "1234";
            conn= DriverManager.getConnection(url, userId, userPass);
        } catch (Exception e) {
            e.printStackTrace();
        }
        }
}
