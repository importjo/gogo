package spreadSheet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class ColumnFinder {

	private final String PARAM_DELIMITER = "--";
	private final int LAST_INDEX_OF_PARAM = 2;

	private String sqlToFilter;
	private List<Integer> allColumnsPositions;

	public ColumnFinder() {
		this.allColumnsPositions = new ArrayList<Integer>();
	}

	public void findColumnIndexFor(String sqlString) {
		this.sqlToFilter = sqlString;
		filterStringForColumnParam();
	}

	private void filterStringForColumnParam() {
		Collections.list(new StringTokenizer(this.sqlToFilter)).stream().map(token -> (String) token)
				.filter(token -> token.contains(PARAM_DELIMITER))
				.forEach(token -> findPositionInAlphabet(token.charAt(LAST_INDEX_OF_PARAM)));
	}

	private void findPositionInAlphabet(char inputLetter) {
		char inputLetterToLowerCase = Character.toLowerCase(inputLetter);
		int asciiValueOfinputChar = (int) inputLetterToLowerCase;
		int position = asciiValueOfinputChar - 96;
		this.allColumnsPositions.add(position);
	}

	public List<Integer> getColumnsPositions() {
		return this.allColumnsPositions;
	}

}
