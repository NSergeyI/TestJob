package com.test2;

import java.util.HashMap;
import java.util.Map;

public class Counter {
	private char[] input;
	private Map<Character, Integer> output = new HashMap<>();

	public Counter(char[] input) {
		this.input = input;
	}

	public void run() {
		count();
		System.out.println(this);
	}

	private void count() {
		for (char c : input) {
			if (Character.isLowerCase(c)) {
				add(c);
			} else {
				reduce(Character.toLowerCase(c));
			}
		}
	}

	private void add(char addChar) {
		if (checkConteins(addChar)) {
			output.put(addChar, output.get(addChar) + 1);
		} else {
			output.put(addChar, 1);
		}
	}

	private void reduce(char reduceChar) {
		if (checkConteins(reduceChar)) {
			output.put(reduceChar, output.get(reduceChar) - 1);
		} else {
			output.put(reduceChar, -1);
		}
	}

	private boolean checkConteins(char c) {
		if (output.containsKey(c)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder();
		for (Map.Entry<Character, Integer> entery : output.entrySet()) {
			result.append(entery.getKey()).append(":").append(entery.getValue()).append(" ");
		}
		return result.toString();
	}
}
