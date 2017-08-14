package com.genesis.exam.processor.impl;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import com.genesis.exam.model.Call;

public abstract class Employee {
	public BlockingQueue<Call> blockingQueue = new ArrayBlockingQueue<>(20);	
	public abstract void takeCall();
}
