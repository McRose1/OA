package Antra;

/*  Flatten
    输入：
    List<Object>: [[1, 2], 3, 4, [5, 6, 7]]
    输出：
    1234567
 */

import java.util.*;
import java.util.stream.Collectors;

public class Flatten {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<>();
        List<Integer> temp1 = new ArrayList<>(Arrays.asList(1, 2));
        int a = 3;
        int b = 4;
        List<Integer> temp2 = new ArrayList<>(Arrays.asList(5, 6, 7));
        list.add(temp1);
        list.add(a);
        list.add(b);
        list.add(temp2);
        String res = flatten(list);
        System.out.println(res);
    }

    private static String flatten(List<Object> list) {
        StringBuilder sb = new StringBuilder();
        List<String> strings = list.stream().map(object -> Objects.toString(object, null)).collect(Collectors.toList());
        for (String s : strings) {
            if (s.length() > 1) {
                s = s.replace("[", "").replace("]", "");
                String[] str = s.split(",| ");
                for (String ss : str) {
                    sb.append(ss);
                }
            } else {
                sb.append(s);
            }
        }
        return sb.toString();
    }
}
