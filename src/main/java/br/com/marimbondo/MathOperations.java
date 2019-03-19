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
}
