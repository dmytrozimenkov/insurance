package sample.tables.data;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.DB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Agents implements Data{

    private int ID;
    private String Name;

    private ObservableList<Agents> data = FXCollections.observableArrayList();

    public Agents(int ID, String Name){
        this.ID = ID;
        this.Name = Name;
    }

    public void getTableData(){
        DB db = new DB();
        db.openConnection();
        try {
            ResultSet rsTest = db.query("SELECT * FROM agent");
            while (rsTest.next()) {
                System.out.println(rsTest.getInt(1));
                System.out.println(rsTest.getString(2));
                System.out.println(rsTest.getString(3));
            }
            rsTest.close();
            db.closeConnection();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }

}
