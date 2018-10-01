package com.test3;

import java.util.ArrayList;

public class Run {

		public static void main(String[] args) {
			String inputString = "(10, 12, 41, 62, 31)";
			ArrayList<Integer> input = new ArrayList<>();
			inputString = inputString.substring(1, inputString.length() - 1);
			String[] strings = inputString.split(", ");
			for (String s : strings) {
				input.add(Integer.parseInt(s));
			}
			DucciSequence ducciSequence = new DucciSequence(input);
			ducciSequence.run();

		}


}