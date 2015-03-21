package exceptions;

public class InvalidArgumentsException extends ParsingException {

    /**
     * 
     */
    private static final long serialVersionUID = -3534124694409416195L;

    public InvalidArgumentsException() {
	super();
    }

    public InvalidArgumentsException(Exception e) {
	super(e);
    }

    public InvalidArgumentsException(String s) {
	super(s);
    }

    @Override
    public String printMessage() {
	return "Invalid Argument Exception";
    }
}
