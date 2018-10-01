package com.test1;

public class Dice {

	private int roll;
	private int numDice;
	private int sum;

	public Dice(int roll, int numDice) {
		this.roll = roll;
		this.numDice = numDice;
	}

	public int output() {
		for (int i = 0; i < roll; i++) {
			sum = sum + 1 + (int) (Math.random() * numDice);
		}
		return sum;
	}
}
