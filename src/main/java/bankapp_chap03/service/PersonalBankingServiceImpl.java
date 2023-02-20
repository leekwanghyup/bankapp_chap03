package bankapp_chap03.service;

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
	
	public PersonalBankingServiceImpl(JmsMessageSender jmsMessageSender,
			EmailMessageSender emailMessageSender,
			WebServiceInvoker webServiceInvoker) {
		super(jmsMessageSender, emailMessageSender, webServiceInvoker);
	}
	
	@Override
	public BankStatement getMiniStatement() {
		return personalBakingDao.getMiniStatement();
	}
}
