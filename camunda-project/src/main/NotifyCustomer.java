import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class NotifyCustomer implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception{
				
		boolean paymentsuccess = (boolean) execution.getVariable("paymentExecuted");
		boolean fullsuccess = (boolean) execution.getVariable("fullSuccess");

		String message = "Payment failed";
		
		if (paymentsuccess) {
			message = "Restaurant could not take your order";
		}
		
		if (fullsuccess) {
			message = "Order arrived";
		}
		
	    execution.getProcessEngineServices()
	      .getRuntimeService()
	      .createMessageCorrelation("NotifyCustomerMessage")
	      .setVariable("NotifyCustomerText", message)
	      .correlate();
	}
}