package com.corejava.test;

import java.util.HashMap;
import java.util.Map;

public class VanEckSequence {
	public static void main(String[] args) {
		System.out.println("Van Eck Sequence upto 100: " + vanEckSequence(10));
		System.out.println();
//		vanSeq();
	}

	public static String vanEckSequence(int range) {
		int distance = 0;
		int nextNumber = 0;
		String sequence = "";
		Map<Integer, Integer> numberMap = new HashMap<>();
		for (int i = 0; i < range; i++) {
			if (numberMap.containsKey(nextNumber)) {
				distance = i - numberMap.get(nextNumber);
			} else {
				distance = 0;
			}
			numberMap.put(nextNumber, i);
			sequence += nextNumber + ", ";
			nextNumber = distance;
		}
		return sequence;
	}
	
	private static void vanSeq() {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int range =10;
		int nextNum =0;
		int dist =0;
		String seq ="";
		for(int i=0; i<range; i++) {
			if(map.containsKey(nextNum)) {
				dist = i- map.get(nextNum);
			}else {
				dist = 0;
			}
			map.put(nextNum, i);
			seq += nextNum +",";
			nextNum = dist;
		}
		System.out.println(seq);
	}
}
