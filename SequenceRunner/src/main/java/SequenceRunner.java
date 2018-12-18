import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SequenceRunner {
    private static String string;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sequenceOne = reader.readLine();
        String sequenceTwo = reader.readLine();

        try{
            checkSequence(sequenceOne, sequenceTwo);
            if (sequenceOne.length() == sequenceTwo.length()) {
                if (isFirstCharsEqual(sequenceOne, sequenceTwo)) {
                    if (isSequenceEqual(sequenceOne, sequenceTwo)) {
                        System.out.println("The sequences are equal");
                    } else {
                        System.out.println("The sequences are not equal");
                    }
                } else {
                    System.out.println("The first symbol in sequences is different");
                }
            } else {
                System.out.println("The length of sequences is different.");
            }
        }
        catch (RuntimeException exception){
            System.out.println(exception.getMessage());
        }

    }

    //Validation of the sequences entered
    public static void checkSequence(String sequenceOne, String sequenceTwo){
        if (!sequenceOne.matches("[01]+") || (!sequenceTwo.matches("[01]+"))) {
            throw new RuntimeException ("The sequence shall contain 0 and 1 only.");
        }
    }

    //The method checks if the number of zeroes in both sequences is the same
//        public static boolean isEqualQuantity(String one, String two) {
//        int firstSequenceZeroes = calculateZeros(one);
//        int secondSequenceZeroes = calculateZeros(two);
//        if (firstSequenceZeroes == secondSequenceZeroes) {
//            return true;
//        }
//        return false;
//    }
    // The method calculates the number of zeroes in a sequence.
//    public static int calculateZeros(String sequence) {
//        char[] chars = sequence.toCharArray();
//        int zeros = 0;
//        for (char ch : chars) {
//            if (ch == '0') {
//                zeros++;
//            }
//        }
//        return zeros;
//    }

    // The method checks if the first symbol in sequences is the same.
    public static boolean isFirstCharsEqual(String one, String two) {
        char[] charsOne = one.toCharArray();
        char[] charsTwo = two.toCharArray();
        if (charsOne[0] == charsTwo[0]) {
            return true;
        }
        return false;
    }

    //The method replaces substings for reversed ones.
    public static String replaceChars(String sequence) {
        string = new String(sequence);
        Pattern pattern = Pattern.compile("1{1}0{1,}1{2,}");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {
            StringBuilder subsb = new StringBuilder();
            String subsequence = matcher.group();
            subsb.append(subsequence);
            subsb.reverse();
            string = string.replaceFirst(subsequence, subsb.toString());
            replaceChars(string);
        }

        return string;
    }

    // The method compares two sequences received after replacement of substrings.
    public static boolean isSequenceEqual(String one, String two) {
        String sequenceOne = replaceChars(one);
        System.out.println(sequenceOne);
        String sequenceTwo = replaceChars(two);
        System.out.println(sequenceTwo);
        if (sequenceOne.equals(sequenceTwo)) {
            return true;
        }
        return false;
    }
}