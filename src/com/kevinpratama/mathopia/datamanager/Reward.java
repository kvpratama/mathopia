package com.kevinpratama.mathopia.datamanager;

public class Reward {

	private int id;
	private String name;
	private int status;

	public Reward(int id, int status) {
		super();
		this.id = id;
		this.status = status;
	}
	
	public Reward(String name, int status) {
		super();
		this.name = name;
		this.status = status;
	}

	public Reward(int id, String name, int status) {
		super();
		this.id = id;
		this.name = name;
		this.status = status;
	}

	public Reward() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	

}
