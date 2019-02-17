import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WordFrequencyImpl implements WordFrequencyApp {

	public  List<String> extractWords(String filePath) {
		List<String> filteredWords = null;
		try {
			List<String> stopWords = Files.lines(Paths.get("stop-words.txt"))
					.map(line -> line.split(",")).flatMap(Arrays::stream).collect(Collectors.toList());

			List<String> bookWords = Files.lines(Paths.get(filePath))
					.flatMap(line -> Arrays.stream(line.split("[\\s,;:?._!--]+"))).map(s -> s.toLowerCase())
					.collect(Collectors.toList());

			filteredWords = bookWords.parallelStream()
					.filter(d -> stopWords.parallelStream()
							.allMatch(f -> !d.equals(f) && !d.equals("") && !d.equals("s")))
					.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		return filteredWords;

	}

	public  Map<String, Integer> getWordFrequencyMap(List<String> wordList) {
		Map<String, Integer> wordFrequencyMap;
		wordFrequencyMap = wordList.stream().collect(Collectors.toMap(w -> w, w -> 1, Integer::sum));
		return wordFrequencyMap;
	}

	public  Map<String, Integer> sortMap(Map<String, Integer> wordMap) {
		Map<String, Integer> sortedMap = wordMap.entrySet().stream()
				.sorted((element1, element2) -> Integer.compare(element2.getValue(), element1.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
						LinkedHashMap::new));

		return sortedMap;
	}

	public  void printWords(Map<String, Integer> sortedMap) {
		sortedMap.entrySet().stream().limit(25)
				.forEach(element -> System.out.println(element.getKey() + "-" + element.getValue()));
	}


}
