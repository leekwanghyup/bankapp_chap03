package bankapp_chap03.controller;

import bankapp_chap03.domain.FixedDepositDetails;
import bankapp_chap03.service.FixedDepositService;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FixedDepositControllerImpl implements FixedDepositController {

	private FixedDepositService fixedDepositService;
	
	public FixedDepositControllerImpl() {
		System.out.println("FixedDepositControllerImpl 생성");
	}
	
	@Override
	public FixedDepositDetails get() {
		return fixedDepositService.getFixedDepositDetails(1L);
	}

	@Override
	public boolean submit(FixedDepositDetails fixedDepositDetails) {
		return fixedDepositService.createFixedDeposit(fixedDepositDetails);
	}

}
