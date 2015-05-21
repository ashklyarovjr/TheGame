package Game;

import Entities.Word;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;


public class GameTests {

    private Word wordInDict;
    private Word wordOutOfDict;
    private WordsGame game;


    @BeforeClass
    public void setUpBeforeClass() {
        game = new WordsGame();
        wordInDict = new Word("Bangkok");
        wordOutOfDict = new Word("Lalala");
    }


    @Test
    public void acceptWordTestPositive() {

        assertThat(game.acceptWord(wordInDict), is(true));
    }

    @Test
    public void acceptWordTestWordNotFromDict() {

        assertThat(game.acceptWord(wordOutOfDict), is(false));
    }

    @Test
    public void acceptWordTestUsedWord() {
        assertThat(game.acceptWord(wordInDict), is(false));
    }

    @Test
    public void computerMovePositiveTest() {

        Word word = game.computerMove(wordInDict);
        assertThat(word, notNullValue());
    }


    @Test
    public void endTest() {

        game.end();
        assertThat(game.getDictionary(),is(nullValue()));

    }

    @AfterClass
    public void tearDownAfterClass() {
        game = null;
        wordInDict = null;
        wordOutOfDict = null;
    }


}
