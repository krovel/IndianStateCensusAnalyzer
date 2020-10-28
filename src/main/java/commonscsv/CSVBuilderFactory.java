package commonscsv;

public class CSVBuilderFactory {

	public static <E> ICSVBuilder<E> createCSVBuilder() {
		return new CommonsCSVBuilder<E>();
	}	
}