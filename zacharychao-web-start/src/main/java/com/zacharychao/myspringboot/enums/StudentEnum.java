package com.zacharychao.myspringboot.enums;

public enum StudentEnum {
	ONE("a","asd");
	private String retnumber;
	private String retname;
	public String getRetnumber() {
		return retnumber;
	}
	public void setRetnumber(String retnumber) {
		this.retnumber = retnumber;
	}
	public String getRetname() {
		return retname;
	}
	public void setRetname(String retname) {
		this.retname = retname;
	}
	private StudentEnum(String retnumber, String retname) {
		this.retnumber = retnumber;
		this.retname = retname;
	}
	
	public static String getName(String name) {
		StudentEnum[] values = StudentEnum.values();
		for(StudentEnum enumi : values) {
			if(enumi.getRetnumber().equals(name)) {
				return enumi.getRetname();
			}
		}
		return null;
	}
}
