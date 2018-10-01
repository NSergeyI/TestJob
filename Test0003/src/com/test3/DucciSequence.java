package com.test3;

		import java.util.ArrayList;

public class DucciSequence {
	private ArrayList<Integer> input;
	private ArrayList<ArrayList<Integer>> journal = new ArrayList<>();
	int steps = 0;

	public DucciSequence(ArrayList<Integer> input) {
		this.input = input;
	}

	public void run(){
		System.out.println(this);
		recursion();
		System.out.println("Steps: "+steps);
	}

	public void recursion(){
		steps++;
		journal.add(input);
		for (int i = 0; i < input.size(); i++) {
			if (input.get(i) != 0) {
				changeSequence();
				System.out.println(this);
				if (checkLoop()) {
					System.out.println("LOOP");
					break;
				}
				recursion();
				break;
			}
		}
	}

	public void changeSequence(){
		ArrayList<Integer> output = new ArrayList<>();
		for (int i=0;i<input.size()-1;i++) {
			output.add(Math.abs(input.get(i)-input.get(i+1)));
		}
		output.add(Math.abs(input.get(0)-input.get(input.size()-1)));
		input = output;
	}

	private boolean checkLoop() {
		boolean result = false;
		for(int i=0;i<journal.size();i++) {
			if (journal.get(i).equals(input)) {
				return true;
			} 
		}
		return result;
	}

	@Override
	public String toString() {
		StringBuilder tempory = new StringBuilder("(");
		input.forEach(num ->tempory.append(num).append(", "));
		tempory.delete(tempory.length()-2,tempory.length()).append(")");
		return tempory.toString();
	}
}
