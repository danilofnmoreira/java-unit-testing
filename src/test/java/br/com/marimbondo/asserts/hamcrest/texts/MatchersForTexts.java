package br.com.marimbondo.asserts.hamcrest.texts;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.blankString;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.endsWith;
import static org.hamcrest.Matchers.endsWithIgnoringCase;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.startsWith;
import static org.hamcrest.Matchers.startsWithIgnoringCase;
import static org.hamcrest.Matchers.stringContainsInOrder;

import org.junit.Test;

import lombok.Data;
import lombok.NonNull;

public class MatchersForTexts {

	@Data
	public class MyBean {
		@NonNull
		private String name;
	}

	@Test
	public void textMixes() {
		assertThat("", is(emptyString()));
		assertThat("", is(emptyOrNullString()));
		assertThat(null, is(emptyOrNullString()));

		assertThat("   ", is(blankString()));
		assertThat("   ", is(blankOrNullString()));
		assertThat(null, is(blankOrNullString()));

		assertThat("Danilo       ", equalToCompressingWhiteSpace("Danilo"));

		assertThat("Danilo", equalTo("Danilo"));
		assertThat("Danilo", equalToIgnoringCase("DANILO"));

		assertThat("Danilo", containsString("Da"));
//		assertThat("Danilo", containsStringIgnoringCase("Da"));
		assertThat("Danilo", stringContainsInOrder("Da", "lo"));

		MyBean myBean = new MyBean("Danilo");
		String myBeanToString = "MatchersForTexts.MyBean(name=Danilo)";
		assertThat(myBean, hasToString(myBeanToString));
		
		assertThat("Danilo", startsWith("Da"));
//		assertThat("Danilo", startsWithIgnoringCase("DA"));
		assertThat("Danilo", endsWith("lo"));
//		assertThat("Danilo", endsWithIgnoringCase("LO"));
	}

}
