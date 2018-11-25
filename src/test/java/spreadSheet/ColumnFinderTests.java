package spreadSheet;

import static org.junit.jupiter.api.Assertions.*;
import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class ColumnFinderTests {

	@Test
	void lettersShouldReturnPositions() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndexFor("UPDATE test SET nom = --B where nom = --C");
		assertEquals(new ArrayList<Integer>(Arrays.asList(2, 3)), columnFinder.getColumnsPositions());
	}
	
	@Test
	void lettersShouldReturnPositionsInverse() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndexFor("UPDATE test SET nom = --C where nom = --B");
		assertEquals(new ArrayList<Integer>(Arrays.asList(3, 2)), columnFinder.getColumnsPositions());
	}
	
	@Test
	void oneLetterShouldReturnOnePosition() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndexFor("UPDATE test SET nom = --B where nom = 12345");
		assertEquals(new ArrayList<Integer>(Arrays.asList(2)), columnFinder.getColumnsPositions());
	}
	
	@Test
	void noLetterShouldReturnEmpty() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndexFor("UPDATE test SET nom = jo where nom = 12345");
		assertEquals(new ArrayList<Integer>(), columnFinder.getColumnsPositions());
	}

}
