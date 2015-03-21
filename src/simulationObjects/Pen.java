package simulationObjects;

import javafx.scene.paint.Color;

public class Pen {

    private Color myColor;
    private double myWidth;
    private boolean active;
    private String myStyle;

    public Pen() {
	super();
	active = true;
	myColor = Color.BLACK;
	myStyle = "Solid";
	myWidth = 1.0;
    }

    public void setColor(Color color) {
	myColor = color;
    }

    public Color getColor() {
	return myColor;
    }

    public void setWidth(double width) {
	myWidth = width;
    }

    public double getWidth() {
	return myWidth;
    }

    public void setActive(boolean active) {
	this.active = active;
    }

    public boolean getActive() {
	return active;
    }

    public void setStyle(String sty) {
	myStyle = sty;
    }

    public String getStyle() {
	return myStyle;
    }

}