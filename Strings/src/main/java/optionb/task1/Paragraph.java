package optionb.task1;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Paragraph {
    private static List<String> sentencesInParagraph = new LinkedList<>();



    public static List<String> divideSentences (File source ){
        String sentence = null;
        String [] sentences = null;
        try ( FileInputStream sourceText = new FileInputStream(source) ){
            byte[] string = new byte[sourceText.available()];
            sourceText.read(string);
            String text = new String(string);
            sentences = text.split("[.!?]\\s*");

            //To divide text with abbreviations taken into account.
            //[.!?]\s*?((\d+\s*)*[A-ZА-Я]+\s*)
            // ((\d+\.\s*)*[А-ЯA-Z]((т.п.|т.д.|пр.)|[^?!.\(]|\([^\)]*\))*[.?!])

            for ( String element : sentences ){
                sentence = element;
                sentencesInParagraph.add(sentence);
            }
        }
        catch ( IOException e ){
            e.getMessage();
        }
        return sentencesInParagraph;
    }

}

