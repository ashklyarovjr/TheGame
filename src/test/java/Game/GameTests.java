package Game;

import Entities.Word;

import org.testng.annotations.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;


public class GameTests {

    private Word wordInDict;
    private Word wordOutOfDict;
    private WordsGame game;


    @BeforeClass
    public void setUpBeforeClass() {
        game = new WordsGame();
        wordInDict = new Word("Havana");
        wordOutOfDict = new Word("Lalala");
    }


    @BeforeMethod
    public void setUp() throws Exception {

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
        assertThat(word, hasProperty("firstLetter", equalTo(wordInDict.getLastLetter())));
    }


    @Test
    public void endTest() {
        game.end();
        assertThat(game.getDictionary(),is(nullValue()));
    }

    


    @AfterMethod
    public void tearDown() throws Exception {


    }

    @AfterClass
    public void tearDownAfterClass() {
        game = null;
        wordInDict = null;
        wordOutOfDict = null;
    }


}
