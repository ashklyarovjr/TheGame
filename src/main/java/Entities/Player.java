package Entities;


import java.util.HashMap;

public abstract class Player {

    static HashMap<Word, Boolean> dictionary;

    abstract Word makeAMove();

}
