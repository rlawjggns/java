/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author kjh
 */
public abstract class DBManager {
    public static DBManager instance = null;
    Connection conn;
    
    public static DBManager getinstance() {
        return instance;
    }
    
    public DBManager() {
        loadDriver();
        openConnection();
    }
    
    public abstract void loadDriver();
    public abstract void openConnection();
    
    public void closeConnection() {
        try {
            conn.close();
        } catch (Exception e) {
            e.getStackTrace();
        }
    }
    
    public ArrayList<String[]> executeQuery(String sql) {
            System.out.println(sql);
            ArrayList<String[]> list = new ArrayList<>();
            Statement stmt = null;
            ResultSet rs= null;
            try {
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
            int count = rs.getMetaData().getColumnCount();
                while (rs.next()) {                    
                    String[] values = new String[count];
                    for (int i = 0; i < count; i++) {
                        values[i] = rs.getString(i+1);
                    }
                    list.add(values);
                }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return list;
//        System.out.println(sql);
//        ArrayList<String[]> list = new ArrayList<>();
//        Statement stmt = null;
//        ResultSet rs = null;
//        try {
//            stmt = conn.createStatement();
//            rs = stmt.executeQuery(sql);
//            int count = rs.getMetaData().getColumnCount();
//            while (rs.next()) {                
//                String[] values = new String[count];
//                for (int i = 0; i < count; i++) {
//                    values[i] = rs.getString(i+1);
//                }
//                list.add(values);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                rs.close();
//            } catch (Exception e) {
//            }
//            try {
//                stmt.close();
//            } catch (Exception e) {
//            }
//        }
//        return list;
    }

    public int executeUpdate(String sql) {
            int ret = -1;
            Statement stmt = null;
            try {
                stmt = conn.createStatement();
                ret= stmt.executeUpdate(sql);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
                try {
                    stmt.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        return ret;
//        int ret = -1;
//        Statement stmt = null;
//        try {
//            stmt = conn.createStatement();
//            ret = stmt.executeUpdate(sql);
//        } catch (Exception e) {
//            e.printStackTrace();    
//        } finally {
//            try {
//                stmt.close();
//            } catch (Exception e) {
//            }
//        }
//        return ret;
    }
}
