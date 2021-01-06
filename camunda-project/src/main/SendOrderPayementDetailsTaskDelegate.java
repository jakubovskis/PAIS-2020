import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendOrderPayementDetailsTaskDelegate implements JavaDelegate {

	@Override
	  public void execute(DelegateExecution execution) throws Exception {

		String food = (String) execution.getVariable("food");
		  
	    execution.getProcessEngineServices()
	      .getRuntimeService()
	      .createMessageCorrelation("OrderMessage")
	      .setVariable("food", food)
	      .correlate();

	  }
}
