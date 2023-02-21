package bankapp_chap03.util_schema;

import java.util.List;

import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
public class SimpleBean {
	private List<Box> boxList; 
	private List<String> nameList;
}
