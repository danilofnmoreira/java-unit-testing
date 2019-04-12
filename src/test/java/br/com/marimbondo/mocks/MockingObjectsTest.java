package br.com.marimbondo.mocks;

import java.util.List;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

public class MockingObjectsTest {

	private List<String> mockedList;
	
	@Before
	public void setUp() {
		mockedList = mock(List.class);
	}
	@Test
	public void testandoMockito() {
		mockedList.add("teste1");
		mockedList.add("teste2");
		mockedList.clear();
		verify(mockedList).clear();

		when(mockedList.get(anyInt())).thenReturn("teste3");
		assertThat(mockedList.get(0), is("teste3"));

	}
}
