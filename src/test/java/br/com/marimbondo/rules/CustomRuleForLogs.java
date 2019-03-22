package br.com.marimbondo.rules;

import static java.lang.System.out;

import org.junit.rules.TestRule;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class CustomRuleForLogs implements TestRule {

	@Override // A classe Statement represeta um Test no framework Junit e o seu metodo
				// .evaluate executa o Test. A classe Description fornece informacoes relevantes
				// referente ao Test corrente.
	public Statement apply(Statement base, Description description) {
		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				out.println("start test " + description.getMethodName());
				base.evaluate();
				out.println("finished test " + description.getMethodName());
			}
		};
	}

}
