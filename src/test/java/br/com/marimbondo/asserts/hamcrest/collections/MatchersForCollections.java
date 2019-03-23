package br.com.marimbondo.asserts.hamcrest.collections;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.arrayContaining;
import static org.hamcrest.Matchers.arrayContainingInAnyOrder;
import static org.hamcrest.Matchers.arrayWithSize;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.emptyArray;
import static org.hamcrest.Matchers.everyItem;
import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.hasEntry;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasItemInArray;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasValue;
import static org.hamcrest.Matchers.in;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.oneOf;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

public class MatchersForCollections {

	@Test
	public void iterableMixes() {
		List<Object> emptyList = List.of();
		assertThat(emptyList, is(empty()));

		List<Integer> list = asList(123, 3253, 46, Integer.valueOf(9));
		assertThat(list, hasSize(4));
		assertThat(list, contains(123, 3253, 46, 9));
		assertThat(list, containsInAnyOrder(123, 46, 9, 3253));
		assertThat(list, everyItem(greaterThan(2)));
		assertThat(list, hasItem(123));
		assertThat(list, hasItems(123, 46));
	}

	@Test
	public void arrayMixes() {
		Object[] emptyArray = {};
		assertThat(emptyArray, is(emptyArray()));

		Integer[] ints = new Integer[] { 7, 5, 12, 16 };
		assertThat(ints, arrayWithSize(4));
		assertThat(ints, arrayContaining(7, 5, 12, 16));
		assertThat(ints, arrayContainingInAnyOrder(12, 16, 7, 5));
		assertThat(ints, hasItemInArray(16));
		assertThat(16, is(in(ints)));
		assertThat(16, is(oneOf(ints)));
	}

	@Test
	public void mapsMixes() {
		Map<String, String> map = new HashMap<String, String>();
		map.put("nome", "Danilo");
		map.put("sobrenome", "Moreira");
		assertThat(map, hasKey("nome"));
		assertThat(map, hasValue("Moreira"));
		assertThat(map, hasEntry("sobrenome", "Moreira"));
	}

}
