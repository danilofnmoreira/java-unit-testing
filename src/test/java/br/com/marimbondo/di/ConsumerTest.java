package br.com.marimbondo.di;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import br.com.marimbondo.Consumer;
import br.com.marimbondo.MessageServiceInjector;

public class ConsumerTest {

	private Consumer consumer;

	@Before
	public void setUp() {
		MessageServiceInjector injector = () -> new Consumer((message, receiver) -> {
			System.out.println("MOCK");
			System.out.println("Message = " + message);
			System.out.println("Receiver = " + receiver);
		});
		this.consumer = injector.getConsumer();
	}

	@Test
	public void processMessage() {
		String message = "Minha mensagem";
		String receiver = "Danilo";
		consumer.processMessage(message, receiver);
		Assert.assertTrue(true);
	}

}
