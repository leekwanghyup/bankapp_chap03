package bankapp_chap03.controller;

import bankapp_chap03.domain.BankStatement;
import bankapp_chap03.service.PersonalBankingService;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PersonalBankingControllerImpl implements PersonalBankingController {

	private PersonalBankingService personalBankingService;
	
	@Override
	public BankStatement getMiniStatement() {
		return personalBankingService.getMiniStatement();
	}
}
