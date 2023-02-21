package bankapp_chap03.factorybean.event;

import java.io.InputStream;
import java.util.Properties;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.core.io.ClassPathResource;

import lombok.Setter;

@Setter
public class EventSenderFactoryBean implements FactoryBean<EventSender>{

	// properties파일경로
	private String databasePropertiesFile; 
	private String webServicePropertiesFile;
	private String messagingPropertiesFile;
	
	
	// FactoryBean 구현이 관리하는 객체 반환
	@Override
	public EventSender getObject() throws Exception {
		EventSender eventSender = null;
		Properties properties = new Properties();
		
		ClassPathResource databaseProperties = null;
		ClassPathResource webServiceProperties = null;
		ClassPathResource messagingProperties = null;
		
		// 파일의 경로를 나타내는 필드에 값이 있으면 ClassPathResource객체 생성
		if (databasePropertiesFile != null) {
			databaseProperties = new ClassPathResource(databasePropertiesFile);
		}
		if (webServicePropertiesFile != null) {
			webServiceProperties = new ClassPathResource(
					webServicePropertiesFile);
		}
		if (messagingPropertiesFile != null) {
			messagingProperties = new ClassPathResource(messagingPropertiesFile);
		}
		
		// 해당 경로에 파일이 존재하는지 검사하고 
		// 파일이 존재한다면 읽은 후 Properties객체에 저장하여 해당 객체생성
		if(databaseProperties!=null && databaseProperties.exists()) {
			InputStream inStream = databaseProperties.getInputStream();
			properties.load(inStream);
			eventSender = new DatabaseEventSender(properties);
		} else if (webServiceProperties != null && webServiceProperties.exists()) {
			InputStream inStream = webServiceProperties.getInputStream();
			properties.load(inStream);
			eventSender = new WebServiceEventSender(properties);
		} else if (messagingProperties != null && messagingProperties.exists()) {
			InputStream inStream = messagingProperties.getInputStream();
			properties.load(inStream);
			eventSender = new MessagingEventSender(properties);
		}
		return eventSender;
	}

	// FactoryBean 구현이 관리하는 객체 타입 반환
	@Override
	public Class<?> getObjectType() {
		return EventSender.class;
	}
	
	// 싱글턴 여부 
	// true : getObject가 반환하는 객체를 캐시에 저장하고 그 이후의 요청은 캐시에 저장한 객체를 반환
	// false : 객체를 요청할 때 마다 매번 getObject 새로운 객체를 반환한다.
	@Override
	public boolean isSingleton() {
		return true;
	}

}
