package spreadSheet;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ColumnFinderTests {

	@Test
	void lettersShouldReturnPositions() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndex("UPDATE test SET nom = --B where nom = --C");
		assertEquals(new ArrayList<Integer>(Arrays.asList(2, 3)), columnFinder.getAllColumnsPositions());
	}
	
	@Test
	void lettersShouldReturnPositionsInverse() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndex("UPDATE test SET nom = --C where nom = --B");
		assertEquals(new ArrayList<Integer>(Arrays.asList(3, 2)), columnFinder.getAllColumnsPositions());
	}
	
	@Test
	void oneLetterShouldReturnOnePosition() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndex("UPDATE test SET nom = --B where nom = 12345");
		assertEquals(new ArrayList<Integer>(Arrays.asList(2)), columnFinder.getAllColumnsPositions());
	}
	
	@Test
	void lowerCaseShouldReturnPosition() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndex("UPDATE test SET nom = --b where nom = 12345");
		assertEquals(new ArrayList<Integer>(Arrays.asList(2)), columnFinder.getAllColumnsPositions());
	}
	
	@Test
	void noLetterShouldReturnEmpty() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndex("UPDATE test SET nom = jo where nom = 12345");
		assertEquals(new ArrayList<Integer>(), columnFinder.getAllColumnsPositions());
	}
	
	@Test
	void noSpaceInSqlShouldReturnEmpty() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndex("UPDATEtestSETnom=jowherenom=12345");
		assertEquals(new ArrayList<Integer>(), columnFinder.getAllColumnsPositions());
	}
	
	@Test
	void noSqlShouldReturnEmpty() {
		ColumnFinder columnFinder = new ColumnFinder();
		assertEquals(new ArrayList<Integer>(), columnFinder.getAllColumnsPositions());
	}
	
	@Test
	void paramWithSpecialCharacterShouldReturnEmpty() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndex("--$ --! --& --*");
		assertEquals(new ArrayList<Integer>(), columnFinder.getAllColumnsPositions());
	}
	
	@Test
	void paramWithNumbersShouldReturnPositions() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndex("UPDATE test SET nom = --9 where nom = --6 --1");
		assertEquals(new ArrayList<Integer>(Arrays.asList(9, 6, 1)), columnFinder.getAllColumnsPositions());
	}

}
