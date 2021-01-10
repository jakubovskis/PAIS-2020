import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ConfirmOrder implements JavaDelegate {

	private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());
	
	@Override
	public void execute(DelegateExecution execution) throws Exception{
				
		Boolean orderAccepted = (Boolean) execution.getVariable("orderAccepted");
		
		Boolean processFinished = true;
		if(orderAccepted) {
			processFinished = false;
		}
		
		execution.getProcessEngineServices()
	      .getRuntimeService()
	      .createMessageCorrelation("ConfirmOrderMessage")
	      .setVariable("orderAccepted", orderAccepted)
	      .setVariable("processFinished", processFinished)
	      .correlate();
		
	    LOGGER.info("\n\n  ... LoggerDelegate invoked by "
	            + "activtyName='" + execution.getCurrentActivityName() + "'"
	            + ", variables=" + execution.getVariables()
	            + " \n\n");
	}
}