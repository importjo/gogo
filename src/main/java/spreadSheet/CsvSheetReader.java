package spreadSheet;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class CsvSheetReader implements ISpreadSheetReader {

	private final String ROOT_PACKAGE = "spreadSheet";

	private Map<Integer, String> linesOfFile;
	private String filePath;
	private File readFile;

	public CsvSheetReader() {
		this.linesOfFile = new HashMap<Integer, String>();
	}

	@Override
	public void read(String fileName) throws FileNotFoundException {
		createFilePath(fileName);
		loadFile();
	}

	private void createFilePath(String fileName) {
		StringBuilder sb = new StringBuilder();
		sb.append(ROOT_PACKAGE);
		sb.append("/");
		sb.append(fileName);
		this.filePath = sb.toString();
	}

	private void loadFile() {
		ClassLoader classLoader = getClass().getClassLoader();
		this.readFile = new File(classLoader.getResource(this.filePath)
				.getFile());
	}
}
