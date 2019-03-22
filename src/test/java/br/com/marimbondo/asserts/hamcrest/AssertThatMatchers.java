package br.com.marimbondo.asserts.hamcrest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

import org.junit.Test;

public class AssertThatMatchers {

	@Test
	public void equalToMatcher() {

		// arrays de mesmos elementos na mesma ordem. Substituicao para o
		// Assert.assertArrayEquals()
		int[] a = new int[] { 3, 5, 656 };
		int[] b = new int[] { 3, 5, 656 };
		a.equals(b); // false
		assertThat(a, equalTo(b));
		assertThat(a, is(equalTo(b)));
		assertThat(a, is(b));

		String c = new String("73");
		String d = new String("73");
		assertThat(c, equalTo(d));
		assertThat(c, is(equalTo(d)));
		assertThat(c, is(d));

		Integer e = Integer.valueOf("55");
		Integer f = Integer.valueOf("92");
		e.equals(f); // false
		assertThat(e, not(equalTo(f)));
		assertThat(e, is(not(equalTo(f))));
		assertThat(e, not(f));

	}

	@Test
	public void equalToIgnoringCaseMatcher() {
		String a = "foo";
		String b = "FOO";
		assertThat(a, equalToIgnoringCase(b));
	}

	@Test
	public void hasToStringMatcher() {
		String a = "foo";
		assertThat(a, hasToString(a));
	}

	@Test
	public void typeCompatibleWithMatcher() {
		String a = "foo";
		String b = "FOO";
//		assertThat(a, typeCompatibleWith(Iterable.class));
	}
}
