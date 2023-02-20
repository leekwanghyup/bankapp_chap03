package bankapp_chap03.beans;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionTypeExampleTest {

	@Test
	public void test() {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:peropertyEditorConfig.xml");
		CollectionTypeExample bean = context.getBean(CollectionTypeExample.class);
		System.out.println(bean.getStringList());
		System.out.println(bean.getMapList());
	}
}
