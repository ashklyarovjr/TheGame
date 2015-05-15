package Game;


import Entities.Word;

import java.util.HashMap;


public class Game implements AbstractGame {

    static HashMap<Word, Boolean> dictionary;

    public Game() {

    }

    public static HashMap<Word, Boolean> getDictionary() {
        return dictionary;
    }

    public static void setDictionary(HashMap<Word, Boolean> dictionary) {
        Game.dictionary = dictionary;
    }

    public void start() {

    }

    public void end() {

    }


}
