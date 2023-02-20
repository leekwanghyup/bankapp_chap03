package bankapp_chap03.service;

import java.beans.ConstructorProperties;

import bankapp_chap03.base.EmailMessageSender;
import bankapp_chap03.base.JmsMessageSender;
import bankapp_chap03.base.ServiceTemplate;
import bankapp_chap03.base.WebServiceInvoker;
import bankapp_chap03.dao.PersonalBakingDao;
import bankapp_chap03.domain.BankStatement;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PersonalBankingServiceImpl extends ServiceTemplate implements PersonalBankingService {

	private PersonalBakingDao personalBakingDao;
	
	public PersonalBankingServiceImpl(JmsMessageSender jms,
			EmailMessageSender email, WebServiceInvoker invoker) {
		super(jms, email, invoker);
	}
	
	@Override
	public BankStatement getMiniStatement() {
		return personalBakingDao.getMiniStatement();
	}
}
