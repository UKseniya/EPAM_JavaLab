package optionb.task1;

import java.util.LinkedList;
import java.util.List;

public class Paragraph {
    private List<Sentence> sentences = new LinkedList<>();
    private String content = new String();

    public Paragraph(String content) {
        this.content = content;
        sentences = divideSentences(content);
    }

    public List<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(List<Sentence> sentences) {
        this.sentences = sentences;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Sentence> divideSentences(String content) {
        String sentence = null;
        String[] array = null;

        array = content.split("[.!?]\\s*");
        for (String element : array) {
            sentences.add(new Sentence(element));
            //To divide text with abbreviations taken into account.
            //[.!?]\s*?((\d+\s*)*[A-ZА-Я]+\s*)
            // ((\d+\.\s*)*[А-ЯA-Z]((т.п.|т.д.|пр.)|[^?!.\(]|\([^\)]*\))*[.?!])
        }
        return sentences;
    }
}


