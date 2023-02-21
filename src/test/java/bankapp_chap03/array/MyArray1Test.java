package bankapp_chap03.array;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyArray1Test {

	@Test
	public void test() {
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("classpath:arrayContext.xml");
		MyArray1 bean = context.getBean(MyArray1.class);
		System.out.println(Arrays.toString(bean.getNumbersProp()));
	}
}
