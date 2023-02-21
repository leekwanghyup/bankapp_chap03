package bankapp_chap03.namespace.c_namespace;

import lombok.ToString;

import lombok.Setter;

import java.beans.ConstructorProperties;

import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import lombok.Getter;


@ToString
public class Address {
	String code; 
	String zip;
	
	public Address(String code, String zip) {
		this.code = code;
		this.zip = zip;
	}
}
