package exceptions;

public class UnbalancedBracketsException extends ParsingException {

    /**
     * 
     */
    private static final long serialVersionUID = 9014505179313621363L;

    public UnbalancedBracketsException() {
	super();
    }

    public UnbalancedBracketsException(Exception e) {
	super(e);
    }

    public UnbalancedBracketsException(String s) {
	super(s);
    }

    @Override
    public String printMessage() {
	return "Unbalanced Brackets Exception";
    }
}
