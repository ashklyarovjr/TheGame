package Entities;

import org.testng.annotations.*;

import java.io.BufferedReader;

import static org.easymock.EasyMock.createMock;

public class PlayerTests {

    private BufferedReader mock;
    private User user;


    @BeforeClass
    public void setUpBeforeClass() {
        mock = createMock(BufferedReader.class);
        user = new User("Test");


    }

    @BeforeMethod
    public void setUp() throws Exception {


    }

    @Test
    public void testUserMove() throws Exception {
        user.makeAMove(mock);

    }

    @AfterMethod
    public void tearDown() throws Exception {


    }

    @AfterClass
    public void tearDownAfterClass() {
        user = null;

    }
}
