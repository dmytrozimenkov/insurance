package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.DB;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;


public class LoginController {

    @FXML
    private TextField login;
    @FXML
    private TextField password;

    public void login_func()  throws Exception{

        DB db = new DB();
        db.openConnection();
        ResultSet rs = db.query("SELECT id_agent, password FROM Agent WHERE id_agent = '" + login.getText() + "' AND password = '" + password.getText() + "'");
        try{
            if (!rs.isBeforeFirst() ) {
                System.out.println("No data");
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Неправильный id/пароль");
                alert.setHeaderText("Ошибка входа");
                alert.initStyle(StageStyle.TRANSPARENT);
                alert.showAndWait();

            } else {

                while (rs.next()) {
                    try {
                        // AnchorPane pane = (AnchorPane) FXMLLoader.load(getClass().getResource("window.fxml"));
                        Parent root = FXMLLoader.load(getClass().getResource("../view/window.fxml"));
                        Stage stage = new Stage();
                        stage.setScene(new Scene(root, 800, 600));
                        stage.show();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println(rs.getInt(1));
                    System.out.println(rs.getString(2));
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

            db.closeConnection();
        }
    }
