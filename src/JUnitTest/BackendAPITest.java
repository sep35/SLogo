package JUnitTest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import simulationObjects.Point;
import controller.MainController;
import exceptions.ParsingException;
import exceptions.UnbalancedBracketsException;

public class BackendAPITest {
    private MainController backend = new MainController();

    @Test
    public void test() throws UnbalancedBracketsException, ParsingException {
	backend.passInput("fd 50");
	testPos(new Point(0, 50));
	backend.passInput("back 50");
	testPos(new Point(0, 0));
	backend.passInput("left 90");
	backend.passInput("fd 50");
	testPos(new Point(50, 0));
	backend.passInput("right 180");
	backend.passInput("back 50");
	testPos(new Point(100, 0));
    }

    private void testPos(Point ptest) {
	Point pcurr = backend.getTurtle().getPosition();
	assertEquals("Turtle X Should be " + ptest.x, (int) ptest.x,
		(int) pcurr.x);
	assertEquals("Turtle Y Should be " + ptest.y, (int) ptest.y,
		(int) pcurr.y);
    }
}
