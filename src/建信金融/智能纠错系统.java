package 建信金融;

/*  智能纠错系统
    请你根据用户输入的小写英文语句（每个单词用空格分隔）建立识别模型，
    找出在文本库语句中或在用户输入语句中只出现过一次， 并且在另一个语句中未出现的单词。

    输入描述：
    第一行为文本库的内容
    第二行为用户输入的语句

    输入：
    "this apple is sweet"
    "this apple is sour"
    输出：
    ["sweet","sour"]
 */

import java.util.*;

public class 智能纠错系统 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String system = sc.nextLine();
        String user = sc.nextLine();
        Map<String, Integer> count1 = new HashMap<>();
        String[] str1 = system.split(" ");
        for (int i = 0; i < str1.length; i++) {
            String cur = str1[i];
            if (i == 0) {
                cur = cur.substring(1);
            }
            if (i == str1.length - 1) {
                cur = cur.substring(0, cur.length() - 1);
            }
            count1.put(cur, count1.getOrDefault(cur, 0) + 1);
        }
        Map<String, Integer> count2 = new HashMap<>();
        String[] str2 = user.split(" ");
        for (int i = 0; i < str2.length; i++) {
            String cur = str2[i];
            if (i == 0) {
                cur = cur.substring(1);
            }
            if (i == str2.length - 1) {
                cur = cur.substring(0, cur.length() - 1);
            }
            count2.put(cur, count2.getOrDefault(cur, 0) + 1);
        }
        List<String> list = new ArrayList<>();
        for (String key : count1.keySet()) {
            if (count1.get(key) == 1 && !count2.containsKey(key)) {
                list.add(key);
            }
        }
        for (String key : count2.keySet()) {
            if (count2.get(key) == 1 && !count1.containsKey(key)) {
                list.add(key);
            }
        }

        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                System.out.print("[\"" + list.get(i) + "\",");
            } else if (i == list.size() - 1) {
                System.out.print("\"" + list.get(i) + "\"]");
            } else {
                System.out.print("\"" +list.get(i) + "\",");
            }
        }
    }
}
