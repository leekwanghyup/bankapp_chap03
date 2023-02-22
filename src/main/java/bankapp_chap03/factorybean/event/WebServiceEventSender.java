package bankapp_chap03.factorybean.event;

import java.util.Properties;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WebServiceEventSender implements EventSender {

	private Properties WebServiceProperties;
	
	@Override
	public void sendEvent(Event event) {
		System.out.println("WebServiceEventSender 이벤트 데이터베이스 저장");
	}

	@Override
	public void info() {
		System.out.println("WebServiceEventSender");
	}
}
