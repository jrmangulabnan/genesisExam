package com.genesis.exam.util;

import com.genesis.exam.processor.EmployeeFresher;
import com.genesis.exam.processor.EmployeePM;
import com.genesis.exam.processor.EmployeeTL;
import com.genesis.exam.processor.impl.Employee;

public class EmployeeFactory {
	   public static Employee getEmployee(String employeeType){
	      if(employeeType == null){
	         return null;
	      }		
	      if(employeeType.equalsIgnoreCase("FRESHER")){
	         return new EmployeeFresher();
	         
	      } else if(employeeType.equalsIgnoreCase("TL")){
	         return EmployeeTL.getInstance();
	         
	      } else if(employeeType.equalsIgnoreCase("PM")){
	         return EmployeePM.getInstance();
	      }	      
	      return null;
	   }
	}