package sample.tables.data;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sample.DB;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Clients extends Data{
    private SimpleStringProperty id;
    private SimpleStringProperty name;
    private SimpleStringProperty passport;

    private ObservableList<Clients> data = FXCollections.observableArrayList();

    public Clients(){

    }

    public Clients(int id, String name, String passport){
        this.id = new SimpleStringProperty(Integer.toString(id));
        this.name = new SimpleStringProperty(name);
        this.passport = new SimpleStringProperty(passport);
    }

    protected void getTableData(){
        DB db = new DB();
        db.openConnection();
        try{
            ResultSet rs = db.query("SELECT * FROM clients");
            while(rs.next()){
                data.add(new Clients(rs.getInt(1), rs.getString(2)
                        + " " + rs.getString(3)
                        + " " + rs.getString(4),
                        rs.getString(5)));
            }
            rs.close();
            db.closeConnection();
        } catch(SQLException ex){
            ex.printStackTrace();
        }
    }

    public ObservableList<Clients> getData(){
        getTableData();
        return data;
    }

    public String getId() {
        return id.get();
    }

    public SimpleStringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getPassport() {
        return passport.get();
    }

    public SimpleStringProperty passportProperty() {
        return passport;
    }

    public void setPassport(String passport) {
        this.passport.set(passport);
    }
}
