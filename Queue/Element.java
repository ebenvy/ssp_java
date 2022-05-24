package com.lgcns.test;

public class Element {
	private String value;
	private Boolean used;
	private String uid;
	public Element(String value, Boolean used, String uid) {
		this.value= value;
		this.used =used;
		this.uid =uid;
	}
	public boolean getUsed() {
		return this.used;
	}
	public String getValue() {
		return this.value;
	}
	public String getUid() {
		return this.uid;
	}
	public void setUsed(boolean used) {
		this.used =used;
	}
	public void setValue(String value) {
		this.value =value;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}

}
