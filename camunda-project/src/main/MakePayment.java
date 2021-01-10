import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import com.google.gson.Gson;

public class MakePayment implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception{
		
		//Get set data and imagine here billing the price to the user bank account
		long price = (long) execution.getVariable("price");
		
		 try {
		      File myObj = new File("log.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		      FileWriter myWriter = new FileWriter("log.txt");
		      myWriter.write("So: " + price);
		      myWriter.close();
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		
		//Decide randomly if order is accepted or not
		execution.setVariable("paymentExecuted", true);
		execution.setVariable("fullSuccess", false);
		
	}
}
