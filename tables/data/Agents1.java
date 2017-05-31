package sample.tables.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.DB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Agents1 extends Data{

    private SimpleStringProperty id;
    private SimpleStringProperty name;

    private ObservableList<Agents1> data = FXCollections.observableArrayList();

    public Agents1(){

    }

    public Agents1(int ID, String s, String rsTestString, String string, String Name){
        this.id = new SimpleStringProperty(Integer.toString(ID));
        this.name = new SimpleStringProperty(Name);
    }

    protected void getTableData(){
        DB db = new DB();
        db.openConnection();
        try {
            ResultSet rsTest = db.query("SELECT * FROM agent");
            while (rsTest.next()) {
                System.out.println(rsTest.getInt(1) + " " + rsTest.getString(2) + " " + rsTest.getString(3));
                data.add(new Agents1(rsTest.getInt(1), rsTest.getString(2),rsTest.getString(3), rsTest.getString(4),rsTest.getString(5)));
            }
            rsTest.close();
            db.closeConnection();
        } catch(SQLException ex) {
            ex.printStackTrace();
        }
    }

    public ObservableList<Agents1> getData(){
        getTableData();
        return data;
    }


    public String getId() {
        return id.get();
    }


    public String getName() {
        return name.get();
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public void setName(String name) {
        this.name.set(name);
    }
}
