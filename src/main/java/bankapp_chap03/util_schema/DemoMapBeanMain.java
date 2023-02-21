package bankapp_chap03.util_schema;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DemoMapBeanMain {
	public static void main(String[] args) {
		String path = "src/main/java/bankapp_chap03/util_schema/";
		ApplicationContext ctx 
			= new FileSystemXmlApplicationContext(path+"schemaContext.xml");
		DemoMapBean mapBean = ctx.getBean(DemoMapBean.class);
		System.out.println(mapBean);
	}
}
