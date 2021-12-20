package com.corejava.test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StringTestExamples {
	public static void main(String[] args) {
//		reverseANumber();
//		reverseAstring();
//		System.out.print(reverseAStringRecursive("hel"));
//		findTotalNumbersOfCharacters();
//		findTotalNumbersOfWords();
//		findDuplicateString();
//		findStingHasUniqueCharacter();
//		isAnagram("keeP", "peeK");
//		isRotation("java2blog", "blogjava2");
//		printPermutn("abc", "");
//		findDuplicatewords();
//		longestUniqueSubsttr("anilyada");
//		getUniqueCharacterSubstring("anilyada");
//		removeDuplicateString("anilyadatest");
		testStringEquality();
//		reverseALinkedList();
		
	}
	

	private static void reverseALinkedList() {
		
	}


	private static String reverseAStringRecursive(String str) {
		System.out.println("test: "+str.length()+" - "+str);
		if(str.length() < 2) {
			return str;
		}
		return reverseAStringRecursive(str.substring(1))+str.charAt(0);
	}

	private static void testStringEquality() {
		String str1 = "Anil";
		String str2 = "Anil";
		String str3 = new String("Anil");
		String str4 = new String("Anil");
		System.out.println(str1 == str2+" = 1-false");
		System.out.println(str1.equals(str2)+" =2-true"); 
		System.out.println(str1 == str3+" =3-false"); 
		System.out.println(str3 == str4+" =4-false"); 
		System.out.println(str1.equals(str3)+" =5-true"); 
		System.out.println(str3.equals(str4)+" true");
	}

	private static void removeDuplicateString(String string) {
		//Java8
		String test = Arrays.asList(string.split("")).stream().distinct().collect(Collectors.joining());
		System.out.println("removed duplicate characters from string:1 "+test);
		
		char ch[] = string.toCharArray();
		String temp = new String();
		for(char c: ch) {
			if(temp.indexOf(c) <0) {
				temp +=c;
			}
		}
		System.out.println("removed duplicate characters from string:2 "+temp);
	}

	static void reverse(String str) {
		if ((str == null) || (str.length() <= 1))
			System.out.println(str);
		else {
			System.out.print(str.charAt(str.length() - 1));
			reverse(str.substring(0, str.length() - 1));
		}
	}

	static String getUniqueCharacterSubstring(String input) {
		Map<Character, Integer> visited = new HashMap<>();
		String output = "";
		for (int start = 0, end = 0; end < input.length(); end++) {
			char currChar = input.charAt(end);
			if (visited.containsKey(currChar)) {
				start = Math.max(visited.get(currChar) + 1, start);
			}
			if (output.length() < end - start + 1) {
				output = input.substring(start, end + 1);
			}
			visited.put(currChar, end);
		}
		System.out.println("output: " + output);
		return output;
	}

	static int longestUniqueSubsttr(String s) {

		// Creating a set to store the last positions of occurrence
		HashMap<Character, Integer> seen = new HashMap<>();
		int maximum_length = 0;

		// starting the inital point of window to index 0
		int start = 0;

		for (int end = 0; end < s.length(); end++) {
			// Checking if we have already seen the element or not
			if (seen.containsKey(s.charAt(end))) {
				// If we have seen the number, move the start pointer
				// to position after the last occurrence
				start = Math.max(start, seen.get(s.charAt(end)) + 1);
			}

			// Updating the last seen value of the character
			seen.put(s.charAt(end), end);
			maximum_length = Math.max(maximum_length, end - start + 1);
		}
		System.out.println(maximum_length);
		return maximum_length;
	}

	private static void findDuplicatewords() {
		String string = "ab ca ab ba ab xy zx yz xy";
		String str[] = string.split("\\s");
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < str.length; i++) {
			for (int j = 0; j < str.length; j++) {
				if (i != j && str[i].equals(str[j])) {
					set.add(str[i]);
				}
			}
		}
		System.out.println();
		System.out.println("Duplicates: " + set);

	}

	private static void printPermutn(String str, String ans) {

		// If string is empty
		if (str.length() == 0) {
			System.out.print(ans + " ");
			return;
		}

		for (int i = 0; i < str.length(); i++) {

			// ith character of str
			char ch = str.charAt(i);

			// Rest of the string after excluding
			// the ith character
			String ros = str.substring(0, i) + str.substring(i + 1);

			// Recurvise call
			printPermutn(ros, ans + ch);
		}
	}

	public static boolean isRotation(String str, String rotation) {
		String str2 = str + str;

		if (str2.contains(rotation)) {
			return true;
		}
		return false;

	}

	static void isAnagram(String s1, String s2) {
		// Removing white spaces from s1 and s2 and converting case to lower case
		s1 = "ram";
		s2= "raam";
		String copyOfs1 = s1.replaceAll("\\s", "").toLowerCase();
		String copyOfs2 = s2.replaceAll("\\s", "").toLowerCase();
		boolean flag = true;
		for (char c : copyOfs1.toCharArray()) {
			int index = copyOfs2.indexOf(c);
			if (index != -1) {
				copyOfs2 = copyOfs2.substring(0, index) + copyOfs2.substring(index + 1, copyOfs2.length());
			} else {
				flag = false;
				break;
			}
		}
		System.out.println("------------------------------------");
		if (flag) {
			System.out.println(s1 + " and " + s2 + " are anagrams");
		} else {
			System.out.println(s1 + " and " + s2 + " are not anagrams");
		}

		char chArray1[] = "keeP".toLowerCase().toCharArray();
		char chArray2[] = "peeK".toLowerCase().toCharArray();
		Arrays.sort(chArray1);
		Arrays.sort(chArray2);

		if (Arrays.equals(chArray1, chArray2)) {
			System.out.println("string are anagram");
		} else {
			System.out.println("string are not anagarm");
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	private static void findStingHasUniqueCharacter() {
		String s = "hello";
		boolean flag = true;
		char ch[] = s.toCharArray();
		for (int i = 0; i < ch.length; i++) {
			for (int j = 0; j < ch.length; j++) {
				if (i != j && ch[i] == ch[j]) {
					flag = false;
					break;
				}
			}
		}
		System.out.println("flag: " + flag);

		// hashset
		String s1 = "true";
		boolean flag1 = true;
		Set set = new HashSet<>();
		for (char c : s1.toCharArray()) {
			if (!set.add(c)) {
				flag1 = false;
				break;
			}
		}
		System.out.println("flag1 " + flag1);

		boolean flag2 = true;
		String s3 = "neww";
		for (char c : s3.toCharArray()) {
			if (s3.indexOf(c) != s3.lastIndexOf(c)) {
				flag2 = false;
				break;
			}
		}
		System.out.println("flag2: " + flag2);

	}

	private static void findDuplicateString() {
		String s = "Hello world test";
		Map<Character, Integer> map = new HashMap<>();
		for (char ch : s.toCharArray()) {
			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}
		Set<Character> set = map.keySet();
		for (Character ch : set) {
			if (map.get(ch) > 1) {
				System.out.println(ch + " :" + map.get(ch));
			}
		}

	}

	private static void findTotalNumbersOfWords() {
		String s = "Hello world test hi";
		System.out.println("split: " + s.split(" ").length);
		String trimStr = s.trim();
		System.out.println("trimStr: " + trimStr);
		int count = trimStr.isEmpty() ? 0 : trimStr.split("\\s").length;
		System.out.println("count: " + count);
	}

	private static void findTotalNumbersOfCharacters() {
		String s = "Hello world hi";
		char ch[] = s.toCharArray();
		int count = 0;
		for (int i = 0; i < ch.length; i++) {
			if (s.charAt(i) != ' ') {
				count++;
			}
		}
		System.out.println("count: " + count);

	}

	private static void reverseAstring() {
		String str = "Hello";
		char ch[] = str.toCharArray();
		StringBuilder sb = new StringBuilder();
		for (int i = ch.length - 1; i >= 0; i--) {
			sb.append(ch[i]);
		}
		System.out.println(sb.toString());
	}

	private static void reverseANumber() {
		int num = 123, reverse = 0;
		while (num != 0) {
			int remainder = num % 10;
			reverse = reverse * 10 + remainder;
			num = num / 10;
		}
		System.out.println(reverse);
	}

}
