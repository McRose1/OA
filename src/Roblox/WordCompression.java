package Roblox;

/*  Word Compression

 */

public class WordCompression {
    public String compressWord(String word, int k) {
        if (word.length() < k) {
            return word;
        }
        int count = 1;
        int i = 0;
        char[] arr = word.toCharArray();
        for (i = 1; i < word.length(); i++) {
            if (arr[i] == arr[i - 1]) {
                count++;
            } else {
                if (count >= k) {
                    break;
                } else {
                    count = 1;
                }
            }
        }
        if (count >= k) {
            String temp = "";
            if (i - count > 0) {
                temp += word.substring(0, i - count);
            }
            temp += word.substring(i);
            return compressWord(temp, k);
        }
        return word;
    }
}
