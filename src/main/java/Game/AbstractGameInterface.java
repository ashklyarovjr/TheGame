package Game;


import Entities.Player;

public interface AbstractGameInterface {

    /**
     * Method to determine quantity of players,
     * how many AIs and how many Users will play.
     * @return players - array of players.
     * */
    Player[] start();

    void play(Player... players);

    void end();
}
