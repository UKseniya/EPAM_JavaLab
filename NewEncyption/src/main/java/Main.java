import java.io.File;
/* 1. Encrypt some text from the first file by replacing text symbols with numbers and write the encrypted text into
* the second file.
* 2. Use the second file to decrypt the text and compare the decrypted text with original one.
 *
 * Output:
 * 1. in cryptography, encryption is the process of encoding a message or information in such a way
 * that only authorized parties can access it and those who are not authorized cannot.
 * знаете ли вы, что такое криптография? криптография - это будущее!
 *
 * 617200091400031825162015071801160825710005140318251620091514000919002008050016181503051919001506000514031504091407000100130519190107050015180009140615181301200915140009140019210308000100230125002008012000151412250001212008151809260504001601182009051900030114000103030519190009200001140400200815190500230815000118050014152000012120081518092605040003011414152072003641273346330039370029557100514642004627384233003844374346423044274837597300384437434642304427483759007000574642002847324753333374
 *
 * 1. in cryptography, encryption is the process of encoding a message or information in such a way
 * that only authorized parties can access it and those who are not authorized cannot.
 * знаете ли вы, что такое криптография? криптография - это будущее!
 *
 * The decrypted text equals the original one: true
 * */
public class Main {
    public static void main(String[] args) {

        Encryption encryption = new Encryption();
        File original = new File("C:\\Users\\Kseniya\\Desktop\\TempCode\\OriginalText.txt");
        File encrypted = new File("C:\\Users\\Kseniya\\Desktop\\TempCode\\EncryptedText.txt");

        Encryption.encryptText( original, encrypted );

        Encryption.decryptText( encrypted, original );
    }
}
