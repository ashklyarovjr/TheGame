package Game;


import Entities.Player;

public interface AbstractGame {

    void start(Player... players);
    void end();
    static boolean acceptWord(){return false;}
}
