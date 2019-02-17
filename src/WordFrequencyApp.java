import java.util.List;
import java.util.Map;

public interface WordFrequencyApp {

	List<String> extractWords(String filePath);

	Map<String, Integer> getWordFrequencyMap(List<String> wordList);

	Map<String, Integer> sortMap(Map<String, Integer> wordMap);

	void printWords(Map<String, Integer> sortedMap);

}