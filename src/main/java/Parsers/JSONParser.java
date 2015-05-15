package Parsers;


import Entities.Word;

import java.util.HashMap;

public class JSONParser extends AbstractParser implements AbstractParserInterface {

    public JSONParser(String filePath) {
        super(filePath);
    }

    @Override
    public HashMap<Word, Boolean> parse() {
        return null;
    }
}
