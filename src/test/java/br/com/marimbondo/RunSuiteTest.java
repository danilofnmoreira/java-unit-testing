package br.com.marimbondo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.com.marimbondo.parameterization.ParameterizedMultiplicationTest;
import br.com.marimbondo.parameterization.ParameterizedSubtractionTest;
import br.com.marimbondo.rules.DivisionByZeroTest;
import br.com.marimbondo.rules.TimeOutRuleTest;

@RunWith(value = Suite.class)
@SuiteClasses({ MathOperationsTest.class, ParameterizedMultiplicationTest.class, ParameterizedSubtractionTest.class,
		DivisionByZeroTest.class, TimeOutRuleTest.class })
public class RunSuiteTest {

}
