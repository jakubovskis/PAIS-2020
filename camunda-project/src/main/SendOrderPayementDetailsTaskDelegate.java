import java.util.Map;
import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import com.google.gson.Gson;

public class SendOrderPayementDetailsTaskDelegate implements JavaDelegate {

	private final Logger LOGGER = Logger.getLogger(LoggerDelegate.class.getName());
	
	@Override
	  public void execute(DelegateExecution execution) throws Exception {

		Map<String, Object> variables = execution.getVariables();
		 
		long price = (long) variables.get("price");
		String food = (String) variables.get("food");
		String restaurant = (String) variables.get("restaurant");
				
	    execution.getProcessEngineServices()
	      .getRuntimeService()
	      .createMessageCorrelation("OrderMessage")
	      .setVariable("food", food)
	      .setVariable("price", price)
	      .setVariable("restaurant", restaurant)
	      .correlate();
	    
	    
	    LOGGER.info("\n\n  ... LoggerDelegate invoked by "
	            + "activtyName='" + execution.getCurrentActivityName() + "'"
	            + ", variables=" + execution.getVariables()
	            + " \n\n");
	  }
}
