package Entities;


public class Word {
    String word;
    char firstLetter;
    char lastLetter;

    private char getFirstFromString() {

        return getWord().charAt(0);
    }
    private char getLastFromString() {

        return getWord().charAt(getWord().length() - 1);

    }

    public Word(String word) {
        this.word = word;
        setFirstLetter(getFirstFromString());
        setLastLetter(getLastFromString());
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Word)) return false;

        Word word1 = (Word) o;

        if (firstLetter != word1.firstLetter) return false;
        if (lastLetter != word1.lastLetter) return false;
        return word.equals(word1.word);

    }

    @Override
    public int hashCode() {
        int result = word.hashCode();
        result = 31 * result + (int) firstLetter;
        result = 31 * result + (int) lastLetter;
        return result;
    }
}
