package br.com.marimbondo.asserts.hamcrest.custommatchers;

import static org.hamcrest.MatcherAssert.assertThat;

import org.hamcrest.Description;
import org.hamcrest.Factory;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Test;

public class CustomMatchers {

	public static class IsPositiveInteger extends TypeSafeMatcher<Integer> {

		@Override
		public void describeTo(Description description) {
			description.appendText("a positive integer"); // java.lang.AssertionError: Expected: a positive integer but:
															// was <-1>
		}

		@Override
		protected boolean matchesSafely(Integer item) {
			return item > 0;
		}

		@Factory
		public static Matcher<Integer> isAPositiveInteger() {
			return new IsPositiveInteger();
		}
	}

	@Test
	public void givenInteger_whenAPositiveValue_thenCorrect() {
		int num = 1;
		assertThat(num, IsPositiveInteger.isAPositiveInteger());
	}

}
