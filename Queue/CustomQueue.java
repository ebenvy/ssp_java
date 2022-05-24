package com.lgcns.test;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

public class CustomQueue {
	private String name;
	private int size;

	private Queue<Element> queue;
	public CustomQueue(String name, int size) {
		this.name= name;
		this.size =size;
		queue = new LinkedList<Element>();
	}
	public boolean isFull() {
		if(queue.size()==this.size) {
			return true;
		}
		return false;
	}
	public void add(String value) {
		queue.add(new Element(value,true,UUID.randomUUID().toString()));
	}
	public Element dequeue() {
		if(queue.isEmpty()) {
			return null;
		}
		return getFirstElement();
	}
	public Element getFirstElement() {
		for(Element e:queue) {
			if(e.getUsed()==false) {
				continue;
			}
			e.setUsed(false);
			return e;
		}
		return null;
	}
	public Element findElement(String uid) {
		for(Element e:queue) {
			if(e.getUid().equals(uid)) {
				return e;
			}
		}
		return null;
	}
	public void changeStatus(Element e, boolean used) {
		e.setUsed(used);
	}
	public void remove(String uid) {
		queue.remove(findElement(uid));
	}

}
