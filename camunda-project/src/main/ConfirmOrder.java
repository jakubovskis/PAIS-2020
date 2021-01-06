import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class ConfirmOrder implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception{
				
		Boolean orderAccepted = (Boolean) execution.getVariable("orderAccepted");
		
		execution.getProcessEngineServices()
	      .getRuntimeService()
	      .createMessageCorrelation("ConfirmOrderMessage")
	      .setVariable("orderAccepted", orderAccepted)
	      .correlate();
	}
}