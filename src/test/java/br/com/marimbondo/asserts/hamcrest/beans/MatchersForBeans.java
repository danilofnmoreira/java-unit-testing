package br.com.marimbondo.asserts.hamcrest.beans;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.samePropertyValuesAs;

import org.junit.Test;

import lombok.Data;
import lombok.NonNull;

public class MatchersForBeans {

	@Data
	public class Todo {
		@NonNull
		private Long id;
		@NonNull
		private String summary;
		@NonNull
		private String description;
	}

	@Test
	public void beanMixes() {
		Todo todo = new Todo(1L, "Learn Hamcrest", "chato");
		Todo todo1 = new Todo(1L, "Learn Hamcrest", "chato");

		assertThat(todo, allOf(hasProperty("summary"), hasProperty("summary", equalTo("Learn Hamcrest"))));

//		assertThat(todo, samePropertyValuesAs(todo1));
	}
}
