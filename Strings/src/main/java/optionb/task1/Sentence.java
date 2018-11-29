package optionb.task1;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Sentence {
    private static List<String> wordsInSentence = new LinkedList<>();


    public static List<String> divideWords(File source) {
        String word = null;
        String[] words = null;
        try (FileInputStream sourceText = new FileInputStream(source)) {
            byte[] string = new byte[sourceText.available()];
            sourceText.read(string);
            String text = new String(string);
            words = text.split("[\\p{Punct}\\s]+");

            for (String element : words) {
                word = element;
                wordsInSentence.add(word);
            }
        } catch (IOException e) {
            e.getMessage();
        }
        return wordsInSentence;
    }
}