package exceptions;


public class ParsingException extends Exception {

    /**
     * 
     */
    private static final long serialVersionUID = 1375979697281153573L;

    public ParsingException() {
	super();
    }

    public ParsingException(Exception e) {
	super(e);
    }

    public ParsingException(String s) {
	super(s);
    }

    public String printMessage() {
	return "Parsing Exception";
    }

}
