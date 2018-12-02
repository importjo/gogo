package spreadSheet;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;
import spreadSheet.CsvSheetReader;

class CsvSheetReaderTests {

	@Test
	public void shouldFindFile() {
		ISpreadSheetReader spreadSheetReader = new CsvSheetReader();
		Throwable thrown = catchThrowable(() -> {
			spreadSheetReader.read("test.csv");
		});
		assertThat(thrown).isNull();
	}

}
