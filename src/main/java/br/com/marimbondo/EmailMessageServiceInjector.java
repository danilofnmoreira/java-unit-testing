package br.com.marimbondo;

public class EmailMessageServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		return new Consumer(new EmailMessageServiceImpl());
	}

}
