package sample.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class LoginController {

    @FXML
    private TextField login;
    @FXML
    private TextField password;

    public void login_func()  {
        System.out.println("hui");
    }
}
