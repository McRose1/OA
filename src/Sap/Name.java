package Sap;

import java.util.Scanner;

public class Name {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" |,");

        StringBuilder sb = new StringBuilder();
        sb.append(strs[3]);
        sb.append(" ");
        String rev = reverse(strs[0]);
        sb.append(rev);
        System.out.print(sb.toString());
    }

    static String reverse(String s) {
        char[] chars = s.toCharArray();
        int i = 0;
        int j = chars.length - 1;
        while (i < j) {
            char temp = chars[i];
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }
        return String.valueOf(chars);
    }
}
