package optionb.task1;

import java.io.File;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File source = new File("C:\\Users\\Kseniya\\Desktop\\TempCode\\OriginalText.txt");
        Text text = new Text(source);

        System.out.println(text.toString());


    }
}
