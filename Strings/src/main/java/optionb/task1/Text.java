package optionb.task1;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Text {
    private static List<String> paragraphsInText = new LinkedList<>();

    public static List<String> divideParagraphs ( File source ){
        String [] paragraphs = null;
        String paragraph = null;
        try ( FileInputStream sourceText = new FileInputStream(source) ){
            byte[] string = new byte[sourceText.available()];
            sourceText.read(string);
            String text = new String(string);

            paragraphs = text.split("\n");

            for ( String element : paragraphs ){
                paragraph = element;
                paragraphsInText.add(paragraph);
            }
        }
        catch ( IOException e ){
            e.getMessage();
        }
        return paragraphsInText;
    }
}
