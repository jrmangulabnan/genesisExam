package com.genesis.exam.processor.impl;

import com.genesis.exam.model.Call;
import com.genesis.exam.processor.Employee;
import com.genesis.exam.util.Randomizer;

public class EmployeePM extends Employee{
	private static EmployeePM instance = null;

	private EmployeePM() {
	}

	public static EmployeePM getInstance() {
		if (instance == null) {
			instance = new EmployeePM();
		}
		return instance;
	}

	@Override
	public void takeCall() {
		while (!blockingQueue.isEmpty()) {
			try {
				// let's process it
				Call call = blockingQueue.take();
				
				if (Randomizer.generateRandomBoolean()) {
					//what if PM can't resolve it? so should we just save all the issue and process it in future like save it in 
					System.out.println("PM can't fix the caller's problem :(");
				}else{					
					System.out.println("PM handles and finish the call :)");
					call.setIsDone(Boolean.TRUE);
					//TODO: do whatever we need to call but for now lets assume that the PM already take care of it so we will
				}
				
				
				
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}		
	}
}
