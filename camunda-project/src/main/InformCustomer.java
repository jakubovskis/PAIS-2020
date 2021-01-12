import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class InformCustomer implements JavaDelegate {

	private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());
	
	@Override
	public void execute(DelegateExecution execution) throws Exception{
		
		//Here the food is being made, so just here to inform Customer of status of the process
		boolean orderAccepted = (boolean) execution.getVariable("orderAccepted");
	    
	    execution.getProcessEngineServices()
	      .getRuntimeService()
	      .createMessageCorrelation("NotifyCustomerMessage")
	      .setVariable("information", "Order is being prepared.")
	      .setVariable("orderAccepted", orderAccepted)
	      .setVariable("processFinished", false)
	      .correlate();
	    
	    LOGGER.info("\n\n  ... LoggerDelegate invoked by "
	            + "activtyName='" + execution.getCurrentActivityName() + "'"
	            + ", variables=" + execution.getVariables()
	            + " \n\n");
	    
	}
}