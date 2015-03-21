package simulationObjects;


<<<<<<< HEAD
public class Turtle extends UpdateLocation {
=======
public class Turtle{
>>>>>>> Steven

    private Point position = new Point(400, 300);
    private double rotation = 90;
    private boolean visible = true;
    private Pen myPen;
    private int idNum;

    /**
     * Constructor
     */
    public Turtle() {
	idNum = 0;
	myPen = new Pen();
	position = new Point(400, 300);
	rotation = 90;
	visible = true;
    }

    /**
     * Copy-constructor
     *
     * @param turtle
     *            a Turtle object whose data will be copied to the new Turtle
     *            instance.
     */
    public Turtle(Turtle turtle) {
	position = turtle.getPosition();
	rotation = turtle.getRotation();
	visible = turtle.getVisible();
	myPen = turtle.getPen();
	idNum = turtle.getIdNum();
    }

    public boolean getVisible() {
	return visible;
    }

    /**
     * Set the position within an x, y coordinate system.
     *
     * @param x
     *            a double representing the x-coordinate of the turtle
     * @param y
     *            a double representing the y-coordinate of the turtle
     */
    public void setPosition(double x, double y) {
	position.x = x;
	position.y = y;
    }

    /**
     * Set the position within an x, y coordinate system.
     *
     * @param position
     *            a Point object representing the position of the turtle
     * @see Point
     */
    public void setPosition(Point position) {
	this.position = position;
    }

    /**
     * get the current position of the turtle.
     *
     * @return Point the turtle location within the x, y coordinate system
     * @see Point
     */
    public Point getPosition() {
	return position;
    }

    /**
     * Get the rotation of the turtle.
     *
     * @return double the rotation of the turtle
     */
    public double getRotation() {
	return rotation;
    }

    /**
     * Set the rotation of the turtle. Input outside of [0, 360] will be set to
     * an equivalent angle within [0, 360].
     *
     * @param rotation
     *            a double representing the rotation of the turtle.
     */
    public void setRotation(double rotation) {
	if (rotation >= 360) {
	    this.rotation = rotation % 360;
	} else if (rotation < 0) {
	    this.rotation = 360 + (rotation % 360);
	} else {
	    this.rotation = rotation;
	}
    }

    /**
     *
     *
     * @return current turtle
     */
    public Turtle getTurtle() {
	// TODO Auto-generated method stub
	return this;
    }

    /**
     *
     *
     * @param visibility
     *            of turtle
     */
    public void setVisible(boolean b) {
	visible = b;
    }

    /**
     *
     * @return pen of the turtle
     */
    public Pen getPen() {
	return myPen;
    }

    /**
     *
     * @return id of current turtle
     */
    public int getIdNum() {
	return idNum;
    }

    /**
     * set the idnum of the turtle
     *
     * @param idNum
     */
    public void setIdNum(int idNum) {
	this.idNum = idNum;
    }
}