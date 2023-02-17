package bankapp_chap03.dao;

import bankapp_chap03.domain.BankStatement;
import bankapp_chap03.util.DatabaseOperations;
import lombok.Setter;

@Setter
public class PersonalBankingDaoImpl implements PersonalBakingDao {

	private DatabaseOperations databaseOperations;
	
	@Override
	public BankStatement getMiniStatement() {
		return databaseOperations.getMiniStatement();
	}
}
