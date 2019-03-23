package br.com.marimbondo.asserts.hamcrest.objects;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.isA;

import org.junit.Test;

import lombok.Data;
import lombok.NonNull;

public class MatchersForObjects {

	@Data
	public class MyBean {
		@NonNull
		private String name;
	}

	@Test
	public void objectsMixes() {

		MyBean myBean = new MyBean("Danilo");

		String expectedToString = "MatchersForObjects.MyBean(name=Danilo)";
		assertThat(myBean, hasToString(expectedToString));

		assertThat(myBean, isA(Object.class));
	}

}
