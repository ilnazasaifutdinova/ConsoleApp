package caesar;

// This class provides Caesar Cipher encryption and decryption.

// No constructor is used — all methods work directly with the input data
// to keep the solution simple and avoid unnecessary complexity.

public class CaesarCipher {

    //Russian Alphabet excludes "Ё" / "ё" for the accurate CaesarCipher Algorithm
    private final String rusAlphaUpper = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯ";
    private final String rusAlphaLower = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    private final String engAlphaUpper = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String engAlphaLower = "abcdefghijklmnopqrstuvwxyz";

    private String findAlphabet(char ch) {
        if (rusAlphaUpper.indexOf(ch) != -1) return rusAlphaUpper;
        if (rusAlphaLower.indexOf(ch) != -1) return rusAlphaLower;
        if (engAlphaUpper.indexOf(ch) != -1) return engAlphaUpper;
        if (engAlphaLower.indexOf(ch) != -1) return engAlphaLower;
        return null;
    }

    private char shiftChar(char ch, int shift) {
        String Alpha;

        if ((Alpha = findAlphabet(ch)) == null) {
            return ch; //return non-letters in the String
        }
        int len = Alpha.length();
        int index = Alpha.indexOf(ch);
        int shiftedIndex = (index + shift) % len;

        if (shiftedIndex < 0) {
            shiftedIndex += len; //wrap around back
        }

        return Alpha.charAt(shiftedIndex);
    }

    public String encrypt(String plainText, int shiftEnc) {
        //Caesar Cipher Encryption
        if (plainText == null || plainText.isEmpty()) {
            return ""; //Check for empty input
        }
        StringBuilder result = new StringBuilder();
        int lenText = plainText.length();
        for (int i = 0; i < lenText; i++) {
            char ch = plainText.charAt(i);
            result.append(shiftChar(ch, shiftEnc));
        }
        return result.toString();
    }

    public String decrypt(String cipherText, int shiftDec) {
        //Caesar Cipher Decryption
        if (cipherText == null || cipherText.isEmpty()) {
            return "";
        }
        return encrypt(cipherText, (-1) * shiftDec);
    }

    public String decrypt(String cipherText) {
        //Caesar Cipher Decryption
        if (cipherText == null || cipherText.isEmpty()) {
            return "";
        }
        return null;
    }
}
