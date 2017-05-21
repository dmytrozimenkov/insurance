package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.TableBuilder;

import java.net.URL;
import java.util.ResourceBundle;

public class TestTableController {
    @FXML
    private TableView tableView;

    public void add() {

    }

    public void remove() {

    }

    public void edit() {

    }

    public void buildTable(String tableName, int columns){
        tableView.getColumns().addAll(new TableBuilder().buildTable(tableName, columns));
    }
}