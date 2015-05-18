package Entities;


import org.testng.annotations.*;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.*;

import java.io.BufferedReader;

import static org.easymock.EasyMock.*;

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

        expect(mock.readLine()).andReturn("String");
        expect(mock.readLine()).andReturn("String");
        replay(mock);

        assertThat(user.makeAMove(mock), instanceOf(Word.class));
        assertThat(user.makeAMove(mock).getWord(), is("String"));

        verify(mock);
    }

    @AfterMethod
    public void tearDown() throws Exception {
        user = null;
        mock = null;

    }


}
