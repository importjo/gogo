package app;

import java.io.File;
import java.io.IOException;

public class Application {
	public static void main(String[] args) {
		File file = new File("script.sql");
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
