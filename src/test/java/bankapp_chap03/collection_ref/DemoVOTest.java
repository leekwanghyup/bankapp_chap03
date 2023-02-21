package bankapp_chap03.collection_ref;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoVOTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:collectionRefContext.xml");
		DemoVO bean = context.getBean(DemoVO.class,"demoVO");
		System.out.println(bean);
	}

}
