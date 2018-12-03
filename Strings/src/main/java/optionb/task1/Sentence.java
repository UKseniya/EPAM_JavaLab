package optionb.task1;

import java.util.LinkedList;
import java.util.List;

public class Sentence {
    private List<Word> words = new LinkedList<>();
    private String content = new String();

    public Sentence(String content) {
        this.content = content;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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
    public String toString() {
        return "Sentence{" +
                "content='" + content + '\'' +
                '}';
    }
}