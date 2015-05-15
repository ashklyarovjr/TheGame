package Game;


import Entities.Player;
import Entities.Word;
import Factory.AbstractParsersFactory;

import java.util.HashMap;


public class Game implements AbstractGame {

    static HashMap<Word, Boolean> dictionary;

    public Game() {
        //AbstractParsersFactory factory =
    }

    public static HashMap<Word, Boolean> getDictionary() {
        return dictionary;
    }

    public static void setDictionary(HashMap<Word, Boolean> dictionary) {
        Game.dictionary = dictionary;
    }


    @Override
    public void start(Player... players) {

    }

    @Override
    public void end() {

    }


}
