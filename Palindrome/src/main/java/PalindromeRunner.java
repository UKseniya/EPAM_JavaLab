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
            StringBuilder revertedWord = new StringBuilder(word);
            revertedWord = revertedWord.reverse();
            if(word.equals(revertedWord.toString())){
                System.out.println(revertedWord + " is a palindrome");
            } else {
                isPalindrome = false;
                System.out.println("the word isn't a palindrome");
            }
        }
    }
}
