package Game;


import Entities.Computer;
import Entities.Player;
import Entities.Word;
import Exceptions.NoSuchParserException;
import Factory.ParsersFactory;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Set;


public class WordsGame extends AbstractGame {

    private static final Logger LOGGER_INFO = Logger.getLogger(WordsGame.class);

    private static final Logger LOGGER_ERR = Logger.getLogger(WordsGame.class);

    static HashMap<Word, Boolean> dictionary;

    public WordsGame() throws NoSuchParserException, SQLException {

        //Setting list of words
        LOGGER_INFO.info("Before setting dictionary");
        ParsersFactory factory = new ParsersFactory();
        setDictionary(factory.getParser().parse());
        LOGGER_INFO.info("Dictionary set");
    }

    public static HashMap<Word, Boolean> getDictionary() {
        return dictionary;
    }

    public static void setDictionary(HashMap<Word, Boolean> dictionary) {
        WordsGame.dictionary = dictionary;
    }


    public static Word computerMove(Word word) {
        LOGGER_INFO.info("Computer's saying");
        if (word != null) {
            Set<Word> cities = getDictionary().keySet();

            for (Word required : cities) {

                if (word.getLastLetter() == required.getFirstLetter()) {

                    if (getDictionary().get(required)) {

                        LOGGER_INFO.info("Computer said a word,  OK");

                        getDictionary().put(required, false);

                        return required;
                    }
                }
            }
        }
        LOGGER_ERR.warn("Computer can't find suitable word in the dictionary");
        return null;
    }

    boolean acceptWord(Word word) {
        Set<Word> cities = null;
        try {

            cities = getDictionary().keySet();
            LOGGER_INFO.info("");

        } catch (NullPointerException e) {

            LOGGER_INFO.error("Null Pointer Exception, parser doesn't work");

        }


        //Marks word presence in the dictionary
        boolean mark = false;

        //Check that word is in the dictionary
        for (Word iterator : cities) {
            if (iterator.equals(word))
                mark = true;
        }

        //Check that word has been used
        if (mark) {
            if (getDictionary().get(word)) {
                LOGGER_INFO.info("Word found,  OK");
                getDictionary().put(word, false);
                return true;
            }
        }

        System.out.println("Sorry, but this word is absent in the dictionary or has been used.");
        LOGGER_ERR.warn("There's no such word in the dictionary");

        return false;
    }


    @Override
    public void play() throws IOException {
        //Start

        List<Player> players = start();
        LOGGER_INFO.info("Game start() method called");

        int i;
        Word previousWord = null;
        Word nextWord = null;
        LOGGER_INFO.info("Game cycle started");

        for (i = 0; i <= players.size(); ++i) {

            LOGGER_INFO.info("Loop #" + i);

            if (i == players.size()) {

                i = 0;

            }


            if (players.get(i).getCountOfFails() >= 3) {

                LOGGER_ERR.warn("Too many fails for one player");
                System.out.println("Player " + players.get(i).getName() + " failed");
                break;

            }

            if (players.get(i) instanceof Computer) {

                LOGGER_INFO.info("Before computerMove() call");
                nextWord = computerMove(previousWord);

                LOGGER_INFO.info("After computerMove() call");
                if (nextWord == null) {

                    System.out.println("AI " + players.get(i).getName() + " lost");
                    break;

                }

            } else {

                System.out.println(players.get(i).getName() + "'s turn: ");
                Word input = players.get(i).makeAMove(getReader());

                if (acceptWord(input)) {

                    if (previousWord == null) {
                        nextWord = input;
                    }

                    if (previousWord != null && previousWord.getLastLetter() == input.getFirstLetter()) {

                        nextWord = input;

                    } else if (previousWord != null && previousWord.getLastLetter() != input.getFirstLetter()) {
                        LOGGER_ERR.error("Wrong word ingupt from user " + players.get(i).getName());
                        System.out.println(players.get(i).getName() + " said wrong word. It doesn't match to the previous one");

                        int count = players.get(i).getCountOfFails();

                        players.get(i).setCountOfFails(++count);

                    }

                } else {

                    int count = players.get(i).getCountOfFails();

                    players.get(i).setCountOfFails(++count);
                    if (count >= 3) {

                        LOGGER_ERR.warn("Too many fails for one player");

                        System.out.println("Player " + players.get(i).getName() + " failed completely");

                        break;

                    }

                }

            }

            if (nextWord != null) {

                System.out.println(players.get(i).getName() + " said: " + nextWord.getWord());

                previousWord = nextWord;
                nextWord = null;

            }

        }

        end();
    }

    @Override
    public void end() {
        LOGGER_INFO.info("end() method called");

        try {

            getReader().close();
            LOGGER_INFO.info("reader closed");

        } catch (IOException e) {

            LOGGER_ERR.error("static Buffered Reader doesn't exist in the Game or closed.");
            System.out.println("BufferedReader doesn't exist or ");

        }

        setDictionary(null);
        System.out.println("Thanks for playing!");
    }


}