package bankapp_chap03.factorybean.event;

import java.util.Map;

public interface Event {
	String getEventType(); // 이벤트 타입
	void setEventData(Map<String, Object> eventData); // 이벤트 설정
	Map<String, Object> getEventData(); // 설정된 이벤트 얻기
}
