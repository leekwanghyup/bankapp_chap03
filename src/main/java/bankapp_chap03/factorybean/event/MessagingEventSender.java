package bankapp_chap03.factorybean.event;

import java.util.Properties;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MessagingEventSender implements EventSender{

	private Properties messagingProperties;
	
	@Override
	public void sendEvent(Event event) {
		System.out.println("MessagingEventSender 이벤트 데이터베이스 저장");
	}

	@Override
	public void info() {
		System.out.println("MessagingEventSender");
	}
}
