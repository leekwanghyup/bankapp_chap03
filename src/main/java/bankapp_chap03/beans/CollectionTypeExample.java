package bankapp_chap03.beans;

import java.util.List;
import java.util.Map;

import lombok.Getter;

@Getter
public class CollectionTypeExample {
	
	List<List<String>> stringList;
	Map<String, List<String>> mapList;

	public CollectionTypeExample(List<List<String>> stringList, Map<String, List<String>> mapList) {
		this.stringList = stringList;
		this.mapList = mapList;
	}
}
