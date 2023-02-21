package bankapp_chap03.collection_ref;

import java.util.Map;

import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class SampleBean {
	Map<String, DemoBean> beanList;
}
