package Game;


import Entities.Computer;
import Entities.Player;
import Entities.User;
import Parsers.AbstractParser;
import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public abstract class AbstractGame implements AbstractGameInterface {

    private static final Logger LOGGER_INFO = Logger.getLogger(AbstractGame.class);

    private static final Logger LOGGER_ERR = Logger.getLogger(AbstractGame.class);

    public BufferedReader getReader() {
        return reader;
    }

    public static List<Player> getPlayers() {
        return players;
    }

    public static void setPlayers(List<Player> players) {
        AbstractGame.players = players;
    }

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    static List<Player> players;

    protected static List<Player> start() {

        setPlayers(new LinkedList<>());

        LOGGER_INFO.info("Start call");
        int users;
        int comps;

        try {

            //Requesting number of Users and Computers that we need to initialize
            LOGGER_INFO.info("Number of users request");
            System.out.println("Set quantity of users(1 by default): ");
            users = Integer.parseInt(reader.readLine());

            LOGGER_INFO.info("Number of AIs request");
            System.out.println("Set quantity of computers(1 by default): ");
            comps = Integer.parseInt(reader.readLine());

            //Setting default values, if necessary
            if (users == 0) {
                LOGGER_INFO.info("Users = 1");
                users = 1;
            }

            if (comps == 0) {
                LOGGER_INFO.info("AIs = 1");
                comps = 1;
            }

            //Initializing array of players to put into play() method
            players = new ArrayList<>();
            LOGGER_INFO.info("Players array init");

            //Initializing players in the array
            for (int i = 0; i < users + comps; i++) {
                if (i < users)
                    players.add(userInit(reader));
                else
                   players.add(new Computer("AI" + i));

            }

        } catch (IOException | NumberFormatException e) {

            LOGGER_ERR.error("Incorrect input value: " + e + "; start() recall");
            System.out.println("Incorrect input value, try again!");

            //Recursive call in case of exception
            start();
        }
        LOGGER_INFO.info("Start method end");
        return players;
    }

    protected static User userInit(BufferedReader reader) throws IOException {

        System.out.println("Enter user name: ");
        LOGGER_INFO.info("Single User init");

        return new User(reader.readLine());
    }


}
