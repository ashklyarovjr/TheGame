package Parsers.XMLParser;

import Entities.Word;
import Parsers.AbstractParser;
import Parsers.AbstractParserInterface;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;
import java.util.HashMap;


public class XMLParser extends AbstractParser implements AbstractParserInterface {

    private SAXHandler handler = null;

    public XMLParser(String filePath) {
        super(filePath);
    }

    @Override
    public HashMap<Word, Boolean> parse() {
        try {
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

            javax.xml.parsers.SAXParser saxParser = saxParserFactory.newSAXParser();


            handler = new SAXHandler();

            saxParser.parse(getFilePath(), handler);


        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        return handler.getWordsList();
    }
}
