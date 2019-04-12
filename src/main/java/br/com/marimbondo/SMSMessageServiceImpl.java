package br.com.marimbondo;

public class SMSMessageServiceImpl implements MessageService {

	@Override
	public void send(String message, String receiver) {
		System.out.println("SMS");
		System.out.println("Message = " + message);
		System.out.println("Receiver = " + receiver);
	}

}
