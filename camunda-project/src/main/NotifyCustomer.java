import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import java.util.logging.Logger;

public class NotifyCustomer implements JavaDelegate {

	private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());
	
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
	    
	    LOGGER.info("\n\n  ... LoggerDelegate invoked by "
	            + "activtyName='" + execution.getCurrentActivityName() + "'"
	            + ", variables=" + execution.getVariables()
	            + " \n\n");
	}
}