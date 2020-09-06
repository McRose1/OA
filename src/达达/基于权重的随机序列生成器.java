package 达达;

/*  基于权重的随机序列生成器
    给定一组带权重的数据，实现一个算法：
        1. 能每次随机获取该组数据中的一个
        2. 各数据被获取的概率符合其权重占比

    输出数据 ID 序列，每行一个，应至少输出 10000 个 ID

    输入：
    4
    1,1
    2,2
    3,3
    4,4

    输出：
    1
    2
    3
    4
    2
    3
    4
    4
    3
    4
 */

import java.util.*;

/*  0%

 */
public class 基于权重的随机序列生成器 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String input = sc.nextLine();
            String[] str = input.split(",");
            int ID = Integer.parseInt(str[0]);
            int weight = Integer.parseInt(str[1]);
            map.put(weight, ID);
        }
        List<Integer> pool = new ArrayList<>();

        for (int weight : map.keySet()) {
            int times = weight;
            while (times-- > 0) {
                pool.add(map.get(weight));
            }
        }

        while (pool.size() != 0) {
            Random r = new Random();
            int index = r.nextInt(pool.size());
            if (pool.size() == 1) {
                System.out.print(pool.get(index));
            } else {
                System.out.println(pool.get(index));
            }
            pool.remove(index);
        }
    }
}
