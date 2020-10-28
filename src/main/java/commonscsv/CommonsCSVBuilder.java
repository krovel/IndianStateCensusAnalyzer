package commonscsv;

import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CommonsCSVBuilder<E> implements ICSVBuilder<E> {

	public Iterator<E> getCSVIterator(Reader reader, Class<E> csvClass) throws CSVException {
		try {
			CSVParser parser = CSVParser.parse(reader, CSVFormat.DEFAULT.withFirstRecordAsHeader());
			Iterator<CSVRecord> csvIterator= parser.getRecords().iterator();
			return (Iterator<E>) csvIterator;
		} catch (IllegalStateException | IOException e) {
			throw new CSVException("Invalid state present", CSVException.ExceptionType.INCORRECT_STATE);
		}
	}
}