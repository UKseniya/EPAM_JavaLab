package optionb.task1;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File source = new File("C:\\Users\\Kseniya\\Desktop\\TempCode\\OriginalText.txt");
        Text text = new Text(source);

        List<Sentence> allSentences = new ArrayList<>();

        for (Paragraph paragraph : text.getParagraphs()) {
            allSentences.addAll(paragraph.getSentences());
        }

        for (int i = 0; i < allSentences.size(); i++) {
            System.out.print("N" + i + " ");
            System.out.println(allSentences.get(i));
        }

        //Sort list by word number
        Collections.sort(allSentences);
        System.out.println("-------------------------");
        System.out.println("Sorted sentences:");
        for (int i = 0; i < allSentences.size(); i++) {
            System.out.print("N" + i + " ");
            System.out.println(allSentences.get(i));
        }

    }
}
