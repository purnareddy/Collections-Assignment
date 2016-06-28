package com.test.collections;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TestPhoneDirectory {
	private static Scanner reader;
	private static Scanner scanner = new Scanner(System.in);
	private static FileWriter f;

	public static void readDirectory(Map<String, ArrayList<Integer>> phoneDirectory) {
		
		while (reader.hasNextLine()) {
			String name = reader.next();
			int mobile = reader.nextInt();
			int home = reader.nextInt();

			ArrayList<Integer> phoneNumbers = new ArrayList<Integer>();
			phoneNumbers.add(mobile);
			phoneNumbers.add(home);

			phoneDirectory.put(name, phoneNumbers);
		}
	}

	public static void inputEntry(Map<String, ArrayList<Integer>> phoneDirectory) {

		System.out.println("Enter Name: ");
		String name = scanner.next();
		System.out.println("Enter Mobile: ");
		int mobile = scanner.nextInt();
		System.out.println("Enter Home: ");
		int home = scanner.nextInt();

		ArrayList<Integer> phoneNumbers = new ArrayList<Integer>();
		phoneNumbers.add(mobile);
		phoneNumbers.add(home);

		phoneDirectory.put(name, phoneNumbers);

	}

	public static void main(String[] args) {
		String status;
		Map<String, ArrayList<Integer>> phoneDirectory = new HashMap<String, ArrayList<Integer>>();

		try {
			reader = new Scanner(new File("C:/Users/Purna/collections/output.txt"));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		readDirectory(phoneDirectory);

		System.out.println("Do you want to enter an entry into directory?");
		if (scanner.next().equals("Yes")) {
			do {
				inputEntry(phoneDirectory);
				System.out.println("Do you want to enter another entry");
				status = scanner.next();
			} while (status.equals("Yes"));
		}

		try {
			f = new FileWriter("C:/Users/Purna/collections/output.txt");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedWriter out = new BufferedWriter(f);
		
		for (String key : phoneDirectory.keySet()) {
			
			try {
				out.append(key + " " + phoneDirectory.get(key).get(0) + " " + phoneDirectory.get(key).get(1));
				out.newLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			

		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(phoneDirectory);

	}
}
