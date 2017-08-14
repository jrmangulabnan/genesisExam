package com.genesis.exam;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.genesis.exam.enums.EscalateType;
import com.genesis.exam.model.Call;
import com.genesis.exam.processor.Employee;
import com.genesis.exam.processor.impl.EmployeeFresher;
import com.genesis.exam.util.EmployeeFactory;

public class Main {
	
	final int FRESHER_SIZE = 5;  
	final int MAX_POOL_SIZE = 5;  
	
	//lets have 20 callers
	final int NUMBER_OF_CALLERS = 20;
	
	//create threadPool for fresher
	ThreadPoolExecutor fresherPool = new ThreadPoolExecutor(FRESHER_SIZE, MAX_POOL_SIZE, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>()); //we have 5 fresher
	
    public void startCallCenter() throws InterruptedException{
    	
        for (int i = 0; i < NUMBER_OF_CALLERS; i++) {
        	Call call = new Call();
            Runnable threadFresher = new EmployeeFresher(call);
            if (fresherPool.getActiveCount() <= FRESHER_SIZE) {
            	fresherPool.execute(threadFresher);
			}else{
				call.setEscalationType(EscalateType.FULLL.toString());
				
				//check if TL is not busy
				Employee employeeTL = EmployeeFactory.getEmployee("TL");
				if (!employeeTL.blockingQueue.isEmpty()) {
					//escalate to PM because TL is busy.
					Employee employeePM = EmployeeFactory.getEmployee("PM");
					employeePM.blockingQueue.put(call);
					employeePM.takeCall();
				}
				
				//give the call to TL
					employeeTL.blockingQueue.put(call);
					employeeTL.takeCall();
			}
        }
        fresherPool.shutdown();
    }
    
    public static void main(String[] args) throws InterruptedException{
    	Main main = new Main();    	
    	main.startCallCenter();
    }
}