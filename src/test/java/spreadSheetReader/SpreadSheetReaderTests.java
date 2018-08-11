package spreadSheetReader;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import spreadSheetReader.SpreadSheetReader;

class SpreadSheetReaderTests {

	@Test
	void testExcelReader() {
		SpreadSheetReader spreadSheetReader = new SpreadSheetReader();
		spreadSheetReader.readCSVFile("excel.csv");
		spreadSheetReader.convertDataToSQL("UPDATE test SET nom = B where nom = C");
		assertTrue(spreadSheetReader.getSQLText().equals("UPDATE test SET nom = 'excelData' where nom = 'oldName'"));
	}

}
