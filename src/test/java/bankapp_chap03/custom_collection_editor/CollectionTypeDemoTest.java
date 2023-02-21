package bankapp_chap03.custom_collection_editor;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CollectionTypeDemoTest {
	
	@Test
	public void test() {
		ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("collectionTypeContext.xml");
		CollectionTypeDemo bean = context.getBean(CollectionTypeDemo.class);
		System.out.println(bean);
		context.close();
	}
}
