package com.numhero.server.search;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.TermAttribute;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class TextTokenizer {
    @Inject
    private Analyzer analyzer;

    public TextTokenizer() {
    }

    public List<String> getTokens(String text) {
        TokenStream stream = analyzer.tokenStream("contents", new StringReader(text));
        List<String> ret = new ArrayList<String>();
        while (true) {
            try {
                if (!stream.incrementToken()) break;
            } catch (IOException ioex) {
                break;
            }
            if (stream.hasAttributes()) {
                TermAttribute term = stream.getAttribute(TermAttribute.class);
                if (term != null) {
                    ret.add(term.term());
                }
            }
        }
        return ret;
    }
}
