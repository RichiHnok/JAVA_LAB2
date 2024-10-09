package com.laba2.entity;

public class Gem {
	
	private String gemId;
	private String name;
	private String origin;
	private String preciousness; //TODO попробовать здесь enum сделать
	private String color;
	private int transparency;
	private String cut; //TODO попробовать здесь enum сделать
	private double value;

	public Gem(){

	}

	public String getGemId() {
		return gemId;
	}

	public String getName() {
		return name;
	}

	public String getOrigin() {
		return origin;
	}

	public String getPreciousness() {
		return preciousness;
	}

	public String getColor() {
		return color;
	}

	public int getTransparency() {
		return transparency;
	}

	public String getCut() {
		return cut;
	}

	public double getValue() {
		return value;
	}

	public void setGemId(String gemId) {
		this.gemId = gemId;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public void setPreciousness(String preciousness) {
		this.preciousness = preciousness;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setTransparency(int transparency) {
		this.transparency = transparency;
	}

	public void setCut(String cut) {
		this.cut = cut;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Gem [gemId=" + gemId + ", name=" + name + ", origin=" + origin + ", preciousness=" + preciousness
				+ ", color=" + color + ", transparency=" + transparency + ", cut=" + cut + ", value=" + value + "]";
	}
}
