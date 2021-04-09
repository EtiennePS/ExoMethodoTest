package com.ynov.methotest1;

import java.util.List;

class Exo2 {
	
	public static final int MIN_STAGE = -4;
	public static final int MAX_STAGE = 10;
	
	public static int direction(Integer currentStage, Integer requestedStage) {
		checkValue(currentStage);
		checkValue(requestedStage);
		if(currentStage == requestedStage)
			return 0;
		else if(currentStage < requestedStage)
			return 1;
		else
			return -1;
	}
	
	public static boolean isStop(Integer currentStage, Integer requestedStage, List<Integer> requestedStages) {
		checkValue(currentStage);
		checkValue(requestedStage);
		checkValue(requestedStages);
		return currentStage == requestedStage || requestedStages.contains(currentStage);
	}
	
	private static void checkValue(Integer stage) {
		if(stage == null)
			throw new NullPointerException("There is no stage!");
		else if(stage < MIN_STAGE)
			throw new IndexOutOfBoundsException("The stage " + stage + " is below the min stage " + MIN_STAGE);
		else if(stage > MAX_STAGE)
			throw new IndexOutOfBoundsException("The stage " + stage + " is above the max stage " + MAX_STAGE);
	}
	
	private static void checkValue(List<Integer> requestedStages) {
		try {
			for(int i : requestedStages) {
				checkValue(i);
			}
		}
		catch(NullPointerException e) {
			throw new NullPointerException("One of the button is null");
		}		
	}
}
