package compiler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class ParseTable {
    private static ArrayList<HashMap<String, String>> myOperation = new ArrayList<>();
    private static ArrayList<HashMap<String, Integer>> nextState = new ArrayList<>();
    private static String[] key = new String[82];
    private static String[] myLHS = new String[78];
    private static int[] myRHS = new int[78];

    /**
     *
     * left hand side of rules
     * 
     * @return
     */
    public String[] getLHS() {
	return myLHS;
    }

    /**
     *
     * getter for next state
     * 
     * @return list of next state
     */
    public ArrayList<HashMap<String, Integer>> getNextState() {
	return nextState;
    }

    /**
     *
     * getter for next operation
     * 
     * @return list of next ops
     */
    public ArrayList<HashMap<String, String>> getOperation() {
	return myOperation;
    }

    /**
     *
     *
     * right hand side of rules
     * 
     * @return
     */
    public int[] getRHS() {
	return myRHS;
    }

    /**
     *
     * create parse table for parsing
     */
    @SuppressWarnings({ "resource" })
    public void initializeTable() {
	try {
	    BufferedReader in = new BufferedReader(new FileReader(
		    ".\\src\\properties\\parse_table_keys.txt"));
	    for (int i = 0; i < 81; i++) {
		key[i] = in.readLine();
	    }

	    in = new BufferedReader(new FileReader(
		    ".\\src\\properties\\LHS.txt"));
	    for (int i = 0; i < 78; i++) {
		myLHS[i] = in.readLine();
	    }

	    in = new BufferedReader(new FileReader(
		    ".\\src\\properties\\RHS.txt"));
	    for (int i = 0; i < 78; i++) {
		myRHS[i] = Integer.parseInt(in.readLine());
	    }

	    in = new BufferedReader(new FileReader(
		    ".\\src\\properties\\parse_table.txt"));
	    String currentNode = "";
	    for (int i = 0; i < 182; i++) {
		String inputBuffer = in.readLine();
		String[] currentLine = inputBuffer.split(" ");

		HashMap<String, String> opTemp = new HashMap<>();
		HashMap<String, Integer> nextTemp = new HashMap<>();
		String currentOp = "";
		int currentNext = 0;

		for (int j = 0; j < currentLine.length; j++) {
		    currentNode = currentLine[j];
		    currentOp = currentNode.substring(0, 1);

		    switch (currentNode.charAt(0)) {
		    case 'a':

			break;
		    case 'x':

			break;
		    case 's':

		    case 'r':
			currentNext = Integer
				.parseInt(currentNode.substring(1));

			break;
		    default:
			currentNext = Integer.parseInt(currentNode);
			currentOp = "g";

		    }
		    opTemp.put(key[j], currentOp);
		    nextTemp.put(key[j], currentNext);
		}
		myOperation.add(opTemp);
		nextState.add(nextTemp);

	    }

	} catch (FileNotFoundException e) {
	    System.out.println("Parse Table file not found");
	} catch (IOException e) {
	    System.out.println("Parse Table error");
	}

    }

}
