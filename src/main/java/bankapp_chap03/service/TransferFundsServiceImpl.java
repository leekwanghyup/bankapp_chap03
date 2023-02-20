package bankapp_chap03.service;

import java.beans.ConstructorProperties;

public class TransferFundsServiceImpl implements TransferFundsService {

	private String webServiceUrl;
	private boolean active;
	private long timeout;
	private int numberOfRetrialAttempts;
	
	@ConstructorProperties(value = {
			"webServiceUrl", "active", "timeout","numberOfRetrialAttempts"
	})
	public TransferFundsServiceImpl(String webServiceUrl, boolean active, 
			long timeout, int numberOfRetrialAttempts) {
		this.webServiceUrl = webServiceUrl;
		this.active = active;
		this.timeout = timeout;
		this.numberOfRetrialAttempts = numberOfRetrialAttempts;
	}

	@Override
	public void transferFunds() {
		System.out.println("=================================================");
		System.out.println("transferFunds메서드실행");
		System.out.println("webServiceUrl : "+webServiceUrl);
		System.out.println("active : "+active);
		System.out.println("timeout : "+timeout);
		System.out.println("numberOfRetrialAttempts : "+numberOfRetrialAttempts);
		System.out.println("=================================================");
	}
}
