package br.com.marimbondo;

public class Consumer {

	private MessageService messageService;

	public Consumer(MessageService messageService) {
		this.messageService = messageService;
	}
	
	public void processMessage(String message, String receiver) {
		messageService.send(message, receiver);
	}

}
