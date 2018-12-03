package optionb.task1;

import java.util.LinkedList;
import java.util.List;

public class Sentence {
    private List<Word> words = new LinkedList<>();

    public Sentence(String content) {
        words = divideWords(content);
    }

    public Sentence() {

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

}