package optionb.task1;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements Comparable {
    private String content;
    private List<Word> words = new ArrayList<>();

    public Sentence(String content) {
        this.content = content;
        words = divideWords(content);
    }

    public Sentence() {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Word> getWords() {
        return words;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public List<Word> divideWords(String content) {
        String[] array = null;

        array = content.split("[\\p{Punct}\\s]+");

        for (String element : array) {
            words.add(new Word(element));
        }
        return words;
    }

    @Override
    public int compareTo(Object o) {
        Sentence other = (Sentence) o;
        if (this.words.size() == other.getWords().size())
            return 0;
        else if (this.words.size() > other.getWords().size())
            return 1;
        else
            return -1;
    }

    @Override
    public String toString() {
        return getContent();
    }
}