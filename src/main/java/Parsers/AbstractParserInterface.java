package Parsers;

import Entities.Word;

import java.util.HashMap;


public interface AbstractParserInterface {

    HashMap<Word, Boolean> parse();
}
