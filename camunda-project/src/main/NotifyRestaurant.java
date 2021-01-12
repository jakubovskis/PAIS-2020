import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class NotifyRestaurant implements JavaDelegate {

	private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());
	
	@Override
	public void execute(DelegateExecution execution) throws Exception{
		
		//Imagine here finding the right restaurant, by restaurtant id
		String restaurant = (String) execution.getVariable("restaurant");
		
		String food = (String) execution.getVariable("food");
		
	    execution.getProcessEngineServices()
	      .getRuntimeService()
	      .createMessageCorrelation("NotifyRestaurantMessage")
	      .setVariable("food", food)
	      .correlate();
	    
	    LOGGER.info("\n\n  ... LoggerDelegate invoked by "
	            + "activtyName='" + execution.getCurrentActivityName() + "'"
	            + ", variables=" + execution.getVariables()
	            + " \n\n");
	}
}