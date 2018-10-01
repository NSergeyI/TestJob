package com.test1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Run {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split("d");
		Dice dice = new Dice(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
		System.out.println(dice.output());
		reader.close();
	}

}
