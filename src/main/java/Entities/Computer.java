package Entities;


import Game.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Computer extends Player {

    public Computer(String name) {
        super(name);
    }

    @Override
    Word makeAMove() {return Game.computerMove();}
}
