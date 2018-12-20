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

    // The method checks if the first symbol in sequences is the same.
    public static boolean isFirstCharsEqual(String one, String two) {
        char[] charsOne = one.toCharArray();
        char[] charsTwo = two.toCharArray();
        if (charsOne[0] == charsTwo[0]) {
            return true;
        }
        return false;
    }

    //The methods that reverse substrings.
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
        Pattern pattern2 = Pattern.compile("1{1}(0{2,}1{1}0{1}|0{3,}1{1}0{2}|0{4,}1{1}0{3}|0{5,}1{1}0{4})1{1,}");
        Matcher matcher = pattern2.matcher(string);
        while (matcher.find()) {
            StringBuilder subsb = new StringBuilder();
            String subsequence = matcher.group();
            subsb.append(subsequence);
            subsb.reverse();
            string = string.replaceFirst(subsequence, subsb.toString());
            moveZeroesToRight(string);
        }
        return string;
    }

    // The method compares two sequences received after replacement of substrings.
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
}