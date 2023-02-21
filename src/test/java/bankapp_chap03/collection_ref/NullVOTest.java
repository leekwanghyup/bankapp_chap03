package bankapp_chap03.collection_ref;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class NullVOTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:collectionRefContext.xml");
		NullVO bean = context.getBean(NullVO.class);
		System.out.println(bean);
	}
}
