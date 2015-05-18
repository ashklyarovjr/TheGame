package Parsers.XMLParser;

import Entities.Word;
import Parsers.AbstractParser;
import Parsers.AbstractParserInterface;
import org.apache.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;


public class XMLParser extends AbstractParser implements AbstractParserInterface {

    private static final Logger LOGGER_INFO = Logger.getLogger(XMLParser.class);

    private static final Logger LOGGER_ERR = Logger.getLogger(XMLParser.class);

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

            LOGGER_INFO.info("XML parsing started");
            saxParser.parse(getFilePath(), handler);
            LOGGER_INFO.info("XML parsing finished");


        } catch (ParserConfigurationException | SAXException | IOException e) {
            LOGGER_ERR.error("Exception caught on XML: " + e);
            e.printStackTrace();
        }
        LOGGER_INFO.info("Return dictionary from XML");
        return handler.getWordsList();
    }
}
