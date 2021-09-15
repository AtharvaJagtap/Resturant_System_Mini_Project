package com.Bean;

public class RS_Database {
	private int Id, phone_no;
	private String name, address, optime, cltime;
	private String cusine;

	public RS_Database() {
	}

	public RS_Database(int id, int phone_no, String name, String address, String optime, String cltime, String cusine) {
		super();
		this.Id = id;
		this.phone_no = phone_no;
		this.name = name;
		this.address = address;
		this.optime = optime;
		this.cltime = cltime;
		this.cusine = cusine;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public int getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(int phone_no) {
		this.phone_no = phone_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOptime() {
		return optime;
	}

	public void setOptime(String optime) {
		this.optime = optime;
	}

	public String getCltime() {
		return cltime;
	}

	public void setCltime(String cltime) {
		this.cltime = cltime;
	}

	public String getCusine() {
		return cusine;
	}

	public void setCusine(String cusine) {
		this.cusine = cusine;
	}

}
