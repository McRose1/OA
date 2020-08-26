package Robinhood;

/*  prefixStrings
    For the given string s, and array of strings a, s is said to be a prefix-string of a if it is a concatenation of some prefix of array a,
    a = ["one", "two", "three"] s = "one" s = "onetwo"

    Given two arrays of strings a and b, your task is to determine whether all the given strings in b are prefix-strings of a.
 */

import java.util.HashSet;
import java.util.Scanner;

public class prefixStrings {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] a = sc.nextLine().split(" ");
        String[] b = sc.nextLine().split(" ");

        boolean isPrefix = true;
        HashSet<String> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (String value : a) {
            sb.append(value);
            set.add(sb.toString());
        }

        for (String s : b) {
            if (!set.contains(s)) {
                isPrefix = false;
                break;
            }
        }
        System.out.print(isPrefix);
    }
}
