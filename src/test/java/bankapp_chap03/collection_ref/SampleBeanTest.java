package bankapp_chap03.collection_ref;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SampleBeanTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:collectionRefContext.xml");
		SampleBean bean = context.getBean(SampleBean.class);
		System.out.println(bean);
	}

}
