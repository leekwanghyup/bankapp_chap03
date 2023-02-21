package bankapp_chap03.factorybean.event;

import java.util.Properties;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class MessagingEventSender implements EventSender{

	private Properties messagingProperties;
	
	@Override
	public void snedEvent(Event event) {
		System.out.println("DatabaseEventSender 이벤트 데이터베이스 저장");
	}

}
