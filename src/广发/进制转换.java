package 广发;

/*
    十三进制转换成对应的三进制
    0123456789CGB -> 012
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class 进制转换 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String s = input.substring(1, input.length() - 1);
        Map<Character, Integer> map = new HashMap<>();
        map.put('0', 0);
        map.put('1', 1);
        map.put('2', 2);
        map.put('3', 3);
        map.put('4', 4);
        map.put('5', 5);
        map.put('6', 6);
        map.put('7', 7);
        map.put('8', 8);
        map.put('9', 9);
        map.put('C', 10);
        map.put('G', 11);
        map.put('B', 12);
        int ten = 0;
        int n = s.length();
        int pow = 1;
        for (int i = n - 1; i >= 0; i--) {
            int num = map.get(s.charAt(i));
            ten += num * pow;
            pow = pow * 13;
        }
        StringBuilder sb = new StringBuilder();
        while (ten != 0) {
            int res = ten % 3;
            sb.append(res);
            ten /= 3;
        }
        System.out.println(sb.reverse().toString());
    }
}
