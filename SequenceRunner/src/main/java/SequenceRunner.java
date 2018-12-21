import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
* Output:
* 1001011001011000111100001101001
1011000011001110010001011001101
1111111010101001001001000100001
1111111010101001001001000100001
The sequences are equal
* */
public class SequenceRunner {
    private static String string;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sequenceOne = reader.readLine();
        String sequenceTwo = reader.readLine();

        try {
            checkSequence(sequenceOne, sequenceTwo);
            if (sequenceOne.length() == sequenceTwo.length()) {
                if (isFirstCharsEqual(sequenceOne, sequenceTwo)) {
                    if (isSequenceEqual(sequenceOne, sequenceTwo)) {
                        System.out.println("The sequences are equal");
                    } else {
                        System.out.println("The sequences are not equal");
                    }
                } else {
                    System.out.println("The first symbols in sequences are different");
                }
            } else {
                System.out.println("The length of sequences is different.");
            }
        } catch (RuntimeException exception) {
            System.out.println(exception.getMessage());
        }

    }

    //Validation of the sequences entered
    public static void checkSequence(String sequenceOne, String sequenceTwo) {
        if (!sequenceOne.matches("[01]+") || (!sequenceTwo.matches("[01]+"))) {
            throw new RuntimeException("The sequence shall contain 0 and 1 only.");
        }
    }

    //Method to check if the first symbol in sequences is the same.
    public static boolean isFirstCharsEqual(String one, String two) {
        char[] charsOne = one.toCharArray();
        char[] charsTwo = two.toCharArray();
        if (charsOne[0] == charsTwo[0]) {
            return true;
        }
        return false;
    }

    //Methods to reverse substrings.
    public static String moveOnesToLeft(String sequence) {
        string = new String(sequence);
        Pattern pattern1 = Pattern.compile("1{1}0{1,}1{2,}");
        Matcher matcher = pattern1.matcher(string);
        while (matcher.find()) {
            StringBuilder subsb = new StringBuilder();
            String subsequence = matcher.group();
            subsb.append(subsequence);
            subsb.reverse();
            string = string.replaceFirst(subsequence, subsb.toString());
            moveOnesToLeft(string);
        }
        return string;
    }

    public static String moveZeroesToRight(String sequence) {
        string = moveOnesToLeft(sequence);
        int size = string.length();
        Pattern pattern2 = Pattern.compile("1{1}(0{1,})1{1}(0{1,})1{1,}");
        Matcher matcher = pattern2.matcher(string);
        int nextPosition = 1;
        while (matcher.find(nextPosition)) {
            String subsequence = matcher.group();
            int startPosition = matcher.start();
            int zeroes = calculateZeroes(subsequence);
            nextPosition = startPosition + zeroes;
            if (matcher.group(1).length() > matcher.group(2).length()) {
                StringBuilder subsb = new StringBuilder();
                subsb.append(subsequence);
                subsb.reverse();
                string = string.replaceFirst(subsequence, subsb.toString());
                moveZeroesToRight(string);
            }
        }
        return string;
    }

    //Method to compare two sequences received after replacement of substrings.
    public static boolean isSequenceEqual(String one, String two) {
        String sequenceOne = moveZeroesToRight(one);
        System.out.println(sequenceOne);
        String sequenceTwo = moveZeroesToRight(two);
        System.out.println(sequenceTwo);
        if (sequenceOne.equals(sequenceTwo)) {
            return true;
        }
        return false;
    }
    //Method to calculate zeroes in a substring
    public static int calculateZeroes(String substring){
        int numberOfZeroes = 0;
        char[] chars = substring.toCharArray();
        for (int i = 1; i < chars.length; i++){
            if (chars[i] == '0'){
                numberOfZeroes++;
            }
            if (chars[i] == '1'){
                break;
            }
        }
        return numberOfZeroes;
    }
}