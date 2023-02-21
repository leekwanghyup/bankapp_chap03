package bankapp_chap03.namespace.c_namespace;

import java.beans.ConstructorProperties;

import lombok.ToString;


@ToString
public class BankDetails {
	String bankName; 
	Address Address;
	
	public BankDetails(String bankName, Address address) {
		this.bankName = bankName;
		Address = address;
	}
}
