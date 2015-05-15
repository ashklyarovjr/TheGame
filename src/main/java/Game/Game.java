package Game;


import Entities.Player;
import Entities.Word;
import Exceptions.NoSuchParserException;
import Factory.AbstractParsersFactory;
import Factory.ParsersFactory;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class Game extends AbstractGame implements AbstractGameInterface {

    static HashMap<Word, Boolean> dictionary;

    public Game() throws NoSuchParserException, SQLException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        setDictionary(new ParsersFactory().getParser().parse());
        System.out.println("Set quantity of users: ");



    }

    public static HashMap<Word, Boolean> getDictionary() {
        return dictionary;
    }

    public static void setDictionary(HashMap<Word, Boolean> dictionary) {
        Game.dictionary = dictionary;
    }


    @Override
    public Player[] start(Player... players) {
        return players;
    }

    @Override
    public void play() {

    }

    @Override
    public void end() {

    }


}
