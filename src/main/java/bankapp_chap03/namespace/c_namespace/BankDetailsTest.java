package bankapp_chap03.namespace.c_namespace;

import org.springframework.context.support.FileSystemXmlApplicationContext;

public class BankDetailsTest {
	public static void main(String[] args) {
		FileSystemXmlApplicationContext ctx = 
				new FileSystemXmlApplicationContext(
				"src/main/java/bankapp_chap03/namespace/c_namespace/c_namespaceContext.xml");
		BankDetails bean = ctx.getBean(BankDetails.class);
		System.out.println(bean);
	}
}
