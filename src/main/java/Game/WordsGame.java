package Game;


import Entities.Computer;
import Entities.Player;
import Entities.Word;
import Exceptions.NoSuchParserException;
import Factory.ParsersFactory;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;


public class WordsGame extends AbstractGame {

    private static final Logger LOGGER = Logger.getLogger(WordsGame.class);

    static HashMap<Word, Boolean> dictionary;

    public WordsGame() throws NoSuchParserException, SQLException {

        //Setting list of words
        LOGGER.info("Before setting dictionary");
        setDictionary(new ParsersFactory().getParser().parse());
        LOGGER.info("Dictionary set");
    }

    public static HashMap<Word, Boolean> getDictionary() {
        return dictionary;
    }

    public static void setDictionary(HashMap<Word, Boolean> dictionary) {
        WordsGame.dictionary = dictionary;
    }


    public static Word computerMove(Word word) {
        LOGGER.info("Computer's saying");
        if (word != null)  {
            Set<Word> cities = getDictionary().keySet();

            for (Word required : cities) {
                if (required.getFirstLetter() == word.getLastLetter())
                    LOGGER.info("Computer said a word,  OK");
                    return word;
            }
        }
        LOGGER.info("Computer can't find suitable word in the dictionary");
        return null;
    }

    boolean acceptWord(Word word) {
        Set<Word> cities = null;
        try {
            cities = getDictionary().keySet();
            LOGGER.info("");
        } catch (NullPointerException e) {
            LOGGER.error("Null Pointer Exception, file not found");
        }

        //Marks word presence in the dictionary
        boolean mark = false;

        //Check that word is in the dictionary
        for (Word iterator : cities){
            if (iterator.equals(word))
                mark = true;
        }

        //Check that word has been used
        if (mark) {
            if (getDictionary().get(word))
                LOGGER.info("Word found,  OK");
                return true;
        }
        System.out.println("Sorry, but this word is absent in the dictionary or has been used.");
        LOGGER.warn("There's no such word in the dictionary");
        return false;
    }




    @Override
    public void play() throws IOException {
        //Start

        Player[] players = start();
        LOGGER.info("Game start() method called");

        int i;
        Word previousWord = null;
        Word nextWord = null;
        for (i = 0; i < players.length; ++i) {
            LOGGER.info("Game cycle started");
            if (i == players.length - 1) {
                i = 0;
            }

            if (players[i].getCountOfFails() >= 3){
                LOGGER.warn("Too many fails for one player");
                System.out.println("Player " + players[i].getName() + " failed");
                break;
            }

            if (players[i].getClass().isInstance(Computer.class)){
                LOGGER.info("Before computerMove() call");
                nextWord = computerMove(previousWord);
                LOGGER.info("After computerMove() call");
                if (nextWord == null){
                    System.out.println("AI " + players[i].getName() + " lost" );
                    break;
                }

            } else {
                Word input = players[i].makeAMove(getReader());

                if (acceptWord(input))
                    nextWord = input;
                else {
                    int count = players[i].getCountOfFails();

                    if (count >= 3) {
                        LOGGER.warn("Too many fails for one player");
                        System.out.println("Player " + players[i].getName() + " failed");
                        break;
                    }

                    players[i].setCountOfFails(++count);

                }

            }
            System.out.println(players[i].getName() + " said: " +  nextWord);

            previousWord = nextWord;
        }

        end();
    }

    @Override
    public void end() {
        LOGGER.info("end() method called");
        try {
            getReader().close();
            LOGGER.info("reader closed");
        } catch (IOException e) {
            System.out.println("BufferedReader doesn't exist or ");
        }
        
        setDictionary(null);
        System.out.println("Thanks for playing!");
    }



}
