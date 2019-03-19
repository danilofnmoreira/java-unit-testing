package br.com.marimbondo;

public class MathOperations {

	public static void main(String[] args) {
		new MathOperations().division(1, 0);
	}

	public int multiplication(int a, int b) {
		return a * b;
	}

	public int addition(int a, int b) {
		return a + b;
	}

	public int division(int a, int b) {
		return a / b;
	}

	public int subtration(int a, int b) {
		return a - b;
	}

	public int divisionWithMessageException(int a, int b) {
		if (b != 0)
			return a / b;
		else
			throw new ArithmeticException("Nao eh valido a divisao por zero");
	}
}
