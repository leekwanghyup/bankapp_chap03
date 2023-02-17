package bankapp_chap03.dao;

import bankapp_chap03.domain.FixedDepositDetails;
import bankapp_chap03.util.DatabaseOperations;
import lombok.Setter;

@Setter
public class FixedDepositDaoImpl implements FixedDepositDao {
	
	private DatabaseOperations databaseOperations;

	public FixedDepositDaoImpl() {
		System.out.println("FixedDepositDaoImpl 생성");
	}
	
	@Override
	public FixedDepositDetails getFixedDepositDetails(long id) {
		return databaseOperations.loadFd(id);
	}

	@Override
	public boolean createFixedDeposit(FixedDepositDetails fdd) {
		return databaseOperations.saveFd(fdd);
	}
}
