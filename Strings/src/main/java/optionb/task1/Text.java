package optionb.task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Text {
    private List<Paragraph> paragraphs = new LinkedList<>();

    public Text(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public Text() {

    }

    public Text(File source) {
        paragraphs = divideParagraphs(source);
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public List<Paragraph> divideParagraphs (File source ){
        String [] array;
        try ( FileInputStream sourceText = new FileInputStream(source) ){
            byte[] string = new byte[sourceText.available()];
            sourceText.read(string);
            String text = new String(string);

            array = text.split("\n");

            for ( String element : array ){
                paragraphs.add(new Paragraph(element));
            }
        }
        catch ( IOException e ){
            e.getMessage();
        }
        return paragraphs;
    }

    @Override
    public String toString() {
        StringBuilder  builder = new StringBuilder();
        for (Paragraph paragraph: paragraphs){
            for(Sentence sentence: paragraph.getSentences()){
                for(Word word: sentence.getWords()){
                    builder.append(word.getSomeWord());
                    builder.append(" ");
                }
            }
        }
        return builder.toString();
    }
}
