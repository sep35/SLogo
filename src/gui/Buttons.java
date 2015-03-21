package gui;

//This entire file is part of my masterpiece.
//Steven Pierre

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import javafx.scene.image.Image;
import view.TurtleView;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Buttons {
	private static double HELP_WIDTH = 800;
	private static double HELP_HEIGHT = 500;

	protected static int factory(String value){
		if(value.equals("English")) return 0;
		if(value.equals("French")) return 1;
		return 0;
	}

	protected static void help() {
		Stage s = new Stage();
		s.setTitle("Basic SLogo Commands");
		Group g = new Group();
		Scene slogoHelp = new Scene(g, HELP_WIDTH, HELP_HEIGHT);
		WebView view = new WebView();
		view.getEngine().load("http://www.cs.duke.edu/courses/compsci308/current/assign/03_slogo/commands.php");
		g.getChildren().add(view);
		s.setScene(slogoHelp);
		s.show();

	}
	protected static String updateMovement(KeyEvent e){
		switch (e.getCode()) {
		case UP: return "fd 20"; 
		case RIGHT:	return "rt 20";
		case DOWN: return "bk 20"; 		
		case LEFT: return "lt 20"; 
		default: return "";
		}
	}
	protected static void changeImage(TurtleView turtle) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG", "*.jpg", "PNG", "*.png"));
		fileChooser.setInitialDirectory(new File(System.getProperty("user.dir")));
		File file = fileChooser.showOpenDialog(new Stage());
		try {
			Image image = new Image(new FileInputStream(file), 80, 60, true, true);
			turtle.setImage(image);
		} catch (IOException ex) {
		}
	}

	public static String status(List<String> status) {
		String fullHistory = "";
		for(int i = status.size(); i > 0; i--){
			fullHistory = fullHistory + status.get(i-1) + "\n";
		}
		return fullHistory;

	}
	public static void changeLang() {
		// TODO Auto-generated method stub
	}
}
