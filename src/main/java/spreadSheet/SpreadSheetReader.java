package spreadSheet;

import java.util.HashMap;
import java.util.Map;

public class SpreadSheetReader {
	
	private Map<Integer, String> data;
	
	public SpreadSheetReader() {
		data = new HashMap<>();
		data.put(0, "1,Test,value,debug,1234");
		data.put(1, "2,tesT,debug,value,4321");
	}
	
	public void readCSVFile(String path) {
		
	}
	
	public void convertDataToSQL() {
		
	}
	
	public String getRow(int index) {
		return data.get(index);
	}
}
