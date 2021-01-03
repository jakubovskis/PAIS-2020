import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class SendOrderPayementDetailsTaskDelegate implements JavaDelegate {

	@Override
	  public void execute(DelegateExecution execution) throws Exception {

//		String orderDetails = (String) execution.getVariable("orderdetails");
		  
	    execution.getProcessEngineServices()
	      .getRuntimeService()
	      .createMessageCorrelation("OrderMessage")
	      .correlate();

	  }
}
