package Game;


public interface AbstractGame {

    void start();
    void end();
    static boolean acceptWord(){return false;}
}
