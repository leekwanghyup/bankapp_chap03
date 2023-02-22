package bankapp_chap03.factorybean;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bankapp_chap03.factorybean.event.EventSender;
import bankapp_chap03.factorybean.event.EventSenderFactoryBean;
import bankapp_chap03.factorybean.service.FixedDepositService;

public class FactoryBeanMain {
	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext context 
			= new ClassPathXmlApplicationContext("factoryBeanContext.xml");
		FixedDepositService bean = context.getBean(FixedDepositService.class);
		bean.createFixedDeposit();
		System.out.println("=====================");
		
		// 타입으로 얻을 때는 동일한다. 이름으로 얻을 때는 빈 id앞에 &를 붙인다. 
		EventSenderFactoryBean eventSenderFactoryBean = (EventSenderFactoryBean) context.getBean("&eventSenderFactory");
		EventSender eventSender = eventSenderFactoryBean.getObject();
		eventSender.info();
	}
}
