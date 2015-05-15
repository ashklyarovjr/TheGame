package Parsers.XMLParser;

import Entities.Word;
import Parsers.AbstractParser;
import Parsers.AbstractParserInterface;

import java.util.HashMap;

/**
 * Created by Anton_Shkliarov on 5/14/2015.
 */
public class XMLParser extends AbstractParser implements AbstractParserInterface {

    public XMLParser(String filePath) {
        super(filePath);
    }

    @Override
    public HashMap<Word, Boolean> parse() {
        return null;
    }
}
