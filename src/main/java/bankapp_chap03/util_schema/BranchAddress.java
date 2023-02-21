package bankapp_chap03.util_schema;

import java.util.Properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
@Setter
@Getter
public class BranchAddress {
	Properties nameProp; 
	Properties dbInfo;
}
