package problems;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.HashMap;

public class Solutions {

	// Function detects whether a given number is prime or not
	// Input: Number for detection
	// Output: True if the number is prime. Otherwise, return false
	public static boolean isPrime(int num)
	{
		if (num <= 1)
			return false;
		
		for (int i=2; i<=Math.sqrt(num); ++i)
		{
			if (num % i == 0)
				return false;
		}
		
		return true;
	}
	
	// Function prints the first 100 prime numbers
	public static void printPrime()
	{
		int count = 0;
		int num = 2;
		while (count < 100)
		{
			if (isPrime(num))
			{
				System.out.println(num);
				count++;
			}
			num++;
		}
	}
	
	// Function that implement mergeSort on an array
	public static void mergeSort(int[] arr, int first, int last)
	{
		// when first == last, it will be returned for merging
		if (first < last)
		{
			int middle = first + (last - first) / 2;
			mergeSort(arr, first, middle);
			mergeSort(arr, middle+1, last);
			merge(arr, first, middle, middle+1, last);
		}
	}
	
	private static void merge(int[] arr, int firstLeft, int lastLeft, int firstRight, int lastRight)
	{
		int temp[] = new int[arr.length];		// temp array for storing sorted items
		int walker = firstLeft;
		int save = firstLeft;
		
		// compare two arrays and add the smaller element to temp array
		while (firstLeft <= lastLeft && firstRight <= lastRight)
		{
			if (arr[firstLeft] < arr[firstRight])
				temp[walker++] = arr[firstLeft++];
			else
				temp[walker++] = arr[firstRight++];
		}
		
		// appending the remaining elements
		while (firstLeft <= lastLeft)
			temp[walker++] = arr[firstLeft++];
		
		while (firstRight <= lastRight)
			temp[walker++] = arr[firstRight++];
		
		// transfer the sorted content to the original array
		for (int i=save; i<=lastRight; ++i)
			arr[i] = temp[i];
	}
	
	// Function for checking if a String is palindrome
	public static boolean isPalindrome(String text)
	{
		int first = 0;
		int last = text.length()-1;
		
		while (first <= last)
		{
			if (text.charAt(first) != text.charAt(last))
				return false;
			first++;
			last--;		
		}
		
		return true;
	}
	
	// Function reads content from a text file into string
	public static String readTextFile(String fileAddress)
	{
		try {
			File file = new File(fileAddress);
			Scanner scanner = new Scanner(file);
			
			// read the file
			String text = "";
			while (scanner.hasNextLine())
			{
				text += " ";
				text += scanner.nextLine();
			}
			
			scanner.close();
			
			return text;
			
		} catch (FileNotFoundException e){
			System.out.println("Unable to read the file");
			e.printStackTrace();
		}
		
		return "";
	}

	// Function extract words from a string
	public static HashMap<String, Integer> extractWords(String text)
	{
		// Hashmap for storing the parsed words and their count
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		// Array of string to be removed from text
		String[] signRemove = {",", ".", "!", "?", ";", ":", "\"", " '", "' "};
		
		// clean the input text
		String cleanText = text;
		
		for (String s : signRemove)						// removing signs
			cleanText = cleanText.replace(s, " ");
		
		cleanText = cleanText.toLowerCase();			// turning lower case for all chars in string
		
		String[] splitText = cleanText.split(" ");		// split the cleaned text
		
		for (String w : splitText)						// adding words into the hash map
		{
			if (!w.isEmpty())
			{
				if (!map.containsKey(w))
					map.put(w,1);
				else
					map.put(w, map.get(w) + 1);
			}
		}
		
		return map;
	}
}








