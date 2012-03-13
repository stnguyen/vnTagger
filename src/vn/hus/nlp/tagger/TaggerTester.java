/**
 * Phuong LE HONG, phuonglh@gmail.com
 */
package vn.hus.nlp.tagger;

import java.util.List;

import edu.stanford.nlp.stats.Counter;
import edu.stanford.nlp.stats.Counters;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.tagger.maxent.TaggerConfig;
import edu.stanford.nlp.tagger.maxent.TestClassifier;
import edu.stanford.nlp.util.Pair;

/**
 * @author LE HONG Phuong, phuonglh@gmail.com
 * <p>
 * Oct 8, 2009, 4:18:35 PM
 * <p>
 * The tester for the taggeer.
 */
public class TaggerTester {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TaggerConfig config;
		// create a tagger configuration 
		if (args.length > 0) {
			config = new TaggerConfig(args);
		} else {
			// create an array of arguments
			String[] arguments = {"-model", IConstants.DEFAULT_MODEL_FILE, "-testFile", IConstants.CORPUS_TEST};
			config = new TaggerConfig(arguments);
		}
		// verify that the config has the mode "test"
		// and run the test
		if (config.getMode() == TaggerConfig.Mode.TEST) {
			try {
				// test the file 
				MaxentTagger.runTestPublic(config);
				// get the error pairs for error analysis
				// 
				System.out.println("Wrong tag pairs and their counts: ");
				Counter<String> counter = TestClassifier.getTagPairCounter();
				List<Pair<String,Double>> sortedListWithCounts = Counters.toSortedListWithCounts(counter);
				System.out.println(sortedListWithCounts);
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
		}
	}

}
