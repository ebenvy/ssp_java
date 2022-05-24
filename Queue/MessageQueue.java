package com.lgcns.test;

import java.util.HashMap;

public class MessageQueue {
	private HashMap<String, CustomQueue> queueList;
	public MessageQueue() {
		queueList = new HashMap<String, CustomQueue>();
	}
	public boolean createQueue(String queueName, int size) {
		if( queueList.containsKey(queueName)) {
			return false;
		}
		queueList.put(queueName, new CustomQueue(queueName, size));
		return true;
	}
	public boolean enqueue(String queueName, String value) {
		if (queueList.get(queueName).isFull()) {
			return false;
		}
		queueList.get(queueName).add(value);
		return true;
		
	}
	public Element dequeue(String queueName) {
		return queueList.get(queueName).dequeue();
	}
	public void changeStatus(String queueName, String uid, boolean used) {
		queueList.get(queueName).findElement(uid).setUsed(used);
	}
	public void remove(String queueName,String uid) {
		queueList.get(queueName).remove(uid);
	}
	

}
