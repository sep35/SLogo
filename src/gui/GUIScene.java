package gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Locale;
import java.util.ResourceBundle;

import controller.MainController;
import exceptions.ParsingException;
import simulationObjects.Pen;
import simulationObjects.Point;
import view.TurtleView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class GUIScene {
	/**
	 * Application scene is managed in this class
	 * @author Steven Pierre
	 * @author Kevin Rhine
	 * @model cellsociety_team15
	 */
	private Locale[] supportedLocales = { new Locale("en", "US", "English"), new Locale("fr", "FR", "French")};
	private Text statusText = new Text();
	protected TurtleView turtle = new TurtleView(new Image(getClass().getResourceAsStream("../images/turtle.png"), 80, 60, true, true));
	protected String userCommand = new String();
	private GridPane playground = new GridPane();
	private MainController controller = new MainController();
	private static double SCENE_WIDTH = 1280;
	private static double SCENE_HEIGHT = 720;
	private static double WRAP_LENGTH = 150;
	private static double WRAP_HEIGHT = 720 / 4;
	private static double HELP_WIDTH = 800;
	private static double HELP_HEIGHT = 500;
	private ReadAndWrite saver = new ReadAndWrite();
	private BorderPane layout = new BorderPane();
	private GridPane rightSide;
	private FlowPane flow;
	private MenuBar topToolBar = new MenuBar();
	private Group root;
	private ResourceBundle guiText;
	private Pen myPen;
	private Scene slogo;


	public void createScene(Stage s) throws FileNotFoundException {
		slogo = new Scene(layout, SCENE_WIDTH, SCENE_HEIGHT, Color.AQUA);
		s.setTitle("SLogo Team 05");
		s.setScene(slogo);
		s.show();
		Locale currentLocale = supportedLocales[0];
		guiText = ResourceBundle.getBundle("properties.LanguagesBundle", currentLocale);
		turtle.setData(controller.getTurtle());
		myPen = controller.getTurtle().getPen();
		createGUI();
	}

	private void createGUI() throws FileNotFoundException {
		layout.setTop(getTopToolBar());
		layout.setRight(getRightBox());
		layout.setLeft(addButtons());
		layout.setCenter(addGrid());
		slogo.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent event){
				try{
					switch (event.getCode()) {
					case UP: controller.passInput("fd 20"); break;
					case RIGHT:	controller.passInput("rt 20"); break;
					case DOWN: controller.passInput("bk 20"); break;		
					case LEFT: controller.passInput("lt 20"); break;
					default: break;
					}
				} catch (ParsingException e) {
					statusText.setText("Parsing error");
				}	
				getRightBox();
				update();
			}
		});
	}

	private void draw(){
		if(myPen.getActive()){
			Point position = controller.getTurtle().getPosition();
			Line line = new Line(turtle.getX()+20, turtle.getY()+25, position.x , position.y );	
			line.setStroke(myPen.getColor());
			if(myPen.getStyle().equals("Dashed"))
				line.getStrokeDashArray().addAll(10.0, 5.0);
			else if (myPen.getStyle().equals("Dotted"))
				line.getStrokeDashArray().addAll(2.0, 4.0);
			line.setStrokeWidth(myPen.getWidth());
			root.getChildren().remove(turtle);
			root.getChildren().add(line);
			root.getChildren().add(turtle);
//						ArrayList<SLogoLine> lineList = (controller.getTurtle()).getPen().getLines();
//						for(SLogoLine lne:lineList){
//							root.getChildren().addAll(lne.makeLine());
//						}
		}
	}


	private MenuBar getTopToolBar(){
		Menu file = new Menu("File");
		file.setStyle("-fx-background-color: LightGray");
		MenuItem save = new MenuItem("save");
		MenuItem load = new MenuItem("load");
		MenuItem workspace = new MenuItem("New Workspace");
		MenuItem help = new MenuItem("help");

		save.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				saver.write(layout.getStyle());
			}
		});

		load.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				try {
					layout.setStyle(saver.read().get(0));
				} catch (IOException e) {
				}
			}
		});

		workspace.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				
			}
		});
		
		help.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle (ActionEvent event) {
				help();
			}

			private void help() {
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
		});

		file.getItems().addAll(save, load, help, workspace);
		topToolBar.getMenus().add(file);		
		topToolBar.setStyle("-fx-background-color: Black");
		return topToolBar;
	}

	private GridPane getRightBox() {
		rightSide = new GridPane();
		HBox statusBar = new HBox();
		statusBar.setAlignment(Pos.TOP_LEFT);
		statusBar.getChildren().addAll(new Label("Status:"), statusText);
		final TextArea input = new TextArea();
		input.setWrapText(true);
		input.setPrefSize(200, (int) SCENE_HEIGHT / 2.5);
		GridPane userInput = new GridPane();
		Button enter = new Button("Enter", input);
		enter.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				try {
					controller.passInput(input.getText());
					statusText.setText(Buttons.status(controller.getHistory()));
				} catch (ParsingException e1) {
					input.clear();
					statusText.setText("Pass in a string fitting SLogo format");
				}
				update();
				input.clear();
			}
		});

		ScrollPane statusBox = new ScrollPane();
		statusBox.setContent(statusBar);
		statusBox.setPrefSize(200, SCENE_HEIGHT / 3);
		statusBox.setHbarPolicy(ScrollBarPolicy.NEVER);
		userInput.add(input, 0, 0);
		userInput.add(enter, 1, 0);

		rightSide.setPrefSize(input.getMaxWidth(), SCENE_HEIGHT / 2.5);
		rightSide.add(userInput, 0, 0);
		rightSide.add(statusBox, 0, 1);
		rightSide.setStyle("-fx-background-color: AQUA");
		return rightSide;
	}

	private Group addGrid() throws FileNotFoundException{
		root = new Group();
		layout.setStyle("-fx-background-color: WHITE");
		playground.setHgap(10);
		for (int i = 0; i < SCENE_WIDTH/15; i++) {
			for (int j = 0; j < SCENE_HEIGHT/8; j++) {
				playground.add(new Text(""), i, j);
			}
		}
		root.getChildren().add(playground);
		root.getChildren().add(turtle);
		turtle.setData(controller.getTurtle());
		update();
		return root;
	}

	private FlowPane addButtons() throws FileNotFoundException {
		flow = new FlowPane();
		flow.setPadding(new Insets(5, 0, 5, 0));
		flow.setVgap(4);
		flow.setHgap(4);
		flow.setPrefWidth(WRAP_LENGTH);
		flow.setStyle("-fx-background-color: DarkBlue");

		ColorPicker bgColor = new ColorPicker(Color.WHITE);
		Text bgLabel = new Text("Background"); 
		bgLabel.setFill(Color.WHITE);
		bgColor.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e){
				playground.setStyle("-fx-background-color: "+ toRGBString(bgColor.getValue()));
			}
		});

		ImageView gdt= new ImageView(setImage(new FileInputStream(new File("src/images/Grid.png"))));
		Button gridT = new Button(guiText.getString("Grid Toggle"), gdt);
		gridT.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				statusText.setText(guiText
						.getString("Toggling grid in simulation"));
				playground.setGridLinesVisible(!playground.isGridLinesVisible());
			}
		});

		ImageView ttle = new ImageView(setImage(new FileInputStream(new File(
				"src/images/Leonardo.png"))));
		Button turtleToggle = new Button(guiText.getString("Turtle Toggle"),
				ttle);
		turtleToggle.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				statusText.setText(guiText
						.getString("Toggling turtle in simulation"));
				turtle.setVisible(!turtle.isVisible());
			}
		});

		ImageView ttm = new ImageView(setImage(new FileInputStream(new File(
				"src/images/Raphael.png"))));
		Button turtim = new Button(guiText.getString("Turtle Image"), ttm);
		turtim.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				statusText.setText("Changing turtle image");
				Buttons.changeImage(turtle);
			}
		});

		Button language = new Button("Choose SLogo language");
		language.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				Buttons.changeLang();

				ObservableList<String> options = FXCollections.observableArrayList("English", "French");
				final ComboBox<String> comboBox = new ComboBox<String>(options);
				flow.getChildren().add(comboBox);
				comboBox.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						Locale currentLocale = supportedLocales[Buttons
						                                        .factory(comboBox.getValue())];
						guiText = ResourceBundle.getBundle(
								"properties.LanguagesBundle", currentLocale);
						try {
							createGUI();
						} catch (FileNotFoundException e) {
						}
						flow.getChildren().remove(comboBox);
					}
				});
			}
		});

		Text penLabel = new Text("Pen Properties:"); 
		penLabel.setFill(Color.WHITE);

		Text penActive = new Text("Active:");
		penActive.setFill(Color.WHITE);

		final CheckBox penState = new CheckBox();
		penState.setStyle("-fx-font-color: WHITE");
		penState.setSelected(true);
		penState.setOnAction(new EventHandler<ActionEvent> (){
			@Override
			public void handle (ActionEvent event){
				myPen.setActive(penState.isSelected());
			}
		});	

		final ColorPicker penColor = new ColorPicker(myPen.getColor());
		penColor.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent e){
				myPen.setColor(penColor.getValue());
			}
		});

		ObservableList<Double> widthOptions = FXCollections.observableArrayList(1.0, 2.0, 3.0, 4.0, 6.0, 8.0, 12.0, 20.0);
		final ComboBox<Double> penWidth = new ComboBox<Double>(widthOptions);
		penWidth.setOnAction(new EventHandler<ActionEvent> (){
			@Override
			public void handle (ActionEvent event){
				myPen.setWidth(penWidth.getValue());
			}
		});	


		ObservableList<String> styleOptions = FXCollections.observableArrayList("Solid", "Dashed", "Dotted");
		final ComboBox<String> penStyle = new ComboBox<String>(styleOptions);
		penStyle.setOnAction(new EventHandler<ActionEvent> (){
			@Override
			public void handle (ActionEvent event){
				myPen.setStyle(penStyle.getValue());
			}
		});	

		flow.getChildren().add(bgLabel);
		flow.getChildren().add(bgColor);
		flow.getChildren().add(gridT);
		flow.getChildren().add(turtleToggle);
		flow.getChildren().add(turtim);
		flow.getChildren().add(penLabel);
		flow.getChildren().add(penActive);
		flow.getChildren().add(penState);
		flow.getChildren().add(penColor);
		flow.getChildren().add(penWidth);
		flow.getChildren().add(penStyle);
		flow.getChildren().add(language);

		return flow;
	}

	private static String toRGBString(Color c){
		return "rgb("
				+ (int)(c.getRed()*255)
				+ "," + (int)(c.getGreen()*255)
				+ "," + (int)(c.getBlue()*255)
				+ ")";
	}

	private Image setImage(FileInputStream input){	
		return new Image(input, WRAP_LENGTH/3, WRAP_HEIGHT/3, true, true);
	}

	private void update(){
		draw();
		turtle.setData(controller.getTurtle());
	}
}
