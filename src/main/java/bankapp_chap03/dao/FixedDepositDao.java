package bankapp_chap03.dao;

import bankapp_chap03.domain.FixedDepositDetails;

public interface FixedDepositDao {

	FixedDepositDetails getFixedDepositDetails(long id);

	boolean createFixedDeposit(FixedDepositDetails fdd);
}
