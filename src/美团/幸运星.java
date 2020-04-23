package 美团;

/*
    在观星的时候，一种常用的方式是划出类似于正方形的区域内，确定其中所有星星的坐标。

现在我们在星空（一个无限大的二维平面）上建立坐标系。由于星星很小，我们忽略它的面积，认为每一个星星是一个点，且所有星星的坐标都是整数。

幸运星的定义是这一颗星星在这个平面内，正上，正下，正左，正右都有其他的星星(不一定相邻)。

现在，我们已经将这个正方形的区域取出，并且将他们所在的坐标给你。现在希望你能计算，这个平面内有多少颗幸运星？

输入
输入第一行包含一个数n，代表正方形区域内星星的总数。

接下来n行，每行两个整数xi,yi,代表这颗星星的坐标。

(n<=2000,-1000<=xi,yi<=1000,没有两颗星星的坐标是相同的。)

输出
输出包含一个数，即有多少颗星星是幸运星。


样例输入
8
0 0
0 1
0 2
0 3
1 1
1 2
-1 1
-1 2
样例输出
2

提示
样例解释：
有两颗幸运星，分别是(0,1)(0,2)
 */

import java.util.*;

public class 幸运星 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(sc.nextInt());
            temp.add(sc.nextInt());
            list.add(temp);
        }
        int[][] dirs = new int[][] {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        Map<List<Integer>, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(list.get(i), 0);
        }
        for (int i = 0; i < n; i++) {
            List<Integer> cur = list.get(i);
            int count = map.get(cur);
            int x = cur.get(0);
            int y = cur.get(1);
            for (int[] dir : dirs) {
                int nx = x + dir[0];
                int ny = y + dir[1];
                List<Integer> nei = new ArrayList<>();
                nei.add(nx);
                nei.add(ny);
                if (map.containsKey(nei)) {
                    count++;
                }
            }
            map.put(cur, count);
        }
        int number = 0;
        for (List<Integer> key : map.keySet()) {
            if (map.get(key) == 4) {
                number++;
            }
        }
        System.out.println(number);
    }
}
