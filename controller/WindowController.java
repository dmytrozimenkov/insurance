package sample.controller;

import sample.WindowManager;

public class WindowController {

    private WindowManager wm = WindowManager.getInstance();

    public void openNewButton(){
        wm.createWindow("view/TestTableWindow.fxml", "Table", 400, 300);
    }
}
