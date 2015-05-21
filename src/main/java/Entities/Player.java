package Entities;


import java.io.BufferedReader;

public abstract class Player {

    String name;

    private int countOfFails = 0;

    public Player(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCountOfFails() {
        return countOfFails;
    }

    public void setCountOfFails(int countOfFails) {
        this.countOfFails = countOfFails;
    }

    public Word makeAMove(BufferedReader reader)  {
        return null;
    }

    public void countOfFailsIncrement() {
        int count = this.getCountOfFails();
        this.setCountOfFails(++count);
    }

}
