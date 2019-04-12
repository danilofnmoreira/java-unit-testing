package br.com.marimbondo;

public class EmailMessageServiceImpl implements MessageService {

	@Override
	public void send(String message, String receiver) {
		System.out.println("EMAIL");
		System.out.println("Message = " + message);
		System.out.println("Receiver = " + receiver);
	}

}
