package bankapp_chap03.util_schema.constant;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class DemoConstantMain {
	public static void main(String[] args) {
		String path = "src/main/java/bankapp_chap03/util_schema/";
		ApplicationContext ctx 
			= new FileSystemXmlApplicationContext(path+"schemaContext.xml");
		DemoConstant bean = ctx.getBean(DemoConstant.class);
		System.out.println(bean);
	}
}
