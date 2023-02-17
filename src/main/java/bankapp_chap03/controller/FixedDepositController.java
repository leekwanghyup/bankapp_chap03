package bankapp_chap03.controller;

import bankapp_chap03.domain.FixedDepositDetails;
import bankapp_chap03.service.FixedDepositService;

public interface FixedDepositController {
	
	FixedDepositService getFixedDepositService();

	boolean submit(FixedDepositDetails fixedDepositDetails);

	FixedDepositDetails get();
}
