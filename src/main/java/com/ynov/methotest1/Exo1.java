package com.ynov.methotest1;

import java.util.Collections;
import java.util.List;

class Exo1 {
	
	public static int divideInt(int a, int b) {
		return a / b;
	}
	
	public static double divideDouble(int a, int b) {
		return ((double) a) / (double) b;
	}
	
	public static List<Integer> sort(List<Integer> list, boolean asc) {
		if(asc)
			Collections.sort(list);
		else
			Collections.sort(list, Collections.reverseOrder());
		return list;
	}
}
