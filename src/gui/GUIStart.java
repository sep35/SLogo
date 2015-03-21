package gui;

import javafx.application.Application;
import javafx.stage.Stage;

public class GUIStart extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		GUIScene turtle = new GUIScene();
		turtle.createScene(stage);

	}

}
