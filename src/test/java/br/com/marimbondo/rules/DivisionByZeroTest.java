package br.com.marimbondo.rules;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import br.com.marimbondo.MathOperations;

public class DivisionByZeroTest {

	private MathOperations math;

	@Before
	public void setUp() {
		math = new MathOperations();
	}

	@Rule // Annotates fields that reference rules or methods that return a rule. A field
			// must be public, not static, and a subtype of org.junit.rules.TestRule
			// (preferred) or org.junit.rules.MethodRule. A method must be public, not
			// static, and must return a subtype of org.junit.rules.TestRule (preferred) or
			// org.junit.rules.MethodRule.
	public ExpectedException expectedException = ExpectedException.none();

	@Rule
	public CustomRuleForLogs customRuleForLogs = new CustomRuleForLogs();

	@Test
	public void given_ZeroIsInDenominator_when_Division_then_ThrowsAriThmaticExceptionWithMessage() {
		expectedException.expect(ArithmeticException.class);
		expectedException.expectMessage("Nao eh valido a divisao por zero");
		math.divisionWithMessageException(22, 0);
	}

	@Test
	public void given_ZeroIsNotInDenominator_when_Division_then_CalculatesCorrectly() {
		assertEquals(11, math.divisionWithMessageException(22, 2));
	}

}