package caesar;

// This class provides Caesar Cipher encryption and decryption.

// No constructor is used — all methods work directly with the input data
// to keep the solution simple and avoid unnecessary complexity.

import java.util.ArrayList;
import java.util.List;

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
        return encrypt(cipherText, -shiftDec);
    }

    public List<Candidate> decryptCandidates(String cipherText) {
        List<Candidate> candidates = new ArrayList<>();
        int maxShift = detectMaxShift(cipherText);
        for (int shift = 0; shift < maxShift; shift++) {
            String candidateText = encrypt(cipherText, -shift);
            if (isValidText(candidateText)) {
                candidates.add(new Candidate(candidateText, shift));
            }
        }
        return candidates;
    }

    public static class Candidate {
        public final String text;
        public final int shift;

        public Candidate(String text, int shift) {
            this.text = text;
            this.shift = shift;
        }
    }

    private int detectMaxShift(String text) {
        if (text.matches(".*[А-Яа-яЁё].*")) {
            return 33;  //russian alphabet
        } else {
            return 26;  //english alphabet
        }
    }

    private boolean isValidText(String text) {
        return text.matches("[А-Яа-яЁёA-Za-z .,!?;:'\"-]*");
    }

    //SECOND DECRYPTION SOLUTION (might work if external libraries for dictionaries would be allowed)
    public String decryptView(String cipherText) {
        //Brude-force Caesar Cipher Decryption with candidate scoring
        //Would work with external libraries
        if (cipherText == null || cipherText.isEmpty()) {
            return "";
        }
        String bestGuess = "";
        int maxScore = -1;
        int maxShift = detectMaxShift(cipherText);
        for (int shift = 0; shift <= maxShift; shift++) {
            String candidate = encrypt(cipherText, -shift);
            System.out.println("Shift " + shift + ": " + candidate);
            if (!isValidText(candidate)) continue;
            int score = countWords(candidate) + countVowels(candidate);
            System.out.println("Words count: " + score);
            if (score > maxScore) {
                maxScore = score;
                bestGuess = candidate;
            }
        }
        return bestGuess;
    }

    private int countWords(String text) {
        if (text == null || text.isEmpty()) {
            return 0;
        }
        String[] words = text.split("\\s+");
        return words.length;
    }

    private int countVowels(String text) {
        int count = 0;
        String vowels = "аеёиоуыэюяaeiouyAEIOUY";
        for (char c : text.toCharArray()) {
            if (vowels.indexOf(c) >= 0) count++;
        }
        return count;
    }

}
