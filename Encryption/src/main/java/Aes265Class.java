import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Aes265Class {

    private SecretKey secretKey;
    private byte[] encryption;
    private byte[] decryption;

    public Aes265Class(){
        try{
            KeyGenerator keyGenerator = KeyGenerator.getInstance("Aes");
            keyGenerator.init(256);

            this.secretKey = keyGenerator.generateKey();
        }
        catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }
    }

    public byte[] makeAes(byte[] rawMessage, int cipherMode){
        try{
            Cipher cipher = Cipher.getInstance("Aes");
            cipher.init(cipherMode, this.secretKey);
            byte[] output = cipher.doFinal(rawMessage);
            return output;
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public void encryptText(File original, File encrypted){
        try( FileReader originalReader = new FileReader(original);
             FileWriter encryptedWriter = new FileWriter(encrypted) ){
            BufferedReader reader = new BufferedReader(originalReader);
            String text = reader.readLine();
            System.out.println("Original Text:");
            System.out.println(text);
            System.out.println(" ");
            encryption = makeAes(text.getBytes(), Cipher.ENCRYPT_MODE);
            encryptedWriter.write(Base64.getEncoder().encodeToString(encryption));
            System.out.println("Encrypted Text:");
            System.out.println(new String(encryption));
            System.out.println(" ");
        }
        catch (IOException e){
            e.getMessage();
        }
    }

    public void decryptTextAndCompare(File encrypted, File original){
        try ( FileReader encryptedReader = new FileReader(encrypted);
              FileReader originalReader = new FileReader(original) ){
            BufferedReader readerEncrypted = new BufferedReader(encryptedReader);
            String encryptedText = readerEncrypted.readLine();
            decryption = makeAes(Base64.getDecoder().decode(encryptedText), Cipher.DECRYPT_MODE);
            String decryptedText = new String(decryption);
            System.out.println("Decrypted Text: ");
            System.out.println(decryptedText);
            System.out.println(" ");
            BufferedReader readerOriginal = new BufferedReader(originalReader);
            String originalText = readerOriginal.readLine();
            System.out.println("Decrypted Text equals Original: " + decryptedText.equals(originalText));
        }
        catch (IOException e){
            e.getMessage();
        }
    }
}
