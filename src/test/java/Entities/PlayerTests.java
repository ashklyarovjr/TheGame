package Entities;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.BufferedReader;

import static org.easymock.EasyMock.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;

public class PlayerTests {


    private BufferedReader mock;
    private User user;


    @BeforeMethod
    public void setUp() throws Exception {
        mock = createMock(BufferedReader.class);
        user = new User("Test");

    }

    @Test
    public void testUserMove() throws Exception {

        String string = "String";
        expect(mock.readLine()).andReturn(string);
        replay(mock);

        Word word = user.makeAMove(mock);
        assertThat(word, instanceOf(Word.class));
        assertThat(word.getWord(), is(string));

        verify(mock);
    }

    @AfterMethod
    public void tearDown() throws Exception {

        user = null;
        mock = null;

    }


}
