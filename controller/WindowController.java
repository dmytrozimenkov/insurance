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
clearTable();
    }

    public void remove() {

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
