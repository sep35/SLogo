package simulationObjects;

public class Point {
    public double x;
    public double y;

    /**
     * Constructor
     *
     * @param x
     *            a double representing the x-coordinate of the turtle
     * @param y
     *            a double representing the y-coordinate of the turtle
     */
    public Point(double x, double y) {
	this.x = x;
	this.y = y;
    }

    /**
     * Constructor. Initializes the class to point 0, 0.
     */
    public Point() {
	this(0, 0);
    }
}
