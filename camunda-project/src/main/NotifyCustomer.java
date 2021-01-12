import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import java.util.logging.Logger;

public class NotifyCustomer implements JavaDelegate {

	private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());
	
	@Override
	public void execute(DelegateExecution execution) throws Exception{
				
		boolean paymentsuccess = (boolean) execution.getVariable("paymentExecuted");
		boolean processFinished = (boolean) execution.getVariable("processFinished");
		boolean refunded = (boolean) execution.getVariable("refunded");

		String message = "Payment failed";
		
		if (paymentsuccess) {
			message = "Restaurant could not take your order";
		}
		
		if (processFinished) {
			message = "Order arrived";
		}
		
	    execution.getProcessEngineServices()
	      .getRuntimeService()
	      .createMessageCorrelation("NotifyCustomerMessage")
	      .setVariable("NotifyCustomerText", message)
	      .setVariable("processFinished", processFinished)
	      .setVariable("refunded", refunded)
	      .correlate();
	    
	    LOGGER.info("\n\n  ... LoggerDelegate invoked by "
	            + "activtyName='" + execution.getCurrentActivityName() + "'"
	            + ", variables=" + execution.getVariables()
	            + " \n\n");
	}
}