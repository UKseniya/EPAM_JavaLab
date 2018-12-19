/* The runner stops when the String entered is not a palindrome.
*
* Output:
*Tenet
Radar
My gym
Red rum, sir, is murder
Star
Star is not a palindrome
* */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PalindromeRunner {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String word;
        Boolean isPalindrome = true;

        while (isPalindrome){
            word = reader.readLine();
            StringBuilder receivedString = new StringBuilder("");
            String[] substrings = word.toLowerCase().split("[\\p{Punct}\\s]+");
            for (String element : substrings){
                receivedString.append(element);
            }
            StringBuilder revertedWord = new StringBuilder(receivedString);
            revertedWord = revertedWord.reverse();
            if(!receivedString.toString().equals(revertedWord.toString())){
                isPalindrome = false;
                System.out.println(word + " is not a palindrome");
            }
        }
    }
}
