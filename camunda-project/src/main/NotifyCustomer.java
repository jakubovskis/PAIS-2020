import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class NotifyCustomer implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception{
				
		
	    execution.getProcessEngineServices()
	      .getRuntimeService()
	      .createMessageCorrelation("NotifyCustomerMessage")
	      .setVariable("NotifyCustomerText", "Payment failed")
	      .correlate();
	}
}