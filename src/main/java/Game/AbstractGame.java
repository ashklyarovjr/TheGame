package Game;


import Entities.Computer;
import Entities.Player;
import Entities.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public abstract class AbstractGame implements AbstractGameInterface {

    static Player[]  players;

    protected static Player[] start() {
        int users;
        int comps;
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            //Requesting number of Users and Computers that we need to initialize
            System.out.println("Set quantity of users(1 by default): ");
            users = Integer.parseInt(reader.readLine());
            System.out.println("Set quantity of computers(1 by default): ");
            comps = Integer.parseInt(reader.readLine());

            //Setting default values, if necessary
            if (users == 0){
                users = 1;
            } else if (comps == 0) {
                comps = 1;
            }

            //Initializing array of players to put into play() method
            players = new Player[comps + users];

            //Initializing players in the array
            String name;
            for (int i = 0; i < players.length; i++) {
                if (i%2 == 0) {
                    System.out.println("Enter user name: ");
                    name = reader.readLine();
                    players[i] = new User(name);
                } else {
                    players[i] = new Computer("AI" + i);
                }
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Incorrect input value, try again!");
            //Recursive call in case of exception
            start();
        }

        return players;
    }


}
