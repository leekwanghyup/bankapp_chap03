package bankapp_chap03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bankapp_chap03.service.FixedDepositServiceImpl;
import bankapp_chap03.service.PersonalBankingServiceImpl;

public class BankApp2 {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		
		PersonalBankingServiceImpl bean = context.getBean(PersonalBankingServiceImpl.class);
		bean.getEmailMessageSender().info();
		bean.getJmsMessageSender().info();
		bean.getWebServiceInvoker().info();
		
		FixedDepositServiceImpl bean2 = context.getBean(FixedDepositServiceImpl.class);
		bean2.getEmailMessageSender().info();
		bean2.getJmsMessageSender().info();
		bean2.getWebServiceInvoker().info();
		
		context.close();
	}
}
