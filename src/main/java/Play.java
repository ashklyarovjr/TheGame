import Exceptions.NoSuchParserException;
import Game.WordsGame;

import java.sql.SQLException;


public class Play {
    public static void main(String[] args) throws NoSuchParserException, SQLException {
        WordsGame game = new WordsGame();
        game.play();
    }
}
