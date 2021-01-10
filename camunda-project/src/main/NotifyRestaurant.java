import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class NotifyRestaurant implements JavaDelegate {

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
	}
}