import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PayRestaurant implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception{
		
		//Imagine paying here the restaurant the amount of the given price 
		int price = (int) execution.getVariable("price");
		
		execution.setVariable("fullSuccess", true);
		
	    execution.getProcessEngineServices()
	      .getRuntimeService()
	      .createMessageCorrelation("PayedMessage")
	      .correlate();
	}
}
