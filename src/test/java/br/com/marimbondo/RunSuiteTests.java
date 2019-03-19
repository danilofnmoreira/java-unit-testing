package br.com.marimbondo;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(value = Suite.class)
@SuiteClasses({
	 MathOperationsTest.class,
	 ParameterizedMultiplicationTest.class,
	 ParameterizedSubtractionTest.class
})
public class RunSuiteTests {

}
