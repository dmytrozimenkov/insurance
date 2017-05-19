import java.sql.*;

/**
 * Created by yolo on 20.05.17.
 */
public class DB {

    private Connection  con;
    private Statement   stmt;

    private static final String DB_URL     = "";
    private static final String DB_USER    = "";
    private static final String DB_PASS    = "";

    private boolean connection = false;

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
        ResultSet rs;
        if(connection){
            try {
                rs = stmt.executeQuery(query);
                rs.close();
            } catch(SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
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
