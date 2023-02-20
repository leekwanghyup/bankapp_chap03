package bankapp_chap03.controller;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import bankapp_chap03.domain.Request;

public class UserRequestControllerImplTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		UserRequestController bean = context.getBean(UserRequestController.class);
		bean.submitRequest(new Request());
	}
}
