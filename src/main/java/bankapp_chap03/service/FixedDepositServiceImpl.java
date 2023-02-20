package bankapp_chap03.service;

import bankapp_chap03.base.EmailMessageSender;
import bankapp_chap03.base.JmsMessageSender;
import bankapp_chap03.base.ServiceTemplate;
import bankapp_chap03.base.WebServiceInvoker;
import bankapp_chap03.dao.FixedDepositDao;
import bankapp_chap03.domain.FixedDepositDetails;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FixedDepositServiceImpl extends ServiceTemplate implements FixedDepositService {

	private FixedDepositDao fixedDepositDao;
	
	public FixedDepositServiceImpl() {
		System.out.println("FixedDepositServiceImpl 생성");
	}
	
	public FixedDepositServiceImpl(JmsMessageSender jmsMessageSender,
			EmailMessageSender emailMessageSender,
			WebServiceInvoker webServiceInvoker) {
		super(jmsMessageSender, emailMessageSender, webServiceInvoker);
	}

	@Override
	public FixedDepositDao getFixedDepositDao() {
		return fixedDepositDao;
	}

	@Override
	public FixedDepositDetails getFixedDepositDetails(long id) {
		return fixedDepositDao.getFixedDepositDetails(id);
	}

	@Override
	public boolean createFixedDeposit(FixedDepositDetails fdd) {
		return fixedDepositDao.createFixedDeposit(fdd);
	}
}
