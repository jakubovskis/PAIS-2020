import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class MakePayment implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception{
		
		
		//Decide randomly if order is accepted or not
		execution.setVariable("paymentExecuted", true);
	}
}
