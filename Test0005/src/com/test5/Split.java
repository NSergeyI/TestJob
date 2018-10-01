package com.test5;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class Split {

	public static void main(String[] args) throws IOException {


		ArrayList<String> source = new ArrayList<>();
		Files.lines(Paths.get("C:\\Users\\Tom\\Documents\\TestJob\\Test0005\\src\\com\\test5\\source\\enable1.txt"), StandardCharsets.UTF_8).forEach(source::add);
		String maskFile = "C:\\Users\\Tom\\Documents\\TestJob\\Test0005\\src\\com\\source\\test5\\";
		for(int i=0;i<source.size();i++) {
			Files.write(Paths.get(maskFile+source.get(i).length()+".txt"), 
					(source.get(i)+System.lineSeparator()).getBytes(),
					StandardOpenOption.CREATE,
					StandardOpenOption.APPEND);
			System.out.println(i);
		}
	}
}
