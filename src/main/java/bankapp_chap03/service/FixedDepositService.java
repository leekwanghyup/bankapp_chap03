package bankapp_chap03.service;

import bankapp_chap03.dao.FixedDepositDao;
import bankapp_chap03.domain.FixedDepositDetails;

public interface FixedDepositService {
	
	FixedDepositDao getFixedDepositDao();

	FixedDepositDetails getFixedDepositDetails(long id);

	boolean createFixedDeposit(FixedDepositDetails fdd);
}
