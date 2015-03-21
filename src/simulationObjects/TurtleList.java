package simulationObjects;

import java.util.ArrayList;
import java.util.List;

public class TurtleList {

    /**
     * variable that belong to the model
     */
    protected List<Turtle> turtles;
    protected List<Turtle> activeTurtles;
    protected List<Turtle> stamps;

    protected void init() throws Exception {
	createTurtle();
	addActiveTurtle(0);

    }

    /**
     *
     * add active turtle to a list
     *
     * @param index
     *            to add
     * @return if addition is successful
     */
    public boolean addActiveTurtle(int index) {
	try {
	    activeTurtles.add(turtles.get(index));
	    return true;
	} catch (Exception e) {
	    return false;
	}
    }

    /**
     * get a turtle from the list of turtles that is created by the index
     * specified
     *
     * @param index
     * @return the turtle at index
     */
    public Turtle getTurtle(int index) {
	return turtles.get(index);
    }

    /**
     * remove a turtle from the list of turtle based on the index specified
     *
     * @param index
     */
    public void removeTurtle(int index) {
	turtles.remove(index);
    }

    /**
     * get the list of all the turtles that has been created by the user
     *
     * @return list of all the turtles that has been created
     */
    public List<Turtle> getAllTurtles() {
	return new ArrayList<Turtle>(turtles);
    }

    /**
     * get the active list of turtles
     *
     * @return activeTurtlesList
     */
    public List<Turtle> getActiveTurtles() {
	return new ArrayList<Turtle>(activeTurtles);
    }

    /**
     * locate in the list of all the turtles created to get the turtles
     * indicated by the list of indexes that needed to be added to the active
     * list of turtles
     *
     * @param indexes
     * @return boolean
     */
    public boolean setActiveTurtles(int[] indexes) {
	try {
	    activeTurtles.clear();
	    for (int i : indexes) {
		activeTurtles.add(turtles.get(i));
	    }
	    return true;
	} catch (Exception e) {
	    return false;
	}
    }

    /**
     * get the indexes of all the active turtles in the active turtles list
     *
     * @return indexes
     */
    public int[] getActiveTurtleIndexes() {
	int[] indexes = new int[activeTurtles.size()];
	for (int i = 0; i < indexes.length; i++) {
	    indexes[i] = getTurtleIndex(activeTurtles.get(i));
	}
	return indexes;
    }

    /**
     * add a stamp of the current active turtle
     *
     * @param t
     */
    public void addStamp(Turtle t) {
	stamps.add(new Turtle(t));
    }

    /**
     * clear the list of stamps made
     */
    public void clearStamps() {
	stamps.clear();
    }

    /**
     * get the list of stamp made by the stamp function
     *
     * @return list of stamps made
     */
    public List<Turtle> getStamps() {
	return new ArrayList<Turtle>(stamps);
    }

    /**
     * get the index of a turtle in the list of all the turtles created when
     * providing the turtle
     *
     * @param turtle
     * @return index
     */
    public int getTurtleIndex(Turtle t) {
	for (int i = 0; i < turtles.size(); i++) {
	    if (t == turtles.get(i))
		return i;
	}
	return -1;
    }

    /**
     * looks through list of turtles to see if the turtle t is in that list
     *
     * @param turtle
     * @return Index Identified Turtle
     */
    public int findTurtle(Turtle t) {
	for (int i = 0; i < turtles.size(); i++) {
	    if (t.getIdNum() == turtles.get(i).getIdNum())
		return i;
	}
	return -1;
    }

    /**
     * clear the list of active turtles
     */
    public void clearActiveTurtles() {
	activeTurtles.clear();
    }

    /**
     * add a turtle to an active list of turtles
     *
     * @param turtle
     */
    public void addTurtle(Turtle t) {
	int i = findTurtle(t);
	if (i == -1) {
	    turtles.add(t);
	} else {
	    if (activeTurtles.contains(turtles.get(i))) {
		activeTurtles.remove(turtles.get(i));
		turtles.set(i, t);
		activeTurtles.add(turtles.get(i));
	    } else {
		turtles.set(i, t);
	    }
	}
    }

    /**
     * creates the turtle and added it to a list of turtles that has been
     * created
     *
     * @return the new turtle being created
     */
    private Turtle createTurtle() {
	Turtle newTurtle = new Turtle();
	turtles.add(newTurtle);
	return newTurtle;
    }
}
