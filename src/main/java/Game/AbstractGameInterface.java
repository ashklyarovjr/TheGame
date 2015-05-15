package Game;


import Entities.Player;

public interface AbstractGameInterface {

    Player[] start(Player... players);

    void play();

    void end();
}
