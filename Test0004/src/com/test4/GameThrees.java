package com.test4;

public class GameThrees {
	private int num;

	public GameThrees(int num) {
		this.num = num;
	}

	public void go() {
		if (num!=1) {
			devThree();
			go();
		} else {
			System.out.println(num);
		}
		

	}
	
	private void devThree() {
		switch (num % 3) {
		case 0:
			System.out.println(num + " 0");
			num = num / 3;
			break;
		case 1:
			System.out.println(num + " -1");
			num = (num - 1) / 3;
			break;
		case 2:
			System.out.println(num + " +1");
			num = (num + 1) / 3;
			break;
		}
	}
}
