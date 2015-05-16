package Game;


import Entities.Player;

import java.io.IOException;

public interface AbstractGameInterface {

    /**
     * Method to determine quantity of players,
     * how many AIs and how many Users will play.
     * @return players - array of players.
     * */
    static Player[] start(){return null;}


    /**
     * Method initiates process of the game.
     * */
    void play();

    /**
     * Method clears all game resources.
     * */
    void end();
}
