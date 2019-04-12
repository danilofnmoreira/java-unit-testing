package br.com.marimbondo;

public class SMSMessageServiceInjector implements MessageServiceInjector {

	@Override
	public Consumer getConsumer() {
		return new Consumer(new SMSMessageServiceImpl());
	}

}
