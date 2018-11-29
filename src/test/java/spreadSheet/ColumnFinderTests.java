package spreadSheet;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class ColumnFinderTests {

	@Test
	public void lettersShouldReturnPositions() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndex("UPDATE test SET nom = --B where nom = --C");
		assertThat(columnFinder.getAllColumnsPositions()).isEqualTo(new ArrayList<Integer>(Arrays.asList(2, 3)));
	}

	@Test
	public void lettersShouldReturnPositionsInverse() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndex("UPDATE test SET nom = --C where nom = --B");
		assertThat(columnFinder.getAllColumnsPositions()).isEqualTo(new ArrayList<Integer>(Arrays.asList(3, 2)));
	}

	@Test
	public void oneLetterShouldReturnOnePosition() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndex("UPDATE test SET nom = --B where nom = 12345");
		assertThat(columnFinder.getAllColumnsPositions()).isEqualTo(new ArrayList<Integer>(Arrays.asList(2)));
	}

	@Test
	public void lowerCaseShouldReturnPosition() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndex("UPDATE test SET nom = --b where nom = 12345");
		assertThat(columnFinder.getAllColumnsPositions()).isEqualTo(new ArrayList<Integer>(Arrays.asList(2)));
	}

	@Test
	public void noLetterShouldReturnEmpty() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndex("UPDATE test SET nom = jo where nom = 12345");
		assertThat(columnFinder.getAllColumnsPositions()).isEqualTo(new ArrayList<Integer>());
	}

	@Test
	public void noSpaceInSqlShouldReturnEmpty() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndex("UPDATEtestSETnom=jowherenom=12345");
		assertThat(columnFinder.getAllColumnsPositions()).isEqualTo(new ArrayList<Integer>());
	}

	@Test
	public void noSqlShouldReturnEmpty() {
		ColumnFinder columnFinder = new ColumnFinder();
		assertThat(columnFinder.getAllColumnsPositions()).isEqualTo(new ArrayList<Integer>());
	}

	@Test
	public void paramWithSpecialCharacterShouldReturnEmpty() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndex("--$ --! --& --*");
		assertThat(columnFinder.getAllColumnsPositions()).isEqualTo(new ArrayList<Integer>());
	}

	@Test
	public void paramWithNumbersShouldReturnPositions() {
		ColumnFinder columnFinder = new ColumnFinder();
		columnFinder.findColumnIndex("UPDATE test SET nom = --9 where nom = --6 --1");
		assertThat(columnFinder.getAllColumnsPositions()).isEqualTo(new ArrayList<Integer>(Arrays.asList(9, 6, 1)));
	}

}
