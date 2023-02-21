package bankapp_chap03.collection_ref;

import java.util.List;
import java.util.Map;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class DemoVO {
	private List<DemoBean> demoList;
	private Map<DemoBean, DemoBean> demoMap;
}
