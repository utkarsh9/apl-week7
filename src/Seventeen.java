import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Seventeen {

	public static List<String> stopWords = new ArrayList<String>();

	public static void main(String[] args) {
		try {
			stopWords = Files.lines(Paths.get(args[1])).map(line -> line.split(","))
					.flatMap(Arrays::stream).collect(Collectors.toList());
			Class<?> reflection = Class.forName("Seventeen");
			reflection.getMethod("printTop25Words", List.class).invoke(null,
					reflection.getMethod("removeStopWords", List.class).invoke(null, reflection
							.getMethod("readFile", String.class).invoke(null, args[0])));
		} catch (IOException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

	public static List<String> readFile(String filePath) throws IOException {
		return Files.lines(Paths.get(filePath)).flatMap(line -> Arrays.stream(line.split("[\\s,;:?._!--]+")))
				.map(s -> s.toLowerCase()).collect(Collectors.toList());

	}

	public static List<String> removeStopWords(List<String> allWords) {
		return allWords.stream().filter(word -> !stopWords.contains(word) && !"s".equals(word) && !"".equals(word))
				.collect(Collectors.toList());

	}

	public static void printTop25Words(List<String> filteredWords) {
		filteredWords.stream().collect(Collectors.toMap(w -> w, w -> 1, Integer::sum)).entrySet().stream()
				.sorted((element1, element2) -> Integer.compare(element2.getValue(), element1.getValue())).limit(25)
				.forEach(element -> System.out.println(element.getKey() + "-" + element.getValue()));
	}

}
