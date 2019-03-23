package br.com.marimbondo.asserts.hamcrest.core;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.anyOf;
import static org.hamcrest.Matchers.blankOrNullString;
import static org.hamcrest.Matchers.blankString;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.containsInRelativeOrder;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.containsStringIgnoringCase;
import static org.hamcrest.Matchers.emptyOrNullString;
import static org.hamcrest.Matchers.emptyString;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.equalToCompressingWhiteSpace;
import static org.hamcrest.Matchers.equalToIgnoringCase;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasToString;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isA;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.sameInstance;
import static org.hamcrest.Matchers.stringContainsInOrder;
import static java.util.List.*;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import lombok.Data;
import lombok.NonNull;

public class MatchersForCore {

	@Data
	public class MyBean {
		@NonNull
		private String name;
	}

	@Test
	public void mixes() {
		
		// DECORATORS
		assertThat("Danilo", is(equalTo("Danilo")));
		assertThat("Danilo", is(not(equalTo("Danilo Moreira"))));
		
		Object o1 = new Object();
		Object o2 = o1;
		assertThat(o1, sameInstance(o2));
		
		List a = new ArrayList();
		assertThat(a, is(instanceOf(Iterable.class)));
		assertThat(a, isA(Iterable.class));
		
		List<Integer> list = of(1, 2, 3);
		assertThat(list, everyItem(lessThan(10)));
		
		assertThat(list, anyOf(hasSize(3), containsInAnyOrder(1, 19, 18)));
//		assertThat(list, allOf(hasSize(3), containsInAnyOrder(3, 2, 1)));
	}

}
