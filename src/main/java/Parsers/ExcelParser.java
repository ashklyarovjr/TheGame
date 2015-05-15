package Parsers;

import Entities.Word;

import java.util.HashMap;


public class ExcelParser extends AbstractParser implements AbstractParserInterface {

    public ExcelParser(String filePath) {
        super(filePath);
    }

    @Override
    public HashMap<Word, Boolean> parse() {
        return null;
    }
}
