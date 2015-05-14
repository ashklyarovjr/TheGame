package Entities;


public class Word {
    String word;
    char firstLetter;
    char lastLetter;

    private char getFirstFromString(String word) {
        return '0';
    }
    private char getLastFromString(String word) {return '0';}

    public Word(String word) {
        this.word = word;
        setFirstLetter(getFirstFromString(getWord()));
        setLastLetter(getLastFromString(getWord()));
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public char getFirstLetter() {
        return firstLetter;
    }

    public void setFirstLetter(char firstLetter) {
        this.firstLetter = firstLetter;
    }

    public char getLastLetter() {
        return lastLetter;
    }

    public void setLastLetter(char lastLetter) {
        this.lastLetter = lastLetter;
    }
}
