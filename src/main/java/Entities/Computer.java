package Entities;


import Game.Game;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Computer extends Player {

    @Override
    Word makeAMove() {return Game.computerMove();}
}
