package sample;

import javax.xml.transform.Result;
import java.sql.*;

/**
 * Created by yolo on 20.05.17.
 */
public class DB {

    private Connection  con;
    private Statement   stmt;

    private static final String DB_URL     = "jdbc:mysql://localhost:3306/insurance";
    private static final String DB_USER    = "root";
    private static final String DB_PASS    = "";

    private boolean connection = false;

    public static void main(String[] args) throws SQLException{
        DB db = new DB();
        db.openConnection();
        ResultSet rsTest = db.query("SELECT * FROM agent");
        while(rsTest.next()){
            System.out.println(rsTest.getInt(1));
            System.out.println(rsTest.getString(2));
            System.out.println(rsTest.getString(3));
        }
        rsTest.close();
        db.closeConnection();
    }

    public void openConnection(){
        if(!connection) {
            try {
                con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS);
                stmt = con.createStatement();
                connection = true;
                System.out.println("Successfully connected");
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else System.out.println("Connection is already established");
    }

    public ResultSet query(String query){
        ResultSet rs = null;
        if(connection){
            try {
                rs = stmt.executeQuery(query);
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return rs;
    }

    public void closeConnection(){
        if(connection) {
            try{
                con.close();
                stmt.close();
                System.out.println("Connection closed");
            } catch(SQLException ex){
                ex.printStackTrace();
            }
        } else System.out.println("Connection is not established");
    }
}
