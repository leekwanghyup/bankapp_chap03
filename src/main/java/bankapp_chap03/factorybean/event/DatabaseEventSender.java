package bankapp_chap03.factorybean.event;

import java.util.Map;
import java.util.Properties;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DatabaseEventSender implements EventSender {

	private Properties databaseProperties;
	
	@Override
	public void snedEvent(Event event) {
		System.out.println(event.getEventType());
		Map<String,Object> eventData = event.getEventData();
		System.out.println(eventData);
		System.out.println("DatabaseEventSender 이벤트 데이터베이스 저장");
	}
	
}
