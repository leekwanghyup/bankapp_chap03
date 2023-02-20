package bankapp_chap03.beans;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DataTypesExampleTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:peropertyEditorConfig.xml");
		DataTypesExample bean = context.getBean(DataTypesExample.class);
		System.out.println(bean);
	}

}
