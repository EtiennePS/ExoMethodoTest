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

import static com.ynov.methotest1.Exo1.*;

@SpringBootTest
class Exo1Test {

	@Test
	public void checkUpper() {
		final String maj = "STRING";
		final String min = "string";
		final String mixedMaj = "EXERCICE1";
		final String mixedMin = "eXeRciCe1";
		
		assertEquals(maj, min.toUpperCase());
		assertEquals(maj, maj.toUpperCase());
		assertEquals(mixedMaj, mixedMin.toUpperCase());
	}
	
	@Test
	public void checkDiv() {
		Executable divide0 = new Executable() {
			@Override
			public void execute() throws Throwable {
				divideInt(10,0);				
			}
		};
		
		assertEquals(3d, divideInt(12,4));
		assertThrows(ArithmeticException.class, divide0);
		assertEquals(6.5, divideDouble(13,2));
		assertEquals(1d/3d, divideDouble(1,3));
	}
	
	@Test
	public void checkSort() {
		List<Integer> list = IntStream.of(30,-1,2,2).boxed().collect(Collectors.toList());
		List<Integer> listSortedAsc = IntStream.of(-1,2,2,30).boxed().collect(Collectors.toList());
		List<Integer> listSortedDesc = IntStream.of(30,2,2,-1).boxed().collect(Collectors.toList());
		List<Integer> emptyList = new ArrayList<>();
		List<Integer> emptyList2 = new ArrayList<>();
		
		sort(list, true);
		assertEquals(listSortedAsc, list, "The list hasn't been asc sorted correctly");
		
		sort(list, false);
		assertEquals(listSortedDesc, list, "The list hasn't been desc sorted correctly");
		
		sort(emptyList, true);
		assertEquals(emptyList2, emptyList, "The empty list hasn't been asc sorted correctly");
		
		sort(emptyList, false);
		assertEquals(emptyList2, emptyList, "The empty list hasn't been desc sorted correctly");
		/* pas pertinent dans un langage fortement typé	
		Executable notList = new Executable() {
			@Override
			public void execute() throws Throwable {
				//sort(10,true); 			
			}
		};
		assertThrows(Error.class, notList, "A non sorted type has been sorted!");
		*/
	}
}
