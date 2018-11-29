package optionb.task1;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File source = new File("C:\\Users\\Kseniya\\Desktop\\TempCode\\OriginalText.txt");
        Text text = new Text();
        Word word = new Word();
        Sentence sentence = new Sentence();
        Paragraph paragraph = new Paragraph();

        List<String> words = sentence.divideWords(source);

        for (String element : words) {
            //System.out.println(element);
        }

        List<String> sentences = paragraph.divideSentences(source);

        for ( String element : sentences ){
            //System.out.println(element);

        }

        List<String> paragraphs = text.divideParagraphs(source);

        for ( String element : paragraphs ){
            System.out.println(element);
        }
    }

}
