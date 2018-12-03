package optionb.task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Text {
    private String content;
    private List<Paragraph> paragraphs = new ArrayList<>();

    public Text(File source) {
        paragraphs = divideParagraphs(source);
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List<Paragraph> getParagraphs() {
        return paragraphs;
    }

    public void setParagraphs(List<Paragraph> paragraphs) {
        this.paragraphs = paragraphs;
    }

    public List<Paragraph> divideParagraphs(File source) {
        String[] array;
        try (FileInputStream sourceText = new FileInputStream(source)) {
            byte[] string = new byte[sourceText.available()];
            sourceText.read(string);
            content = new String(string);

            array = content.split("\n");

            for (String element : array) {
                paragraphs.add(new Paragraph(element));
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return paragraphs;
    }

    @Override
    public String toString() {
        return content;
    }
}
