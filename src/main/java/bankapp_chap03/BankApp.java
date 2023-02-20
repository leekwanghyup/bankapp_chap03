package bankapp_chap03;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import bankapp_chap03.controller.FixedDepositController;
import bankapp_chap03.controller.PersonalBankingController;
import bankapp_chap03.domain.FixedDepositDetails;

public class BankApp {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		FixedDepositController fixedDepositController = context.getBean(FixedDepositController.class);
		PersonalBankingController personalBankingController = context.getBean(PersonalBankingController.class);
		
		FixedDepositDetails depositDetails = context.getBean(FixedDepositDetails.class); 
		depositDetails.setDepositAmount(100);
		depositDetails.setEmail("someemail@somedomain.com");
		depositDetails.setId(1);
		depositDetails.setTenure(10);
		
		fixedDepositController.submit(depositDetails);
		System.out.println(fixedDepositController.get());
		
		System.out.println(personalBankingController.getMiniStatement());
		context.close();
	}
}
