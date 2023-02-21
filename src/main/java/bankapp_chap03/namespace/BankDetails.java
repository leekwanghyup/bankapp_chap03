package bankapp_chap03.namespace;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BankDetails {
	String bankName; 
	Address Address;  
}
