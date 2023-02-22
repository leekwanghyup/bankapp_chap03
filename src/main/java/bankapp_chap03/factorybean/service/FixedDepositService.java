package bankapp_chap03.factorybean.service;

import java.util.HashMap;
import java.util.Map;

import bankapp_chap03.factorybean.event.EventSender;
import bankapp_chap03.factorybean.event.EventSenderFactoryBean;
import bankapp_chap03.factorybean.event.FixedDepositCreatedEvent;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FixedDepositService {
	
	private EventSenderFactoryBean eventSenderFactoryBean;
	
	public void createFixedDeposit() throws Exception {
		 
		FixedDepositCreatedEvent event = new FixedDepositCreatedEvent();
		Map<String, Object> eventData = new HashMap<String, Object>();
		eventData.put("amount", "100000");
		event.setEventData(eventData);
		
		EventSender eventSender = eventSenderFactoryBean.getObject();
		eventSender.sendEvent(event);
	}
}
