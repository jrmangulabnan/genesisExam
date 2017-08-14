package com.genesis.exam.processor.impl;

import com.genesis.exam.enums.EscalateType;
import com.genesis.exam.model.Call;
import com.genesis.exam.processor.Employee;
import com.genesis.exam.util.EmployeeFactory;
import com.genesis.exam.util.Randomizer;

public class EmployeeTL extends Employee{
	
	private EmployeeTL() {
	}
	
	private static EmployeeTL instance = null;

	public static EmployeeTL getInstance() {
		if (instance == null) {
			instance = new EmployeeTL();
		}
		return instance;
	}

	public void takeCall() {
		while (!blockingQueue.isEmpty()) {
			try {
				// let's process it
				Call call = blockingQueue.take();
				
				if (Randomizer.generateRandomBoolean()) {
					//random if it will escalate to PM then lets queue it to PM and since it's escalated it 
					Employee employeePM = EmployeeFactory.getEmployee("PM");
					call.setEscalationType(EscalateType.UNRESOLVED.toString());
					
					employeePM.blockingQueue.put(call);
					employeePM.takeCall();
					System.out.println("TL Escalate it to PM");
				}else{
					//TODO: do whatever we need to call but for now lets assume that the TL already take care of it so we will					
					call.setIsDone(Boolean.TRUE);
					System.out.println("TL handles and finish the call :)");
				}
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
