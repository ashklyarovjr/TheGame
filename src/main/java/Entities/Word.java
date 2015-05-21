package Entities;


public class Word {
    String word;

    public Word(String word) {
        this.word = word;
    }

    public Word() {
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public char getFirstLetter() {
        return getWord().toLowerCase().charAt(0);
    }



    public char getLastLetter() {
        return getWord().charAt(getWord().length() - 1);
    }




}
