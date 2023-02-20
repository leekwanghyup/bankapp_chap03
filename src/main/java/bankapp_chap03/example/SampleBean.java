package bankapp_chap03.example;

public class SampleBean {
	
	private ABean aBean; 
	private BBean bBean;

	public SampleBean(ABean aBean, BBean bBean) {
		this.aBean = aBean;
		this.bBean = bBean;
	}
	
	public void execute() {
		aBean.methodA();
		bBean.methodB();
	}
}
