package bankapp_chap03.factorybean.event;

import java.util.Properties;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class WebServiceEventSender implements EventSender {

	private Properties WebServiceProperties;
	
	@Override
	public void snedEvent(Event event) {
		System.out.println("WebServiceEventSender 이벤트 데이터베이스 저장");
	}

}
