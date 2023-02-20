package bankapp_chap03.beans;

import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BankDetailsTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:peropertyEditorConfig.xml");
		BankDetails bean = context.getBean(BankDetails.class);
		System.out.println(bean);
		context.close();
	}

}
