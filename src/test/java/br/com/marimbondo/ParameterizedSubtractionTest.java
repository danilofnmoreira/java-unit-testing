package br.com.marimbondo;

import static java.util.List.of;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class) // Esta classe só pode conter 1 unico metodo de teste.
public class ParameterizedSubtractionTest {

	@Parameters(name = "Param Subtration {index}; values {0}*{1}={2} ") // repare o nome dos metodos
	public static Iterable<Integer[]> parameters() {  // O metodo de parametros deve ser estatico e retornar um Iterable de Arrays
		Iterable<Integer[]> params = of(
				new Integer[] {1, 2, -1},
				new Integer[] {0, 2, -2},
				new Integer[] {4, 8, -4},
				new Integer[] {9, 9,  0}
				);
		return params;
	}

	private MathOperations mathOperations;

	// anotando as variaveis de instancia com @Parameter, nao eh necessario a declaracao do construtor recebendo os parametros
	@Parameter(0) private int a;
	@Parameter(1) private int b;
	@Parameter(2) private int expected;

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
