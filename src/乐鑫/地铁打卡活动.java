package 乐鑫;

/*  地铁打卡活动
    地铁迷在某个城市组织了地铁打卡活动。活动要求前往该城市中的所有地铁站进行打卡。
    打卡可以在站外或者站内进行。地铁的计价规则如下：只要不出站，就不计费；出站时，只计算进站和出站站点的距离。如在同一个站点进出站，按照最低票价 a 元计算。
    假设地铁票不会超时。
    大部分站点都是通过地铁线连通的，而且地铁站的连通是双向的（若 A，B 连通，则 B，A连通），且具有传递性的（若 A，B 连通，且 B，C 连通，则 A，C连通）。
    但并不是所有的地铁站都相互连通，在不能通过坐地铁达到的两个地点间，交通的花费则提高到 b 元。
    地铁迷从酒店起点出发，再回到酒店。假设从酒店到达任意地铁站的交通花费为 b 元。请计算地铁迷完成打卡最小交通花费。

    输入描述：
    每组输入包括m + 1行。
    第1行包含4个整数n，m，a，b，其中n表示地铁站点数，m表示连通的地铁站点对数，a代表地铁最低票价，b代表非地铁方式票价，其中0 < a < b。
    第2到m + 1行，每行2个整数Hi，Ti代表站点Hi和Ti站点是连通的（0 <= i < m）。

    输出描述：
    输出只有一行，包含一个整数，表示打卡的最小交通花费。

    输入例子：
    8 7 3 6
    0 1
    1 2
    2 3
    0 3
    4 5
    5 6
    4 7

    输出例子：
    24
 */

import java.util.Arrays;
import java.util.Scanner;
//  Union Find
public class 地铁打卡活动 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int[][] graph = new int[m][2];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < 2; j++) {
                graph[i][j] = sc.nextInt();
            }
        }
        int[] parent = new int[n];
        Arrays.fill(parent, -1);

        for (int i = 0; i < m; i++) {
            int x = graph[i][0];
            int y = graph[i][1];
            union(x, y, parent);
        }
        // count 代表 graph 里根节点的个数
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (parent[i] == -1) {
                count++;
            }
        }
        // 从根节点可以遍历所有节点并且回到根节点，所以是 count * a
        // 不同 graph 之间的跟节点需要 b 来访问，所以一共存在 count-1 段这样的路径
        int min = 2 * b + count * a + (count - 1) * b;
        System.out.println(min);
    }

    private static void union(int x, int y, int[] parent) {
        int x_root = find_root(x, parent);
        int y_root = find_root(y, parent);
        if (x_root != y_root) {
            parent[x_root] = y_root;
        }
    }

    private static int find_root(int x, int[] parent) {
        int x_root = x;
        while (parent[x_root] != -1) {
            x_root = parent[x_root];
        }
        return x_root;
    }
}
