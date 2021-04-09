package com.ynov.methotest1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.springframework.boot.test.context.SpringBootTest;

import static com.ynov.methotest1.Exo2.*;

@SpringBootTest
class Exo2Test {
	
	@Test
	public void checkNoDirection() {
		assertEquals(0, direction(0, 0));
		assertEquals(0, direction(MIN_STAGE, MIN_STAGE));
		assertEquals(0, direction(MAX_STAGE, MAX_STAGE));
	}
	
	@Test
	public void checkDirectionUp() {
		assertEquals(1, direction(0, 1));
		assertEquals(1, direction(MIN_STAGE, MIN_STAGE + 1));
		assertEquals(1, direction(MAX_STAGE - 1, MAX_STAGE));
	}
	
	@Test
	public void checkDirectionDown() {
		assertEquals(-1, direction(0, -1));
		assertEquals(-1, direction(MIN_STAGE + 1, MIN_STAGE));
		assertEquals(-1, direction(MAX_STAGE, MAX_STAGE - 1));
	}
	
	@Test
	public void checkDirectionWrongStage() {
		Executable currentBelowMin = new Executable() {
			@Override
			public void execute() throws Throwable {
				direction(MIN_STAGE - 1, -2);
			}
		};
		Executable currentAboveMax = new Executable() {
			@Override
			public void execute() throws Throwable {
				direction(MAX_STAGE + 1, 8);
			}
		};
		Executable currentNull = new Executable() {
			@Override
			public void execute() throws Throwable {
				direction(null, 2);
			}
		};
		Executable requestedBelowMin = new Executable() {
			@Override
			public void execute() throws Throwable {
				direction(MIN_STAGE, MIN_STAGE - 1);
			}
		};
		Executable requestedAboveMax = new Executable() {
			@Override
			public void execute() throws Throwable {
				direction(MAX_STAGE, MAX_STAGE + 1);
			}
		};
		Executable requestedNull = new Executable() {
			@Override
			public void execute() throws Throwable {
				direction(5, null);
			}
		};
		
		assertThrows(IndexOutOfBoundsException.class, currentBelowMin, "A current stage below min stage was accepted");
		assertThrows(IndexOutOfBoundsException.class, currentAboveMax, "A current stage above max stage was accepted");
		assertThrows(IndexOutOfBoundsException.class, requestedBelowMin, "A requested stage below min stage was accepted");
		assertThrows(IndexOutOfBoundsException.class, requestedAboveMax, "A requested stage above max stage was accepted");
		assertThrows(NullPointerException.class, currentNull, "A null current stage was accepted");
		assertThrows(NullPointerException.class, requestedNull, "A null requested stage was accepted");
	}
	
	@Test
	public void checkIsStopTrue() {
		List<Integer> requestedStages = IntStream.of(-1,2,2).boxed().collect(Collectors.toList());
		assertEquals(true, isStop(0, 0, new ArrayList<>()));
		assertEquals(true, isStop(-1, 0, requestedStages));
		assertEquals(true, isStop(-1, -1, requestedStages));
		assertEquals(true, isStop(2, MAX_STAGE, requestedStages));
		assertEquals(true, isStop(2, MIN_STAGE, requestedStages));
		assertEquals(true, isStop(2, 2, requestedStages));
		assertEquals(true, isStop(MAX_STAGE, MAX_STAGE, requestedStages));
		assertEquals(true, isStop(MIN_STAGE, MIN_STAGE, requestedStages));
	}
	
	@Test
	public void checkIsStopFalse() {
		List<Integer> requestedStages = IntStream.of(8,-2,8,4,7,-4).boxed().collect(Collectors.toList());
		assertEquals(false, isStop(0, -2, new ArrayList<>()));
		assertEquals(false, isStop(-3, 0, requestedStages));
		assertEquals(false, isStop(3, -1, requestedStages));
		assertEquals(false, isStop(9, MAX_STAGE, requestedStages));
		assertEquals(false, isStop(5, MIN_STAGE, requestedStages));
	}
	
	@Test
	public void checkIsStopWrongStage() {
		List<Integer> correctsStages = IntStream.of(7,-1,4,2,-3).boxed().collect(Collectors.toList());
		List<Integer> toLowStages = IntStream.of(6,-2,8,MIN_STAGE - 1,5,-1).boxed().collect(Collectors.toList());
		List<Integer> toHighStages = IntStream.of(8,-2,8,MAX_STAGE + 1,7,-4,3).boxed().collect(Collectors.toList());
		List<Integer> nullStages = IntStream.of(8,-2,8,-2,-4,3).boxed().collect(Collectors.toList());
		nullStages.add(null);
		
		Executable listBelowMin = new Executable() {
			@Override
			public void execute() throws Throwable {
				isStop(5, -2, toLowStages);
			}
		};
		Executable listAboveMax = new Executable() {
			@Override
			public void execute() throws Throwable {
				isStop(4, 8, toHighStages);
			}
		};
		Executable listContainsNull = new Executable() {
			@Override
			public void execute() throws Throwable {
				isStop(3, -1, nullStages);
			}
		};
		Executable requestedBelowMin = new Executable() {
			@Override
			public void execute() throws Throwable {
				isStop(-3, MIN_STAGE - 1, correctsStages);
			}
		};
		Executable requestedAboveMax = new Executable() {
			@Override
			public void execute() throws Throwable {
				isStop(-1, MAX_STAGE + 1, correctsStages);
			}
		};
		Executable requestedNull = new Executable() {
			@Override
			public void execute() throws Throwable {
				isStop(3, null, correctsStages);
			}
		};
		Executable currentBelowMin = new Executable() {
			@Override
			public void execute() throws Throwable {
				isStop(MIN_STAGE - 1, 5, correctsStages);
			}
		};
		Executable currentAboveMax = new Executable() {
			@Override
			public void execute() throws Throwable {
				isStop(MAX_STAGE + 1, 7, correctsStages);
			}
		};
		Executable currentNull = new Executable() {
			@Override
			public void execute() throws Throwable {
				isStop(null, 6, correctsStages);
			}
		};
		
		assertThrows(IndexOutOfBoundsException.class, listBelowMin, "A requested stage list below min stage was accepted");
		assertThrows(IndexOutOfBoundsException.class, listAboveMax, "A requested stage list above max stage was accepted");
		assertThrows(NullPointerException.class, listContainsNull, "A requested stage list with null stage was accepted");
		assertThrows(IndexOutOfBoundsException.class, currentBelowMin, "A current stage below min stage was accepted");
		assertThrows(IndexOutOfBoundsException.class, currentAboveMax, "A current stage above max stage was accepted");
		assertThrows(NullPointerException.class, currentNull, "A null current stage was accepted");
		assertThrows(IndexOutOfBoundsException.class, requestedBelowMin, "A requested stage below min stage was accepted");
		assertThrows(IndexOutOfBoundsException.class, requestedAboveMax, "A requested stage above max stage was accepted");
		assertThrows(NullPointerException.class, requestedNull, "A null requested stage  was accepted");
	}
}
