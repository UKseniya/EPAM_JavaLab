import java.io.*;
import java.text.NumberFormat;

public class Encryption {
    static String alphabet = new String(" abcdefghijklmnopqrstuvwxyzабвгсдеёжзиклмнопрстуфхцчшщьыъэюя0123456789-,.?!");

    public static void encryptText( File original, File encrypted ){
        try  ( InputStreamReader readingOriginal = new InputStreamReader(new FileInputStream(original), "Cp1251");
              OutputStreamWriter writingEncrypted = new OutputStreamWriter(new FileOutputStream(encrypted)) ){
                BufferedReader reader = new BufferedReader(readingOriginal);
                String originalText = reader.readLine().toLowerCase();
                System.out.println(originalText + "\n");
                StringBuilder encryptedText = new StringBuilder();
                NumberFormat numberFormat = NumberFormat.getNumberInstance();
                numberFormat.setMinimumIntegerDigits(2);

                for ( int i = 0; i < originalText.length(); i++ ){
                    int position = alphabet.indexOf(originalText.charAt(i));
                    position += 2;
                    encryptedText.append(numberFormat.format(position));
                }
                writingEncrypted.write(encryptedText.toString());
                System.out.println(encryptedText.toString() + "\n");
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void decryptText( File encrypted, File original ){
        try ( InputStreamReader readingEncrypted = new InputStreamReader(new FileInputStream(encrypted), "Cp1251");
              InputStreamReader readingOriginal = new InputStreamReader(new FileInputStream(original), "Cp1251")){
            BufferedReader readerEncrypted = new BufferedReader(readingEncrypted);
            String encryptedText = readerEncrypted.readLine();
            StringBuilder decryptedText = new StringBuilder();

            for ( int i = 0; i < encryptedText.length(); i+=2 ){
                int position = Integer.parseInt(encryptedText.substring(i, i+2));
                position -= 2;
                decryptedText.append(alphabet.charAt(position));
            }
            String decryptedString = decryptedText.toString();
            System.out.println(decryptedString + "\n");

            BufferedReader readerOriginal = new BufferedReader(readingOriginal);
            String originalText = readerOriginal.readLine().toLowerCase();
            System.out.println("The decrypted text equals the original one: " + decryptedString.equals(originalText));

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
