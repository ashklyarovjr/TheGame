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
        char first = word.toLowerCase().charAt(0);
        return first;
    }



    public char getLastLetter() {
        char last = word.charAt(word.length() - 1);
        return last;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Word word1 = (Word) o;

        return !(word != null ? !word.equals(word1.word) : word1.word != null);

    }

    @Override
    public int hashCode() {
        return word != null ? word.hashCode() : 0;
    }
}
