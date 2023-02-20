package bankapp_chap03.beans;

import java.util.Currency;
import java.util.Date;
import java.util.Properties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BankDetails {
	private String bankName;
	private byte[] bankPrimaryBusiness;
	private char[] headOfficeAddress;
	private char privateBank;
	private Currency primaryCurrency;
	private Properties branchAddresses;
	private Date dateOfInception;
}
