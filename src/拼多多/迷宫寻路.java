package 拼多多;

/*  迷宫寻路
    假设一个探险家被困在了地底的迷宫之中，要从当前位置开始找到一条通往迷宫出口的路径。
    迷宫可以用一个二维矩阵组成，有的部分是墙，有的部分是路。迷宫之中有的路上还有门，每扇门都在迷宫的某个地方有与之匹配的钥匙，只有先拿到钥匙才能打开门。
    请设计一个算法，帮助探险家找到脱困的最短路径。
    如前所述，迷宫是通过一个二维矩阵表示的，每个元素的值的含义如下 0-墙，1-路，2-探险家的起始位置，3-迷宫的出口，大写字母-门，小写字母-对应大写字母所代表的门的钥匙

    输入描述：
    迷宫的地图，用二维矩阵表示。第一行是表示矩阵的行数和列数M和N
    后面的M行是矩阵的数据，每一行对应与矩阵的一行（中间没有空格）。M和N都不超过100, 门不超过10扇。

    输出描述：
    路径的长度，是一个整数

    输入例子：
    5 5
    02111
    01a0A
    01003
    01001
    01111

    输出例子：
    7
 */

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
//  BFS
public class 迷宫寻路 {
    public static HashSet<Character> set = new HashSet<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] param = sc.nextLine().split(" ");
        int M = Integer.parseInt(param[0]);
        int N = Integer.parseInt(param[1]);
        char[][] matrix = new char[M][N];
        for (int i = 0; i < M; i++) {
            matrix[i] = sc.nextLine().toCharArray();
        }
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == '2') {
                    System.out.println(bfs(matrix, i, j));
                    return;
                }
            }
        }
    }

    private static int bfs(char[][] matrix, int i, int j) {
        int step = 0;
        int m = matrix.length;
        int n = matrix[0].length;

        // 用二进制表示 key
        boolean[][][] visited = new boolean[m][n][1024];
        visited[i][j][0] = true;
        int[][] dirs = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        queue.offer(j);
        queue.offer(0);

        while (!queue.isEmpty()) {
            int size = queue.size() / 3;
            step++;
            while (size > 0) {
                int x = queue.poll();
                int y = queue.poll();
                int k = queue.poll();
                size--;
                for (int[] d : dirs) {
                    int nx = x + d[0];
                    int ny = y + d[1];
                    int key = k;
                    if (nx < 0 || ny < 0 || nx >= m || ny >= n || matrix[nx][ny] == '0') {
                        continue;
                    } else if (matrix[nx][ny] == '3') {
                        return step;
                    } else if (matrix[nx][ny] >= 'a' && matrix[nx][ny] <= 'z') {
                        key = key | 1 << matrix[nx][ny] - 'a';
                    } else if (matrix[nx][ny] >= 'A' && matrix[nx][ny] <= 'Z' && (key & 1 << matrix[nx][ny] - 'A') == 0) {
                        continue;
                    }
                    if (!visited[nx][ny][key]) {
                        visited[nx][ny][key] = true;
                        queue.offer(nx);
                        queue.offer(ny);
                        queue.offer(key);
                    }
                }
            }
        }
        return -1;
    }
}
