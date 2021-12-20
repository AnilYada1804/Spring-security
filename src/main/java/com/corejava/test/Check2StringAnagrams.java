package com.corejava.test;

/**
 * @author ypoint
 *
 */
public class Check2StringAnagrams {

	public static void main(String[] args) {
		checkIfAnagram("abcba", "abcbb");
	}

	public static void checkIfAnagram(String str1, String str2) {
		boolean anagram = true;
		for (char c : str1.toCharArray()) {
			if (str2.contains(String.valueOf(c))) {
				anagram = false;
			}
		}
		if (anagram == true) {
			System.out.println("Strings are not Anagrams");
		}
	}
}
