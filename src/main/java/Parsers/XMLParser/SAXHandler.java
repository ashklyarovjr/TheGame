package Parsers.XMLParser;

import Entities.Word;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;


public class SAXHandler extends DefaultHandler {

    private Word word = null;

    private HashMap<Word, Boolean> wordsList = null;

    String content = null;


    public Word getWord() {
        return word;
    }

    public void setWord(Word word) {
        this.word = word;
    }

    public HashMap<Word, Boolean> getWordsList() {
        return wordsList;
    }

    public void setWordsList(HashMap<Word, Boolean> wordsList) {
        this.wordsList = wordsList;
    }

    public void startElement (String uri, String localName, String qName, org.xml.sax.Attributes attributes)
            throws SAXException {
        switch (qName) {
            case "cities":
                setWordsList(new HashMap<>());
                break;
            case "city":
                setWord(new Word(content));
                getWordsList().put(getWord(), true);
                break;
        }
    }

    public void endElement(String uri, String localName, String qName) {

    }

    public void characters(char ch[], int start, int length) {
        content = String.copyValueOf(ch, start, length).trim();
    }




}
