package com.capgemini.taxi;

public class User {
	Position pos;

	public User(Position pos) {
		this.pos = pos;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}
}
