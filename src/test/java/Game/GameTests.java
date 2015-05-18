package Game;

import Entities.Word;
import Factory.ParsersFactory;
import Parsers.AbstractParser;
import Parsers.AbstractParserInterface;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.easymock.EasyMock.*;


public class GameTests {


    @TestSubject
    WordsGame game;

    @Mock
    AbstractParserInterface mock;

    @Mock
    Word mockedWord;

    @BeforeMethod
    public void setUp() throws Exception {
        game = new WordsGame();
        mockedWord = new Word("Kiev");

    }

    @Test
    public void acceptWordTest() throws Exception {

        /*expect(mock.parse()).andReturn(anyObject());
        expect(mockedWord).asStub();
        replay(mock);

        game.acceptWord(mockedWord);
        verify(mock);*/

    }

    @AfterMethod
    public void tearDown() throws Exception {


    }
}
