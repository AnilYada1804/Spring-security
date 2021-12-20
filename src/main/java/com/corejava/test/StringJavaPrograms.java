package com.corejava.test;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StringJavaPrograms {
	public static void main(String[] args) {
//		reverseAString("Hello world");
//		firstNonRepeatedCharacterInString("Helloworld");
//		OptionalTest();
		findDuplicates("ab ca ab ba ab xy zx yz xy");
	}

	private static void findDuplicates(String string) {
		String str[] = string.split("\\s");
		String removedDuplicates = Stream.of(str).distinct().collect(Collectors.joining(" "));
		System.out.println("removeDuplicate: "+ removedDuplicates);
		Set<String> set = new HashSet();
		for (String str3 : str) {
			set.add(str3);
		}
		System.out.println("removed duplicates: " + set);
	}

	private static void OptionalTest() {
		String str[] = new String[5];
		str[0] = "Hello world";
		str[1] = "Test me";
		Stream.of(str).forEach(System.out::println);
		Optional<String> empty = Optional.empty();
		System.out.println("It returns an empty instance of optional class " + empty);
		Optional<String> op1 = Optional.of(str[1]); // no error
		System.out.println(
				"It returns non-empty Optional if value is present, otherwise returns an empty Optional   " + op1);
//		Optional<String> op2 = Optional.of(str[3]); //Nullpointer expection
//		System.out.println("It throws Null pointer exception: "+op2);
		Optional<String> opt3 = Optional.ofNullable(str[3]);
		System.out.println(
				"It returns non-empty Optional if value is present, otherwise returns an empty Optional  " + opt3);
	}

	public static void firstNonRepeatedCharacterInString(String string) {
		Map<Character, Integer> map = new LinkedHashMap<Character, Integer>();
		char cha[] = string.toCharArray();
		for(char ch : cha) {
			map.put(ch, map.containsKey(ch) ? map.get(ch) +1 : 1);
		}
		char key  = map.entrySet().stream().filter(x -> x.getValue() == 1).findFirst().get().getKey();
		// second
		for (Character ch : string.toCharArray()) {
			if (string.indexOf(ch) == string.lastIndexOf(ch)) {
				System.out.println("Non repetedValue: " + ch);
				break;
			}
		}
	}

	private static void reverseAString(String str) {
		// using StringBuilder
		StringBuilder sb = new StringBuilder(str);
		System.out.println("reverseAString: " + sb.reverse().toString());

		// using recursion
		System.out.println(usingRecurrsion("he"));
		System.out.println("Hello".indexOf('l'));
		System.out.println("Hello".lastIndexOf('o'));
		reverseAStringLoop(str);

		// using Java8
		String str3 = Stream.of(str).map(s -> new StringBuilder(s).reverse()).collect(Collectors.joining());
		System.out.println("reverseAString using Java8: " + str3);
	}

	private static void reverseAStringLoop(String str) {
		char ch[] = str.toCharArray();
		String str1 = "";
		for (int i = ch.length - 1; i >= 0; i--) {
			str1 = str1 + ch[i];
		}
		System.out.println(str1);
	}

	private static String usingRecurrsion(String str) {
		if (str.length() < 2) {
			return str;
		}
		return usingRecurrsion(str.substring(1)) + str.charAt(0);
	}
}
