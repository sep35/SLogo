package commands;

import simulationObjects.Point;
import simulationObjects.Turtle;

public class CommandList {

    /**
     * 
     * the FD and BK command
     * 
     * @param forwardBy
     * @return the distance travelled
     */
    public static Command<Turtle, Void> forwardCommand(final double forwardBy) {
	final double copyVal = forwardBy;
	return new Command<Turtle, Void>() {
	    @Override
	    public String run(Turtle params) {
		double x_pos = params.getPosition().x;
		double y_pos = params.getPosition().y;
		double radians = Math.toRadians(params.getRotation());

		double new_x = x_pos - Math.cos(radians) * copyVal;
		double new_y = y_pos - Math.sin(radians) * copyVal;
		params.setPosition(new Point(new_x, new_y));
		return String.valueOf(forwardBy);

	    }
	};
    }

    /**
     * 
     * the LT and RT command
     * 
     * @param clockwiseDegrees
     * @return the resulted rotation string
     */
    public static Command<Turtle, Void> turnCommand(
	    final double clockwiseDegrees) {
	return new Command<Turtle, Void>() {
	    @Override
	    public String run(Turtle params) {
		params.setRotation(params.getRotation() + clockwiseDegrees);
		return String.valueOf(params.getRotation() + clockwiseDegrees);
	    }
	};
    }

    /**
     * 
     * set the turtle location
     * 
     * @param x
     * @param y
     * @return distance moved
     */
    public static Command<Turtle, Void> SetXY(final double val1,
	    final double val2) {
	return new Command<Turtle, Void>() {
	    @Override
	    public String run(Turtle params) {
		double curX = params.getPosition().x;
		double curY = params.getPosition().y;

		double desiredX = val1;
		double desiredY = val2;

		double d = Math.sqrt(Math.pow(curX - desiredX, 2)
			+ Math.pow(curY - desiredY, 2));

		params.setPosition(new Point(val1, val2));
		return String.valueOf(d);
	    }
	};
    }

    /**
     * 
     * turn the turtle towards a point
     * 
     * @param x
     * @param y
     * @return resulted rotation
     */
    public static Command<Turtle, Void> towards(final double val1,
	    final double val2) {
	return new Command<Turtle, Void>() {
	    @Override
	    public String run(Turtle params) {
		double dAngle = 0;

		double headingX = val1 - params.getPosition().x;
		double headingY = val2 - params.getPosition().y;

		dAngle = Math.atan2(headingY, headingX) * 180 / Math.PI;

		params.setRotation(dAngle);

		return String.valueOf(dAngle);

	    }
	};
    }

    /**
     * 
     * clear the screen return the turtle to original position
     * 
     * @return
     */
    public static Command<Turtle, Void> clearScreen() {
	return new Command<Turtle, Void>() {
	    @Override
	    public String run(Turtle params) {
		double curX = params.getPosition().x;
		double curY = params.getPosition().y;

		double distance = Math.sqrt(Math.pow(curX, 2)
			+ Math.pow(curY, 2));

		params.setPosition(new Point(370.0, 300.0));
		params.setRotation(90);

		return String.valueOf(distance);

	    }
	};
    }

    /**
     * 
     * Xcor query
     * 
     * @return
     */
    public static Command<Turtle, Void> xCor() {
	return new Command<Turtle, Void>() {
	    @Override
	    public String run(Turtle params) {
		return String.valueOf(params.getPosition().x);

	    }
	};

    }

    /**
     * 
     * yCor query
     * 
     * @return
     */
    public static Command<Turtle, Void> yCor() {
	return new Command<Turtle, Void>() {
	    @Override
	    public String run(Turtle params) {
		return String.valueOf(params.getPosition().y);
	    }
	};
    }

    /**
     * 
     * heading query
     * 
     * @return
     */
    public static Command<Turtle, Void> heading() {
	return new Command<Turtle, Void>() {
	    @Override
	    public String run(Turtle params) {
		return String.valueOf(params.getRotation());
	    }
	};
    }

    /**
     * 
     * pen up query
     * 
     * @return
     */
    public static Command<Turtle, Void> penDownP() {
	return new Command<Turtle, Void>() {
	    @Override
	    public String run(Turtle params) {
		return String.valueOf(params.getPen().getActive());
	    }
	};
    }

    /**
     * 
     * visible query
     * 
     * @return
     */

    public static Command<Turtle, Void> showingP() {
	return new Command<Turtle, Void>() {
	    @Override
	    public String run(Turtle params) {
		return String.valueOf(params.getVisible());
	    }
	};
    }

    /**
     * 
     * set pen down
     * 
     * @return
     */

    public static Command<Turtle, Void> penDown() {
	return new Command<Turtle, Void>() {
	    @Override
	    public String run(Turtle params) {
		params.getPen().setActive(true);

		return "1";
	    }
	};
    }

    /**
     * 
     * set pen up
     * 
     * @return
     */
    public static Command<Turtle, Void> penUp() {
	return new Command<Turtle, Void>() {
	    @Override
	    public String run(Turtle params) {
		params.getPen().setActive(false);

		return "0";
	    }
	};
    }

    /**
     * 
     * show turtle
     * 
     * @return
     */
    public static Command<Turtle, Void> showTurtle() {
	return new Command<Turtle, Void>() {
	    @Override
	    public String run(Turtle params) {
		params.setVisible(true);

		return "1";
	    }
	};

    }

    /**
     * 
     * hide turtle
     * 
     * @return
     */
    public static Command<Turtle, Void> hideTurtle() {
	return new Command<Turtle, Void>() {
	    @Override
	    public String run(Turtle params) {
		params.setVisible(false);

		return "0";
	    }
	};
    }

    /**
     * 
     * set pen width to val
     * 
     * @param val
     * @return
     */
    public static Command<Turtle, Void> setPenWidth(final double val) {
	return new Command<Turtle, Void>() {
	    @Override
	    public String run(Turtle params) {
		params.getPen().setWidth(val);

		return String.valueOf(val);
	    }
	};
    }
}
