package optionb.task1;

import java.io.*;
import java.util.Objects;

public class Word {
    private static String someWord = new String();

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

//    public static String [] divideWords ( File source ){
//        String [] words = null;
//        try ( FileInputStream sourceText = new FileInputStream(source) ){
//            byte[] string = new byte[sourceText.available()];
//            sourceText.read(string);
//            String text = new String(string);
//            words = text.split("[\\p{Punct}\\s]+");
//
//            for ( String word : words ){
//                someWord = word;
//            }
//        }
//        catch ( IOException e ){
//            e.getMessage();
//        }
//        return words;
//    }

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
