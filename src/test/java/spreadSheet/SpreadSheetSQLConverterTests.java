package spreadSheet;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SpreadSheetSQLConverterTests {
	
	private Map<Integer, ArrayList<String>> data;
	
	@BeforeEach
	void setUpData() {
		ArrayList<String> text = new ArrayList<String>();
		text.add("1");
		text.add("Test");
		text.add("value");
		text.add("debug");
		text.add("1234");
		
		data = new HashMap<>();
		data.put(0, text);
	}
	

	@Test
	void testSpreadSheetConverter() {
		SpreadSheetSQLConverter spreadSheetSQLConverter = new SpreadSheetSQLConverter();
		spreadSheetSQLConverter.setData(data);
		spreadSheetSQLConverter.convertDataToSQL();
		assertTrue(spreadSheetSQLConverter.getSQLText().equals("UPDATE test SET nom = 'Test' where nom = 'value'"));
	}

}
