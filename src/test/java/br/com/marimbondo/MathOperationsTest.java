package br.com.marimbondo;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;
import static org.junit.Assume.assumeNoException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class MathOperationsTest {

	MathOperations app;

	@BeforeClass // Executed once, before the start of all tests. It is used to perform time
					// intensive activities, for example, to connect to a database. Methods marked
					// with this annotation need to be defined as static to work with JUnit.
	public static void justOneSetUp() {
		out.println("justOneSetUp");
	}

	@Before // Executed before each test. It is used to prepare the test environment (e.g.,
			// read input data, initialize the class).
	public void setUp() {
		app = new MathOperations();
		out.println("setup");
	}

	@Test // Identifies a method as a test method.
	public void given_NumberTwelveAndNumberTwo_when_Multiplication_then_ReturnTwentFour() {
		int a = 12;
		int b = 2;
		int expected = 24;
		assertEquals(expected, app.multiplication(a, b));
	}

	@Test
	public void given_NumberTwelveAndNumberTwo_when_Addition_then_ReturnFourteen() {
		int a = 12;
		int b = 2;
		int expected = 14;
		assertEquals(expected, app.addition(a, b));
	}

	@After // Executed after each test. It is used to cleanup the test environment (e.g.,
			// delete temporary data, restore defaults). It can also save memory by cleaning
			// up expensive memory structures.
	public void cleanUp() {
		app = null;
		out.println("cleanUp");
	}

	@AfterClass // Executed once, after all tests have been finished. It is used to perform
				// clean-up activities, for example, to disconnect from a database. Methods
				// annotated with this annotation need to be defined as static to work with
				// JUnit.
	public static void justOneCleanUp() {
		out.println("justOneCleanUp");
	}

	@Ignore(value = "Because I want") // Marks that the test should be disabled. This is useful when the underlying
										// code has been changed and the test case has not yet been adapted. Or if the
										// execution time of this test is too long to be included. It is best practice
										// to provide the optional description, why the test is disabled.
	@Test
	public void given_NumberTwelveAndNumberOne_when_Addition_then_ReturnTwelve() {
		int a = 12;
		int b = 1;
		int expected = 12;
		assertEquals(expected, app.addition(a, b));
	}

	@Test(expected = ArithmeticException.class, timeout = 1) // Fails if the method does not throw the named exception.
																// Fails if the method takes longer than 1 milliseconds.
	public void given_NumberTwelveAndNumberZero_when_Division_then_ThrowArithmeticException() {
		int a = 1;
		int b = 0;
		app.division(a, b);
	}

	@Test
	public void given_NumberTwelveAndNumberZero_when_Division_then_ThrowArithmeticException_InvalidatingTest() {
		int a = 1;
		int b = 0;
		try {
			app.division(a, b);
		} catch (ArithmeticException e) {
			assumeNoException(e); // Se falso, invalida o teste
		}
	}
}
