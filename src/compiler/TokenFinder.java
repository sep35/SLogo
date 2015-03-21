package compiler;

import java.util.Locale;
import java.util.ResourceBundle;

public class TokenFinder {
    /**
     *
     * Defines the different type of user inputs retrieved from the command line
     *
     */
    public enum Type {
	CONSTANT, VARIABLE, COMMAND, LIST_START, LIST_END, PARENS_START, PARENS_END, NOT_RECOGNIZED
    }

    private static ResourceBundle regExProperties;

    /**
     * defines the type of the string
     *
     * @param s
     * @return the type of the string
     */
    public static Type stringType(String s) {
	regExProperties = ResourceBundle.getBundle("properties\\commandRegEx",
		Locale.US);
	if (s.matches(regExProperties.getString("CONSTANT")))
	    return Type.CONSTANT;
	if (s.matches(regExProperties.getString("VARIABLE")))
	    return Type.VARIABLE;
	if (s.matches(regExProperties.getString("COMMAND")))
	    return Type.COMMAND;
	if (s.matches(regExProperties.getString("LIST_END")))
	    return Type.LIST_END;
	if (s.matches(regExProperties.getString("LIST_START")))
	    return Type.LIST_START;
	if (s.matches(regExProperties.getString("PARENS_START")))
	    return Type.PARENS_START;
	if (s.matches(regExProperties.getString("PARENS_END")))
	    return Type.PARENS_END;

	return Type.NOT_RECOGNIZED;
    }

    /**
     * create the tokenize array of arguments where each argument is defined
     * with a type
     *
     * @param args
     * @return an array of argument that has been defined with a type
     */
    public static Type[] tokenize(String[] args) {
	Type[] tokens = new Type[args.length];
	for (int i = 0; i < args.length; i++) {
	    tokens[i] = stringType(args[i]);
	}

	return tokens;
    }
}