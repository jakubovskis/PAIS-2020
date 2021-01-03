import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class PayRestaurant implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception{
				
	    execution.getProcessEngineServices()
	      .getRuntimeService()
	      .createMessageCorrelation("PayedMessage")
	      .correlate();
	}
}
