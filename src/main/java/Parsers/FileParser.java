package Parsers;

import Entities.Word;

import java.util.HashMap;


public class FileParser extends AbstractParser implements AbstractParserInterface {


    public FileParser(String filePath) {
        super(filePath);
    }

    @Override
    public HashMap<Word, Boolean> parse() {
        return null;
    }
}
