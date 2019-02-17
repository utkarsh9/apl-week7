public class Eighteen {
	
	public static void main(String[] args){
		Object wfi = Profiler.newInstance(new WordFrequencyImpl());
		WordFrequencyApp wfa=(WordFrequencyApp)wfi;
		wfa.printWords(wfa.sortMap(wfa.getWordFrequencyMap(wfa.extractWords(args[0]))));
	}

}
