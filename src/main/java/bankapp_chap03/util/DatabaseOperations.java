package bankapp_chap03.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import bankapp_chap03.domain.BankStatement;
import bankapp_chap03.domain.FixedDepositDetails;

public class DatabaseOperations {
	
	private static Map<Long, FixedDepositDetails> fixedDeposits = 
							new HashMap<Long, FixedDepositDetails>();
	
	public boolean saveFd(FixedDepositDetails fdd) {
		fixedDeposits.put(fdd.getId(), fdd);
		return true;
	}

	public FixedDepositDetails loadFd(long id) {
		return fixedDeposits.get(id);
	}

	public BankStatement getMiniStatement() {
		return BankStatement.builder()
				.amount(100)
				.referenceNumber("Ref. no. 1")
				.transactionDate(new Date())
				.transactionType("credit").build();
	}
}
