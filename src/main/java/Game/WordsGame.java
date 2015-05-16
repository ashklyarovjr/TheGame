package Game;


import Entities.Computer;
import Entities.Player;
import Entities.Word;
import Exceptions.NoSuchParserException;
import Factory.ParsersFactory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;


public class WordsGame extends AbstractGame {

    static HashMap<Word, Boolean> dictionary;

    public WordsGame() throws NoSuchParserException, SQLException {
        //Setting list of words
        setDictionary(new ParsersFactory().getParser().parse());
    }

    public static HashMap<Word, Boolean> getDictionary() {
        return dictionary;
    }

    public static void setDictionary(HashMap<Word, Boolean> dictionary) {
        WordsGame.dictionary = dictionary;
    }

    public static Word computerMove(Word word) {
        if (word != null)  {
            Set<Word> cities = getDictionary().keySet();

            for (Word required : cities) {
                if (required.getFirstLetter() == word.getLastLetter())
                    return word;
            }
        }
        return null;
    }

    private static boolean acceptWord(Word word) {
        Set<Word> cities = getDictionary().keySet();

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
                return true;
        }
        System.out.println("Sorry, but this word is absent in the dictionary or has been used.");
        return false;
    }




    @Override
    public void play() {
        //Start
        Player[] players = start();

        int i;
        Word previousWord = null;
        Word nextWord = null;
        for (i = 0; i < players.length; ++i) {

            if (i == players.length - 1) {
                i = 0;
            }

            if (players[i].getCountOfFails() >= 3) {
                System.out.println("Player " + players[i].getName() + " failed");
                break;
            }

            if (players[i].getClass().isInstance(Computer.class)){
                nextWord = this.computerMove(previousWord);
                if (nextWord == null){
                    System.out.println("AI " + players[i].getName() + " lost" );
                    break;
                }
            } else {
                Word input = players[i].makeAMove();

                if (acceptWord(input))
                    nextWord = input;
                else {
                    int count = players[i].getCountOfFails();

                    if (count >= 3) {
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
        setDictionary(null);
        System.out.println("Thanks for playing!");
    }



}
