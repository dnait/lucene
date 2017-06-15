package lucenedemo.extract;


//Finally working version
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;

import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

public class Stopwords_removeCustom {

	public String removeStopWords(String string) throws IOException {
    	
        StandardTokenizer tokenizer = new StandardTokenizer();
        
 //       TokenStream tokenStream = new StandardTokenizer();
        
        tokenizer.setReader(new StringReader(string));
        
        StringBuilder sb = new StringBuilder();
        
 //       tokenStream = new StopFilter(tokenizer, new CharArraySet(StopAnalyzer.ENGLISH_STOP_WORDS_SET, true));
       // tokenStream.close();
        
        List<String> stopWords = new ArrayList<String>();
        
        /*Scanner s = new Scanner(new File("filepath"));
        ArrayList<String> list = new ArrayList<String>();
        while (s.hasNext()){
            list.add(s.next());
        }
        s.close();
        */
        stopWords.add("written");

        TokenStream tokenStream = new StopFilter(tokenizer, StopFilter.makeStopSet(stopWords));
        tokenizer.reset();
        
        CharTermAttribute token = tokenizer.getAttribute(CharTermAttribute.class);


        while (tokenStream.incrementToken()) 
        {
            if (token.length() > 0) 
            {
                sb.append(" ");
            }
            sb.append(token.toString());
        }
        tokenStream.close();
		tokenizer.close();
        return sb.toString();
    }

    public static void main(String args[]) throws IOException
    {
          String text = "this is a java project written by james.";
          Stopwords_removeCustom stopwords = new Stopwords_removeCustom();
          String res = stopwords.removeStopWords(text);
          System.out.println(res);

    }
}