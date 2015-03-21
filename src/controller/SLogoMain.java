package controller;

import gui.GUIScene;
import javafx.application.Application;
import javafx.stage.Stage;

public class SLogoMain extends Application {

    public static void main(String[] args) {
	launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
	GUIScene guiScene = new GUIScene();
	guiScene.createScene(stage);
    }
}