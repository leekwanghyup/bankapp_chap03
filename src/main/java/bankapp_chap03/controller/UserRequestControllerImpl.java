package bankapp_chap03.controller;

import bankapp_chap03.base.ServiceTemplate;
import bankapp_chap03.domain.Request;

public class UserRequestControllerImpl implements UserRequestController {
	
	private ServiceTemplate serviceTemplate;

	public UserRequestControllerImpl(ServiceTemplate serviceTemplate) {
		this.serviceTemplate = serviceTemplate;
	}

	@Override
	public void submitRequest(Request request) {
		System.out.println("UserRequestControllerImpl:submitRequest 실행");
		serviceTemplate.getJmsMessageSender().info();
	}

}
