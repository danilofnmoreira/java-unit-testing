package br.com.marimbondo.rules;

import static java.util.List.of;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.com.marimbondo.MathOperations;

@RunWith(Parameterized.class)
public class TimeOutRuleTest {

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
	public Timeout timeoutRule = new Timeout(1);

	@Rule
	public CustomRuleForLogs customRuleForLogs = new CustomRuleForLogs();

	private int a;
	private int b;
	private int expected;

	public TimeOutRuleTest(int a, int b, int expected) {
		super();
		this.a = a;
		this.b = b;
		this.expected = expected;
	}

	@Parameters(name = "Timeout Rule {index} - values {0}+{1}= {2}")
	public static Iterable<Integer[]> parameters() {
		return of(
				new Integer[] { 1, 2, 3 }, 
				new Integer[] { 8, 9, 17 }, 
				new Integer[] { 3, 9, 12 }
				);
	}

	@Test
	public void given_TwoNumbers_when_Addition_then_Calculate() {
		assertEquals(expected, math.addition(a, b));
	}

}
