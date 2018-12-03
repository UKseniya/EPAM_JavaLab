package optionb.task1;

import java.util.Objects;

public class Word {
    private String someWord = new String();

    public Word() {
    }

    public Word(String someWord) {
        this.someWord = someWord;
    }

    public String getSomeWord() {
        return someWord;
    }

    public void setSomeWord(String someWord) {
        this.someWord = someWord;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Word word = (Word) o;
        return Objects.equals(someWord, word.someWord);
    }

    @Override
    public int hashCode() {

        return Objects.hash(someWord);
    }

    @Override
    public String toString() {
        return "Word{" +
                "someWord='" + someWord + '\'' +
                '}';
    }
}
