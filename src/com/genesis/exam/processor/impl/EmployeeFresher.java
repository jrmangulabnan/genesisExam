package com.genesis.exam.processor.impl;

import com.genesis.exam.enums.EscalateType;
import com.genesis.exam.model.Call;
import com.genesis.exam.processor.Employee;
import com.genesis.exam.util.EmployeeFactory;
import com.genesis.exam.util.Randomizer;

public class EmployeeFresher extends Employee implements Runnable {
	
	private Call call;
	
	public EmployeeFresher(Call call) {
		this.call=call;
	}
	
	public EmployeeFresher() {
	}

    public void run() {
		//lets process it
    	takeCall();
    }

	@Override
	public void takeCall() {
		if (Randomizer.generateRandomBoolean()) {
			//random if it will escalate to TL then lets set the EscalateType to UNRESOLVEDd because we simulate that the fresher can't handle it
			Employee employeeTL = EmployeeFactory.getEmployee("TL");
			call.setEscalationType(EscalateType.UNRESOLVED.toString());
			
			try {
				employeeTL.blockingQueue.put(call);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			employeeTL.takeCall();
			System.out.println("Fresher escalate it to TL");
		}else{
			//TODO: put here what should the fresher should do and we assume that fresher handles it well and finish it
			call.setIsDone(Boolean.TRUE);
			System.out.println("Fresher handles and finish the call :)");
		}	
	}
}