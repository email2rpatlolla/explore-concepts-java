package com.practices.pojo;

public class Player {
	
	public Player(String name, int jerseyNumber, int rank, float maxDistance) {
		this.name = name;
		this.jerseyNumber = jerseyNumber;
		this.rank = rank;
		this.maxDistance = maxDistance;
	}
	
	private String name;
	private int jerseyNumber;
	private int rank;
	private float maxDistance;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getJerseyNumber() {
		return jerseyNumber;
	}
	public void setJerseyNumber(int jerseyNumber) {
		this.jerseyNumber = jerseyNumber;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public float getMaxDistance() {
		return maxDistance;
	}
	public void setMaxDistance(float maxDistance) {
		this.maxDistance = maxDistance;
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", jerseyNumber=" + jerseyNumber + ", rank=" + rank + ", maxDistance="
				+ maxDistance + "]";
	}
}
