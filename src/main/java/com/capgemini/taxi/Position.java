package com.capgemini.taxi;

public class Position {
	private double pLat;
	private double pLong;
	public Position(double la, double lo){
		pLat=la;
		pLong=lo;
	}
	@Override
	public String toString() {
		return "Position [pLat=" + pLat + ", pLong=" + pLong + "]";
	}
	public double getpLat() {
		return pLat;
	}
	public void setpLat(double pLat) {
		this.pLat = pLat;
	}
	public double getpLong() {
		return pLong;
	}
	public void setpLong(double pLong) {
		this.pLong = pLong;
	}

}
