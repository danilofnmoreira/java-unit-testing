package br.com.marimbondo.asserts.hamcrest.numbers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.closeTo;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.lessThanOrEqualTo;

import org.junit.Test;

public class MatchersForNumbers {

	@Test
	public void mixes() {
		assertThat(1, greaterThan(0));
		assertThat(1, greaterThanOrEqualTo(0));
		assertThat(1, lessThan(2));
		assertThat(1, lessThanOrEqualTo(2));
		assertThat(1.2, closeTo(1, 0.5)); // Let’s pay close attention to the last matcher, closeTo. The first argument,
											// the operand, is the one to which the target is compared and the second
											// argument is the allowable deviation from the operand . This means that if
											// the target is operand+deviation or operand-deviation, then the test will
											// pass.
	}

}
