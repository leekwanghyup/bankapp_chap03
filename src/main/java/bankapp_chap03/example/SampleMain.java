package bankapp_chap03.example;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SampleMain {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("classpath:exampleContext.xml");
		SampleBean bean = context.getBean(SampleBean.class);
		bean.execute();
	}
}
