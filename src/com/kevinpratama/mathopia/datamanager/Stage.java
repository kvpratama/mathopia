package com.kevinpratama.mathopia.datamanager;

public class Stage {
	private int id;
	private int score;
	private int turtleSaved;
	private int status;

	
	
	public Stage() {
		super();
	}

	public Stage(int score, int turtleSaved, int status) {
		super();
		this.score = score;
		this.turtleSaved = turtleSaved;
		this.status = status;
	}

	public Stage(int id, int score, int turtleSaved, int status) {
		super();
		this.id = id;
		this.score = score;
		this.turtleSaved = turtleSaved;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getTurtleSaved() {
		return turtleSaved;
	}

	public void setTurtleSaved(int turtleSaved) {
		this.turtleSaved = turtleSaved;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
