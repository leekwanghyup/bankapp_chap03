package bankapp_chap03.service;

import static org.junit.Assert.fail;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TransferFundsServiceImplTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		TransferFundsServiceImpl bean = context.getBean(TransferFundsServiceImpl.class);
		bean.transferFunds();
	}
}
