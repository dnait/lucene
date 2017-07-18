package lucenedemo.extract;


//Finally working version
import java.io.IOException;
import java.io.StringReader;

import org.apache.lucene.analysis.CharArraySet;

import org.apache.lucene.analysis.StopFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.core.StopAnalyzer;

import org.apache.lucene.analysis.standard.StandardTokenizer;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.util.AttributeFactory;

public class Stopwords_remove {
    @SuppressWarnings("resource")
	public String removeStopWords(String string) throws IOException {
        
        StandardTokenizer tokenizer = new StandardTokenizer();
        
        TokenStream tokenStream = new StandardTokenizer();
        
        tokenizer.setReader(new StringReader(string));
        
        StringBuilder sb = new StringBuilder();
        
        tokenStream = new StopFilter(tokenizer, new CharArraySet(StopAnalyzer.ENGLISH_STOP_WORDS_SET, true));
       // tokenStream.close();
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
        
        return sb.toString();
    }

    public static void main(String args[]) throws IOException
    {
          String text = "this is a java project written by james.";
          Stopwords_remove stopwords = new Stopwords_remove();
          String res = stopwords.removeStopWords(text);
          System.out.println(res);

    }
}
