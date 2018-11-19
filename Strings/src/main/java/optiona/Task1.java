package optiona;
/** Replace n-letter of each word in a text with a special symbol. If the word length is less than the n specified,
 * no need to change the word. */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        StringBuilder stringBuilder = new StringBuilder();

        String[] strings = text.split("\\s+");

        for ( String element : strings){
            StringBuilder str = new StringBuilder(element);

            if ( str.length() >= 3 ){
                str.setCharAt(2, '3');
            }
            stringBuilder.append(str + " ");
        }
        System.out.println(stringBuilder);
    }
}
