package sample.controller;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.DB;
import sample.TableBuilder;
import sample.WindowManager;
import sample.tables.data.Agents;
import sample.tables.data.Clients;

import java.sql.Statement;

public class TableController {

    private WindowManager wm = WindowManager.getInstance();

    @FXML
    private TableView tableView;
    private TableColumn[] cols;
    private ObservableList data;
    private String tableName;

    public void add(){
//        wm.createWindow("view/addData.fxml", "add", 350, 150);
//        DB db = new DB();
//        db.openConnection();
//     //   db.ins_query("INSERT INTO agent VALUES(null,'test','ttt','xxx','4');");
//        db.ins_query("UPDATE agent set first_name = 'huiasdada' WHERE id_agent = 8;");
//        db.closeConnection();
    }

    public void remove() {

    }

    public void edit() {

    }

    public void buildTable(String tableName, int columns){
        this.tableName = tableName;
        switch(tableName){
            case "Agents":
                data = new Agents().getData();
                cols = new TableBuilder<Agents>().buildTable("Agents", 2);
                break;
            case "Clients":
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