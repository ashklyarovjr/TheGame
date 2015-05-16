package Entities;


import Game.WordsGame;

public class Computer extends Player {

    public Computer(String name) {
        super(name);
    }

    @Override
    Word makeAMove() {return WordsGame.computerMove();}
}
