package sample.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import sample.DB;

import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginController {

    @FXML
    private TextField login;
    @FXML
    private TextField password;

    public void login_func()  {
        DB db = new DB();
        db.openConnection();
        ResultSet rs = db.query("SELECT id_agent, password FROM Agent WHERE id_agent = '" + login.getText() + "' AND password = '" + password.getText() + "'");

        } catch (SQLException ex){
            ex.printStackTrace();
        }

        db.closeConnection();
    }
}
