package bankapp_chap03.namespace;

import lombok.ToString;

import lombok.Setter;

import lombok.Getter;

@Getter
@Setter
@ToString
public class Address {
	String code; 
	String zip;
}
