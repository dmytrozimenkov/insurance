package sample.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.TableBuilder;

public class TestTableController {
    @FXML
    private TableView tableView;

    public void add(){
        tableView.getColumns().addAll(new TableBuilder().buildTable("Agents", 2));
    }

    public void remove(){

    }

    public void edit(){

    }
}
