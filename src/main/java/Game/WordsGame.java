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

    public WordsGame() {

        //Setting list of words
        LOGGER_INFO.info("Before setting dictionary");
        ParsersFactory factory = new ParsersFactory();
        try {

            setDictionary(factory.getParser().parse());

        } catch (NoSuchParserException e) {

            LOGGER_ERR.warn("Unable to get dictionary from that type of document, cause parser doesn't exist");
            System.out.println("Sorry, game is unavailable at that moment, try again later.");

            end();
        }
        LOGGER_INFO.info("Dictionary set");
    }

    public HashMap<Word, Boolean> getDictionary() {
        return dictionary;
    }

    public void setDictionary(HashMap<Word, Boolean> dictionary) {
        WordsGame.dictionary = dictionary;
    }


    Word computerMove(Word word) {

        LOGGER_INFO.info("Computer's saying");

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

        LOGGER_ERR.warn("Computer can't find suitable word in the dictionary");
        return null;
    }

    boolean acceptWord(Word word) {
        Set<Word> cities = null;
        try {

            cities = getDictionary().keySet();
            LOGGER_INFO.info("");

        } catch (NullPointerException e) {

            LOGGER_ERR.error("Null Pointer Exception, parser doesn't work");

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

        Word previousWord = null;
        Word nextWord = null;

        LOGGER_INFO.info("Game cycle started");

        int i;

        int j = 0;

        for (i = 0; i <= players.size(); ++i) {

            LOGGER_INFO.info("Loop #" + j);
            j++;

            //If quantity of players in the list is 1, then we have a winner
            if (players.size() == 1) {

                System.out.println(players.get(0).getName() + " won!");

                System.out.println("Game over!");

                break;
            }

            //Continuing for loop to the infinity
            if (i == players.size()) {

                i = 0;

            }

            //Checks that player hasn't enough failures to loose
            if (players.get(i).getCountOfFails() >= 3) {

                LOGGER_ERR.warn("Too many fails for one player");
                System.out.println("Player " + players.get(i).getName() + " failed");
                break;

            }
            //If player is Computer.class run computerMove()
            if (players.get(i) instanceof Computer) {

                LOGGER_INFO.info("Before computerMove() call");
                nextWord = computerMove(previousWord);

                LOGGER_INFO.info("After computerMove() call");
                if (nextWord == null) {

                    System.out.println("AI " + players.get(i).getName() + " lost");
                    break;

                }
                //If player is User.class run user's makeAMove() method
            } else {

                System.out.println(players.get(i).getName() + "'s turn: ");

                Word input = players.get(i).makeAMove(getReader());

                if (acceptWord(input)) {
                    //For the first iteration
                    if (previousWord == null) {

                        nextWord = input;

                    }
                    //One other iterations, perfect situation;
                    if (previousWord != null && previousWord.getLastLetter() == input.getFirstLetter()) {

                        nextWord = input;
                        //If user entered a word, that is in the dictionary, but it doesn't match to the previous word
                    } else if (previousWord != null && previousWord.getLastLetter() != input.getFirstLetter()) {

                        LOGGER_ERR.error("Wrong word input from user " + players.get(i).getName());
                        System.out.println(players.get(i).getName() + " said wrong word. It doesn't match to the previous one");

                        //Count of fails increment call
                        players.get(i).countOfFailsIncrement();

                    }

                } else {

                    players.get(i).countOfFailsIncrement();

                    if (players.get(i).getCountOfFails() >= 3) {

                        LOGGER_ERR.warn("Too many fails for one player");

                        System.out.println("Player " + players.get(i).getName() + " failed completely");

                        players.remove(i);

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

            System.out.println("BufferedReader doesn't exist or closed");

        }

        setDictionary(null);
        System.out.println("Thanks for playing!");
    }


}
