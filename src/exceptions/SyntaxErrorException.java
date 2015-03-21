package exceptions;

public class SyntaxErrorException extends ParsingException {

    /**
     * 
     */
    private static final long serialVersionUID = 7690511650251959808L;

    public SyntaxErrorException() {
	super();
    }

    public SyntaxErrorException(Exception e) {
	super(e);
    }

    public SyntaxErrorException(String s) {
	super(s);
    }

    @Override
    public String printMessage() {
	return "Syntax Error For the input program";
    }
}
