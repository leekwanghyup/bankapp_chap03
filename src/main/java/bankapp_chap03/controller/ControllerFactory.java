package bankapp_chap03.controller;

public class ControllerFactory {
	
	// 팩토리 메소드 : 자신에게 전달된 controllerName 인수값에 따라 
	// fixedDepositController, personalBankingController 생성
	public Object getController(String controllerName) {
		Object controller = null;
		if("fixedDepositController".equalsIgnoreCase(controllerName)) {
			controller = new FixedDepositControllerImpl();
		}
		if("personalBankingController".equalsIgnoreCase(controllerName)) {
			controller = new PersonalBankingControllerImpl();
		}
		return controller; 
	}
}
