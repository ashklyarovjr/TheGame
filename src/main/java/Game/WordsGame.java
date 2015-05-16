package Game;


import Entities.Player;
import Entities.Word;
import Exceptions.NoSuchParserException;
import Factory.ParsersFactory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;


public class WordsGame extends AbstractGame {

    static HashMap<Word, Boolean> dictionary;

    public WordsGame() throws NoSuchParserException, SQLException {

        //Setting list of words
        setDictionary(new ParsersFactory().getParser().parse());
        start();
    }

    public static HashMap<Word, Boolean> getDictionary() {
        return dictionary;
    }

    public static void setDictionary(HashMap<Word, Boolean> dictionary) {
        WordsGame.dictionary = dictionary;
    }

    
    private static boolean acceptWord(Word word) {
        Set<Word> cities = getDictionary().keySet();

        //Marks word presence in th dictionary
        boolean mark = false;
        for (Word iterator : cities){
            if (iterator.equals(word))
                mark = true;
        }
        if (mark) {
            if (getDictionary().get(word))
                return true;
        }
        return false;
    }


    @Override
    public void play() {


    }

    @Override
    public void end() {

    }


}
