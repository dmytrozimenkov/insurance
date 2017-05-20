package sample.controller;

import sample.WindowManager;

/**
 * Created by dmytrozimenkov on 20.05.17.
 */
public class WindowController {

    private WindowManager wm = WindowManager.getInstance();

    public void openNewButton(){
        wm.createWindow("view/Window.fxml", "Window1", 800, 600);
    }
}
