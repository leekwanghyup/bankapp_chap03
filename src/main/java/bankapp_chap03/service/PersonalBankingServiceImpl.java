package bankapp_chap03.service;

import bankapp_chap03.dao.PersonalBakingDao;
import bankapp_chap03.domain.BankStatement;
import lombok.Setter;

@Setter
public class PersonalBankingServiceImpl implements PersonalBankingService {

	private PersonalBakingDao personalBakingDao;
	
	@Override
	public BankStatement getMiniStatement() {
		return personalBakingDao.getMiniStatement();
	}
}
