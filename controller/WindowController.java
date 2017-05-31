package sample.controller;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import sample.DB;
import sample.TableBuilder;
import sample.WindowManager;
import sample.tables.data.Agents;
import sample.tables.data.Clients;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WindowController {

    private WindowManager wm = WindowManager.getInstance();

    public void clients(){
        //wm.createTableWindow("Clients", "Клиенты", 4);

        buildTable("Clients", 1);
    }

    public void agents(){
        buildTable("Agents", 1);
      //  wm.createTableWindow("Agents", "Агенты", 2);
    }

    public void exit(){
        wm.closeAll();
    }

    public void clearTable(){
        tableView.getColumns().removeAll();
    }

//______________________________________________________________________________________________//



    @FXML
    private TableView tableView;
    private TableColumn[] cols;
    private ObservableList data;
    private String tableName;


    public void add(){
//        for ( int i = 0; i<tableView.getItems().size(); i++) {
//            tableView.getItems().clear();
//        }
//        data.removeAll();
//        System.out.println(data.size());
//
//
//clearTable();
//        DB db = new DB();
//        db.openConnection();
//     //   db.ins_query("INSERT INTO agent VALUES(null,'test','ttt','xxx','4');");
//        //db.ins_query("UPDATE agent set first_name = 'huiasdada' WHERE id_agent = 8;");
//
//        db.ins_query("INSERT INTO agent VALUES(null,'test','ttt','xxx','4');");
//        db.closeConnection();
//        tableView.getColumns().clear();
//        buildTable("Agents",2);

    TableBuilder tb = new TableBuilder();
        try {
            tb.bbb("Agents1",1);
      //      tb.bbb("Clients",1);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void remove() throws SQLException {
        TableBuilder tb = new TableBuilder();
        tb.bbb("Agents1",1);


    }

    public void edit() {

    }

    public void buildTable(String tableName, int columns){
        this.tableName = tableName;
        switch(tableName){
            case "Agents":
                clearTable();
                data = new Agents().getData();
                cols = new TableBuilder<Agents>().buildTable("Agents", 2);
                break;
            case "Clients":
                clearTable();
                data = new Clients().getData();
                cols = new TableBuilder<Clients>().buildTable("Clients", 3);
                break;
            default:
                System.out.println("IDI NAHUY");
        }
        tableView.setItems(data);
        tableView.getColumns().addAll(cols);
    }
}
