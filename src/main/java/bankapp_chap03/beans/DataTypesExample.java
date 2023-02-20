package bankapp_chap03.beans;

import java.beans.ConstructorProperties;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import lombok.ToString;

@ToString
public class DataTypesExample {
	
	List<String> listType;
	Properties propertiesType;
	Properties anotherPropertiesType;
	Map mapType;
	Set setType;
	
	@ConstructorProperties({"listType","propertiesType","anotherPropertiesType","mapType","setType"})
	public DataTypesExample(List<String> listType, Properties propertiesType, Properties anotherPropertiesType,
			Map mapType, Set setType) {
		this.listType = listType;
		this.propertiesType = propertiesType;
		this.anotherPropertiesType = anotherPropertiesType;
		this.mapType = mapType;
		this.setType = setType;
	}
}
