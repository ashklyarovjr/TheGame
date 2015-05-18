package Parsers.XMLParser;

import Entities.Word;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;


public class SAXHandler extends DefaultHandler {

    private static final Logger LOGGER_INFO = Logger.getLogger(XMLParser.class);

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
                LOGGER_INFO.info("Words list set");
                break;

            case "city":

                setWord(new Word());
                break;
        }
    }

    public void endElement(String uri, String localName, String qName) {

        switch (qName) {

            case "cities":

                System.out.println(getWordsList().toString());
                break;

            case "city":

                getWord().setWord(content);
                getWordsList().put(getWord(), true);
                LOGGER_INFO.info("New city added");
                break;
        }
    }

    public void characters(char ch[], int start, int length) {
        content = String.copyValueOf(ch, start, length).trim();
    }




}
