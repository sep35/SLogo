package view;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import simulationObjects.Turtle;

public class TurtleView extends ImageView {
<<<<<<< HEAD
    public UpdateLocation location = new UpdateLocation();
=======
	public TurtleView(Image image) {
		super(image);
	}
>>>>>>> Steven

    public TurtleView(Image image) {
	super(image);
    }

    public void setData(Turtle turtleModel) {
	this.setX(turtleModel.getPosition().x - 20);
	this.setY(turtleModel.getPosition().y - 25);
	this.setRotate(turtleModel.getRotation() - 90);
    }

    /**
     * Copy-constructor
     * 
     * @param turtle
     *            a TurtleView object whose data will be copied to the new
     *            TurtleView instance.
     */
    public TurtleView(TurtleView turtle) {
	this(turtle.getImage());
	this.setX(turtle.getX());
	this.setY(turtle.getY());
	this.setRotate(turtle.getRotate());
    }
}
