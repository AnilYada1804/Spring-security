package com.corejava.test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class JavaNumberExample {

	public static void main(String[] args) {
//		reverseANumber();
//		findSmallestLargestNuber();
//		missingNumber();
//		bubbleSort();
//		nagtiveNumbersFirst();
//		test();
//		removeDuplicates();
		removeDuplicateObjects();
		sortArray1();
	}

	private static void removeDuplicateObjects() {
		List<Employee> employee = Arrays.asList(new Employee(1, "John"), new Employee(1, "Bob"),new Employee(2, "Alice"), new Employee(2, "Alice"));
		Set<String> set = new HashSet<>();
		List<Employee> newList = employee.stream().filter(emp -> set.add(emp.getName()) && set.add(String.valueOf(emp.getId()))).collect(Collectors.toList());
		System.out.println("removeDuplicateObjects: "+newList);
		
	}

	private static void removeDuplicates() {
		Integer in[] = { 1, 3, 4, 2, 4, 1 };
		int array[] = { 1, 3, 4, 2, 4, 1 };
		int newA[] = IntStream.of(array).distinct().toArray();
		System.out.println("removed duplicates:1 " + Arrays.toString(newA));
		List<Integer> removedDuplicateNumbers = Arrays.asList(in).stream().distinct().collect(Collectors.toList());
		System.out.println("removed duplicates:2 " + removedDuplicateNumbers);

		int newArray[] = sortArray(array);
		System.out.println("sortedNumbers: " + Arrays.toString(newArray));
		removeDuplicates(newArray);
	}

	private static void removeDuplicates(int[] newArray) {
		int tempArray[] = new int[newArray.length];
		int j = 0;
		for (int i = 0; i < newArray.length - 1; i++) {
			if (newArray[i] != newArray[i + 1]) {
				tempArray[j++] = newArray[i];
			}
		}
		tempArray[j++] = newArray[newArray.length - 1];
		newArray = new int[j];
		for (int i = 0; i < j; i++) {
			newArray[i] = tempArray[i];
		}
		System.out.println("removed duplicates: " + Arrays.toString(newArray));
	}

	private static int[] sortArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int temp = 0;
			for (int j = i + 1; j < array.length; j++) {
				if (array[i] > array[j]) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		return array;
	}
	
	private static void sortArray1() {
		int array[] = {3,6,1,2,0};
		for(int i=0; i<array.length-1; i++) {
			int temp =0;
			for(int j =0; j<array.length-1; j++) {
				if(array[j] >array[j+1]) {
					temp= array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
		System.out.println("sort Array: "+Arrays.toString(array));
		for(int i=0; i<array.length; i++) {
			int temp =0;
			for(int j=0; j<array.length; j++) {
				if(array[j] >array[j+1]) {
					temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
				}
			}
		}
	}

	private static void test() {
		int reminder = 123 % 10;
		int divider = 123 / 10;
		System.out.println("reminder: " + reminder);
		System.out.println("divider: " + divider);
	}

	private static void nagtiveNumbersFirst() {
		int array[] = { 1, 4, -2, -8 };
		int j = 0, temp;
		for (int i = 0; i < array.length; i++) {
			if (array[i] < 0) {
				if (i != j) {
					temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
				j++;
			}
		}
		System.out.println("nagtiveNumbersFirst: " + Arrays.toString(array));
	}

	private static void bubbleSort() {
		int arr[] = { 2, 5, 4, 1 };
		int len = arr.length;
		for (int i = 0; i < len - 1; i++) {
			for (int j = 0; j < len - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		System.out.println("----bubbleSort------");
		for (int num : arr) {
			System.out.print(num + " ");
		}
		System.out.println();
		System.out.println("----bubbleSort-------");
	}

	private static void missingNumber() {
		int arr[] = { 1, 3, 4 };
		int n = arr.length + 1; // 4
		int sum = n * (n + 1) / 2;
		int restSum = 0;
		for (int i = 0; i < arr.length; i++) {
			restSum += arr[i];
		}
		int missingNumber = sum - restSum;
		System.out.println(missingNumber);
	}

	private static void findSmallestLargestNuber() {
		int arr[] = { 120, 56, 76, 89, 100, 343, 21, 234 };
		int smallest = arr[0];
		int largest = arr[0];
		for (int num : arr) {
			if (num > largest) {
				largest = num;
			} else if (smallest > num) {
				smallest = num;
			}
		}
		System.out.println("smallest: " + smallest);
		System.out.println("largest: " + largest);
	}

	public static void reverseANumber() {
		Integer num = 1234567890;
		int reverse = 0;
		while (num != 0) {
			int remainder = num % 10;
			reverse = reverse * 10 + remainder;
			num = num / 10;
		}
		System.out.println("reverse: " + reverse);
	}
}

class Employee {
	int id;
	String name;

	public Employee() {
	}

	public Employee(int i, String string) {
		this.id=i;
		this.name=string;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}

}