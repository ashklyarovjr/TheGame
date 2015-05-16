package Entities;


import java.io.IOException;
import java.util.HashMap;

public abstract class Player {

    String name;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    abstract Word makeAMove() throws IOException;

}
