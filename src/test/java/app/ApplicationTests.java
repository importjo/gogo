package app;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.io.File;

import org.junit.jupiter.api.Test;

class ApplicationTests {

	@Test
	void testApplication() {
		String[] paramTbl = {"UPDATE test SET nom = B where nom = C","excel.csv"};
		Application.main(paramTbl);
		assertTrue(new File("script.sql").exists());
	}

}
