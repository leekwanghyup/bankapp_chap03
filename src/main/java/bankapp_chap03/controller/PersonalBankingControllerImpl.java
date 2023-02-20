package bankapp_chap03.controller;

import bankapp_chap03.base.EmailMessageSender;
import bankapp_chap03.base.JmsMessageSender;
import bankapp_chap03.base.WebServiceInvoker;
import bankapp_chap03.domain.BankStatement;
import bankapp_chap03.service.PersonalBankingService;
import lombok.AllArgsConstructor;
import lombok.Setter;

@Setter
public class PersonalBankingControllerImpl implements PersonalBankingController {

	private PersonalBankingService personalBankingService;
	
	@Override
	public BankStatement getMiniStatement() {
		return personalBankingService.getMiniStatement();
	}
}
