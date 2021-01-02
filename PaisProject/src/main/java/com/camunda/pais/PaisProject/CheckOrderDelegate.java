package com.camunda.pais.PaisProject;

import java.util.Random;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class CheckOrderDelegate implements JavaDelegate {

	@Override
	public void execute(DelegateExecution execution) throws Exception {
		
		Random randNumber = new Random();
		execution.setVariable("acceptOrder", randNumber.nextBoolean());
		
	}

}
