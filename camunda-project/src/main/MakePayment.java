import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.google.gson.Gson;

public class MakePayment implements JavaDelegate {

	private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());
	
	@Override
	public void execute(DelegateExecution execution) throws Exception{
		
		//Get set data and imagine here billing the price to the user bank account
		long price = (long) execution.getVariable("price");
		
		
		//Decide randomly if order is accepted or not
		execution.setVariable("paymentExecuted", true);
		execution.setVariable("fullSuccess", false);
		
		
	    LOGGER.info("\n\n  ... LoggerDelegate invoked by "
	            + "activtyName='" + execution.getCurrentActivityName() + "'"
	            + ", variables=" + execution.getVariables()
	            + " \n\n");
	}
}
