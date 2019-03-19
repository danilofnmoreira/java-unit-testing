package br.com.marimbondo.parameterization;

import static java.util.List.of;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import br.com.marimbondo.MathOperations;

@RunWith(Parameterized.class) // Esta classe só pode conter 1 unico metodo de teste.
public class ParameterizedMultiplicationTest {

	@Parameters(name = "Param Multiplication {index}; values {0}*{1}={2} ") // repare o nome dos metodos
	public static Iterable<Integer[]> parameters() {  // O metodo de parametros deve ser estatico e retornar um Iterable de Arrays
		Iterable<Integer[]> params = of(
				new Integer[] {1, 2,  2},
				new Integer[] {0, 2,  0},
				new Integer[] {4, 8, 32},
				new Integer[] {9, 9, 81}
				);
		return params;
	}

	private MathOperations mathOperations;

	private int expected;
	private int b;
	private int a;

	// seu contrutor recebera os parametros do metodo estatico anotado com @Parameters
	public ParameterizedMultiplicationTest(int a, int b, int expected) {
		this.a = a;
		this.b = b;
		this.expected = expected;
	}

	@Before
	public void setUp() {
		mathOperations = new MathOperations();
	}

	@Test
	public void given_TwoNumbers_when_CalculatesTheirMultiplication_then_ReturnTheCorrectResult() {
		int actual = mathOperations.multiplication(a, b);
		assertEquals(expected, actual);
	}

}
