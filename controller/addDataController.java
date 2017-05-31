package sample.controller;

import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import sample.DB;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by dmytrozimenkov on 27.05.17.
 */
public class addDataController {
    @FXML HBox hbox;
    private ArrayList<Control> elem1 = new ArrayList<>();
    public void test(int x){
      //  ArrayList <Control> elem1 = new ArrayList();
        for (int i=0;i<x;i++) {
            elem1.add(new TextField());
        }
//        elem.add(new TextField());
//        elem.add(new Button());
//        elem.add(new ComboBox<>());
//        elem.add(new TextField());
//        elem.add(new ComboBox<>());
        for(int i = 0;i<elem1.size();i++) {
//            hbox.getChildren().add(elem.get(i));
            hbox.getChildren().add(elem1.get(i));
        }
    }
    public void add(){
        DB db = new DB();
        db.openConnection();

        TextField tx1 = (TextField) elem1.get(1);
        TextField tx2 = (TextField) elem1.get(2);
        TextField tx3 = (TextField) elem1.get(3);
        TextField tx4 = (TextField) elem1.get(4);
        ComboBox cb = new ComboBox();
        TextField dd = (TextField) cb;
//        System.out.println(tx.getText());
//        System.out.println(elem1.get(1).getText());
//        System.out.println("INSERT INTO agent VALUES (null,"+ tx1.getText()+","+tx2.getText()+","+tx3.getText()+","+tx4.getText()+")");
        db.ins_query("INSERT INTO agent VALUES (null,"+"'"+ tx1.getText()+"'"+","+"'"+tx2.getText()+"'"+","+"'"+tx3.getText()+"'"+","+"'"+tx4.getText()+"'"+")");
       // hbox.getChildren().addAll(new Button());
    }
}
