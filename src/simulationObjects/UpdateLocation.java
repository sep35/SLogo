package simulationObjects;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;

//TODO wtf is this class doing..
public class UpdateLocation {
    public boolean goup = false, goright = false, godown = false,
	    goleft = false;
    public int newx = 0, newy = 0;
    public int[] newLocation = new int[2];

    public UpdateLocation() {

    }

    public int[] updateLocation(int x, int y) {
	if (goup) {
	    newy = y + 50;
	}
	if (godown) {
	    newy = y - 50;
	}
	if (goleft) {
	    newx = x - 50;
	}
	if (goright) {
	    newx = x + 50;
	}
	newLocation = new int[] { newx, newy };
	return newLocation;
    }

    public void updatemovement(Scene scene) {
	scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
	    @Override
	    public void handle(KeyEvent event) {
		switch (event.getCode()) {
		case UP:
		    goup = true;
		    break;
		case RIGHT:
		    goright = true;
		    break;
		case DOWN:
		    godown = true;
		    break;
		case LEFT:
		    goleft = true;
		    break;
		default:
		    break;
		}
	    }
	});
    }

    public void regressmovement(Scene scene) {
	scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
	    @Override
	    public void handle(KeyEvent event) {
		switch (event.getCode()) {
		case UP:
		    goup = false;
		    break;
		case RIGHT:
		    goright = false;
		    break;
		case DOWN:
		    godown = false;
		    break;
		case LEFT:
		    goleft = false;
		    break;
		default:
		    break;
		}
	    }
	});
    }

}
