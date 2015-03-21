package JUnitTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import compiler.Compiler;

import exceptions.ParsingException;

public class CompilerTest {

    Compiler compiler = new Compiler();
    @Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void testGrammarException() throws ParsingException {
	exception.expect(IllegalArgumentException.class);
	exception.expectMessage("Grammatically Error");
	// * is not an acceptable variable name
	String testInput = "fd *";
	compiler.compile(testInput);
    }

    @Test
    public void testSyntaxException() throws ParsingException {
	exception.expect(IllegalArgumentException.class);
	exception.expectMessage("Syntactically Error");
	String testInput = "fd 12 13";
	compiler.compile(testInput);
    }

}
