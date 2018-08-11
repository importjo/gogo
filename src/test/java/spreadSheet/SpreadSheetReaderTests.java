package spreadSheet;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import spreadSheet.SpreadSheetReader;

class SpreadSheetReaderTests {

	@Test
	void testExcelReader() {
		SpreadSheetReader spreadSheetReader = new SpreadSheetReader();
		spreadSheetReader.readCSVFile("excel.csv");
		assertTrue(spreadSheetReader.getRow(0).equals("1,Test,value,debug,1234"));
		assertTrue(spreadSheetReader.getRow(1).equals("2,tesT,debug,value,4321"));
	}

}
