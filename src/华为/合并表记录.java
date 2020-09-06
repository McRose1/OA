package 华为;

/*  合并表记录
    数据表记录包含表索引和数值（int范围的整数），请对表索引相同的记录进行合并，即将相同索引的数值进行求和运算，输出按照key值升序进行输出。

    输入描述:
    先输入键值对的个数
    然后输入成对的index和value值，以空格隔开

    输出描述:
    输出合并后的键值对（多行）

    示例1
    输入
    4
    0 1
    0 2
    1 2
    3 4
    输出
    0 3
    1 2
    3 4
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class 合并表记录 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int key = sc.nextInt();
            int value = sc.nextInt();
            map.put(key, map.getOrDefault(key, 0) + value);
        }
        List<int[]> res = new ArrayList<>();
        for (int key : map.keySet()) {
            int[] temp = new int[2];
            temp[0] = key;
            temp[1] = map.get(key);
            res.add(temp);
        }
        res.sort((a, b) -> a[0] - b[0]);
        for (int i = 0; i < res.size(); i++) {
            if (i == res.size() - 1) {
                System.out.print(res.get(i)[0] + " " + res.get(i)[1]);
            } else {
                System.out.println(res.get(i)[0] + " " + res.get(i)[1]);
            }
        }
    }
}
