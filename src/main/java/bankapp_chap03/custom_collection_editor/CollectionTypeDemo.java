package bankapp_chap03.custom_collection_editor;

import java.util.List;
import java.util.Set;

import lombok.Setter;
import lombok.ToString;

@Setter
@ToString
public class CollectionTypeDemo {
	private Set<String> setType; 
	private List<String> listType;
}
