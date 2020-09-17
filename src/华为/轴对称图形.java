package 华为;

/*  轴对称图形
    无向图，给定起点和终点，判断是否为对称图，并且起点和终点也是对称点。
    如果是，找到对称轴上所有点 id 的值的和，否则输出 0。

    输入描述：
    第一行为起点和终点 id
    第二行为边的数量 N
    第三行开始是所有的边

    输入：
    1 3
    4
    1 2
    2 3
    1 4
    3 4

    输出：
    6

    输入：
    1 3
    5
    1 5
    5 6
    5 7
    3 6
    3 7

    输出：
    0
 */

import java.util.*;

/*  6.67% x 2

 */
public class 轴对称图形 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int N = sc.nextInt();
        int sum = 0;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int key = 0;
            if (a == start || a == end) {
                key = a;
                sum += b;
            }
            else if (b == start || b == end) {
                key = b;
                sum += a;
            }
            List<Integer> list = new ArrayList<>();
            if (graph.containsKey(key)) {
                list = graph.get(key);
            }
            list.add(a == key ? b : a);
            graph.put(key, list);
        }
        Set<Integer> set = new HashSet<>();

        for (int key : graph.keySet()) {
            if (key == start) {
                List<Integer> temp = graph.get(key);
                set.addAll(temp);
            }
        }
        for (int key : graph.keySet()) {
            if (key == end) {
                List<Integer> temp = graph.get(key);
                for (int n : temp) {
                    if (!set.contains(n)) {
                        System.out.println(0);
                        return;
                    } else {
                        set.remove(n);
                    }
                }
            }
        }
        if (N == 1) {
            System.out.println(start);
            return;
        }

        if (set.size() == 0) {
            System.out.println(sum / 2);
        } else {
            System.out.println(0);
        }
    }
}
