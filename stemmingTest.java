package lucenedemo.extract;

//Finally working case: lucene 6.5.1 June 2017
import org.tartarus.snowball.ext.EnglishStemmer;

public class stemmingTest {

	public static void main(String[] a) {
		EnglishStemmer stemmer = new EnglishStemmer();
		 
	    String[] test1 = {"bank", "banks", "banking", "banker", "banked", "bankers"};
	    
	    String str = "u.s.a usa at&t atts logs balls boxes children men as was going japanese automation";
	    String[] test = str.split(" ");
	    
	    for (int i = 0; i < test.length; i++) { 
	      stemmer.setCurrent(test[i]);
	      stemmer.stem();
	      System.out.print(stemmer.getCurrent() + " "); 
	    }


	}

}

//public static String stemString(String str, EnglishStemmer stemmer) { 
//	  String stemmedString = ""; 
//	  String[] words = str.split("\\s+"); 
//	  for (int i = 0; i < words.length; i++) { 
//	   String word = words[i]; 
//	   stemmer.setCurrent(word); 
//	   stemmer.stem(); 
//	   stemmedString += stemmer.getCurrent(); 
//	   if (i != words.length) 
//	    stemmedString += " "; 
//	  } 
//	  return stemmedString; 
//	 } 
