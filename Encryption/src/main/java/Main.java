import java.io.*;
/* Написать программу шифрования и дешифрования текста.
* 1. Программа считывать тескт из файла, шифрует его и записывает зашифрованный текст в другой файл.
* 2. Программа считывает зашифрованный текст из второго файла, дешифрует его и сравнивает с первоначальным текстом из
* первого файла
*
* Output:
* Original Text:
In cryptography, encryption is the process of encoding a message or information in such a way that only authorized parties can
access it and those who are not authorized cannot. Encryption does not itself prevent interference, but denies the intelligible
content to a would-be interceptor. In an encryption scheme, the intended information or message, referred to as plaintext,
is encrypted using an encryption algorithm � a cipher � generating ciphertext that can be read only if decrypted. For technical
reasons, an encryption scheme usually uses a pseudo-random encryption key generated by an algorithm. It is in principle possible
to decrypt the message without possessing the key, but, for a well-designed encryption scheme, considerable computational
resources and skills are required. An authorized recipient can easily decrypt the message with the key provided by the originator
to recipients but not to unauthorized users.

Encrypted Text:
\!�J�F��ŗ�l7�z[G�<�a����q'�@����Z�4>h�lɮ�>\�xΦѮ$�v�]4}⦧�j���y��+��}s��'O��8i+�{����eؔ+`��`�e����@�V�q�!�64(�a��_���.���<IH����I:��&�U����Z��5�����mE9Э��1p����i���#ڊ��{�1�c�	c?��a�S�:]s�1��[MJݧoۦ�UR�P�S�Nd%<*�Ts�L����k��	%�g|�& %�Z���'S��h ��m�[С^X9&0�6Ԟ:��hB���5*@�#K�c�"qr�%9�?�^��������V�Y��x
I��#_�#į���H
�~��nD%N��x�����+�]tP�".� ^�]M ����KȗK�Fw$��1Da���݄bJ_�j��T�p�����s�jkZ�͖a+�@��-�Q� ���f:"��������>��Ͳ�/I��<8'P� X����&)�h.~����g�(��]���H���Kn1j���$cUu�ª�s>�U��U��<s�%���Pbd3�Z, �ʞ8b�����29gb�^)a�$H��R��Ce$:���Gi�k�e����9{	���
�(�6m�T�p}� �%�~[1�U��1��)nE�-�ř9�>���q��=���w@kc¸�:|f������_��)��Vd��Cdv����7��Y;�|ʧ�8Eڵ2��"��.5YW�Gm��u)W�E���Z~0|������e��N�}�j�y��É�im

Decrypted Text:
In cryptography, encryption is the process of encoding a message or information in such a way that only authorized parties can
access it and those who are not authorized cannot. Encryption does not itself prevent interference, but denies the intelligible
content to a would-be interceptor. In an encryption scheme, the intended information or message, referred to as plaintext, is
encrypted using an encryption algorithm � a cipher � generating ciphertext that can be read only if decrypted. For technical
reasons, an encryption scheme usually uses a pseudo-random encryption key generated by an algorithm. It is in principle possible
to decrypt the message without possessing the key, but, for a well-designed encryption scheme, considerable computational
resources and skills are required. An authorized recipient can easily decrypt the message with the key provided by the originator
to recipients but not to unauthorized users.

Decrypted Text equals Original: true
*/

public class Main {
    public static void main(String[] args) throws IOException {

        Aes265Class aes265Class = new Aes265Class();
        File originalText = new File("C:\\Users\\Kseniya\\Desktop\\TempCode\\OriginalText.txt");
        File encryptedText = new File("C:\\Users\\Kseniya\\Desktop\\TempCode\\EncryptedText.txt");

        aes265Class.encryptText(originalText, encryptedText);

        aes265Class.decryptTextAndCompare(encryptedText, originalText);

    }
}