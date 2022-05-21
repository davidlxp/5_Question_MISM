package problems;

import java.util.Scanner;
import java.util.HashMap;

public class Main {
	
	public static void main(String[] args) 
	{
		Scanner scanner = new Scanner(System.in);
		
		// run the program
		runProgram(scanner);

		scanner.close();
	}
	
	// The menu driven main program
	public static void runProgram(Scanner scanner)
	{
		System.out.println("Welcome!" + "\n" + "Below is a demonstration of my solutions to 5 MISM questions.");
		
		int choice = mainMenu(scanner);
		while (choice != 6) 
		{
			switch (choice) {
				case 1:
					Solutions.printPrime();
					break;
				case 2:
					sortUserInt(scanner);
					break;
				case 3:
					detectPrimeNumber(scanner);
					break;
				case 4:
					checkPalindrome(scanner);
					break;
				case 5:
					findWordInTextFile(scanner);
					break;
				default:
					System.out.println("Selection invalid, please choose from index provided in menu!");
					break;
			}
			choice = mainMenu(scanner);
		}
		
		System.out.println("\nGoodbye!");

	}
	
	
	// The menu of the program
	public static int mainMenu(Scanner scanner)
	{
		int choice = 0;
		
		System.out.println("\nMain Menu:" + "\n"
				+ "1. Print first 100 prime numbers" + "\n"
				+ "2. Print integers in sorted order" + "\n"
				+ "3. Check if a number is prime" + "\n"
				+ "4. Check if a string is palindrome" + "\n"
				+ "5. Search word in text file" + "\n"
				+ "6. Exit the program");
		System.out.print("Please make a selection by index: ");
		
		// Take user input
		String input = scanner.nextLine();
		input = input.replace(" ", "");
		choice = Integer.parseInt(input);
		
		return choice;
	}
	
	// Menu Function asks user to type an integer and check whether it's a prime number
	public static void detectPrimeNumber(Scanner scanner)
	{
		
		System.out.print("\nPlease provide a number to check if it's prime: ");
		
		// use scanner to read content from user
		String str = scanner.nextLine();
		str = str.replace(" ", "");
		int x = Integer.parseInt(str);
		
		if (Solutions.isPrime(x))
			System.out.println("Yes, " + x + " is a prime number!");
		else
			System.out.println("No, " + x +" is not a prime number!");
	}
	
	// Helper Function for printing an array
	public static <T> void printArray(final T[] arr)
	{
		for (int i=0; i<arr.length; ++i)
		{
			System.out.print(arr[i]);
			if (i < arr.length-1)
				System.out.print(", ");
		}
		System.out.println();
	}
	
	// Menu Function take integers from user and sort them
	public static void sortUserInt(Scanner scanner)
	{
		// read user input
		System.out.print("\nPlease provide your integers delaminated by comma (eg. 1, 4, 5): ");
		
		String str = scanner.nextLine();

		// parse all integers from user input and store them
		str = str.replace(" ","");
		String[] splitArr = str.split(",");
		int[] inputNums = new int[splitArr.length];
		for (int i=0; i<splitArr.length; ++i)
			inputNums[i] = Integer.parseInt(splitArr[i]);
		
		// Sort the input number
		Solutions.mergeSort(inputNums, 0, inputNums.length-1);
		
		// print result
		Integer[] list = new Integer[inputNums.length];
		for (int i=0; i<inputNums.length; ++i)
			list[i] = inputNums[i];
		System.out.print("Sorted result is: ");
		printArray(list);
	}
	
	// Menu function checks if a string is palindrome or not
	public static void checkPalindrome(Scanner scanner)
	{
		System.out.print("\nPlease provide a string to check if it's a palindrome: ");
		
		String input = scanner.nextLine();
		
		// clean the input string
		input = input.replace(" ", "");
		input = input.toLowerCase();
		
		if (Solutions.isPalindrome(input))
			System.out.println("Yes, it's a palindrome");
		else
			System.out.println("No, it's not a palindrome");
	}
	
	// Menu Function checks if word in a text file and return number of occurrences
	public static void findWordInTextFile(Scanner scanner)
	{
		System.out.print("\nPlease provide the text file name (eg. sample.txt): ");
		String fileAddress = scanner.nextLine();
		System.out.print("Please provide the word you want to search: ");
		String word = scanner.nextLine();
		
		// remove extra spaces in Strings
		fileAddress = fileAddress.replace(" ", "");
		fileAddress = fileAddress.toLowerCase();
		word = word.replace(" ", "");
		word = word.toLowerCase();
		
		// dynamically get the directory
		String dir = System.getProperty("user.dir");
		String subDir = "/src/problems";
		fileAddress = dir + subDir + "/" + fileAddress;
		
		// parse all words from the text file provided 
		String text = Solutions.readTextFile(fileAddress);
		HashMap<String,Integer> map = Solutions.extractWords(text);
		
		// check if the word in the text file and get the counts
		Integer count = map.get(word);
		if (count != null)
			System.out.println("Word '" + word + "' appeared " + count + " times in the text file.");
		else
			System.out.println("Word '" + word + "' is not in the text file.");
	}
	
	
}
