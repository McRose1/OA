package 便利蜂;

/*
    图中是一个5X5的矩阵，每个小块都有一个编号，范围为(0-9，A-O)，需要判断给出的任意不重复不连续，范围为(0-9，A-O) 的字符串，
    在矩阵中组成的图形是否连续（斜线链接为不连续）。
    例如输入字符串为：5FM23，映射到矩阵上的图形为如下，图形是连续的：
    例如输入字符串为：5F7BA，图形如下，图像不连续：

    输入
    一段长度为（2-25），范围为（0-9，A-O）不连续，不重复的字符串

    输出
    如果给出的字符串可以组成连续的图形，则打印Y，否则打印N

    样例输入
    1234
    LN5D4
    23OJB
    样例输出
    N
    Y
    N
 */

import java.util.Scanner;

public class 图像连续 {
    private static char[][] matrix = new char[][]
            {{'0', '1', 'C', 'H', 'A'}, {'9', 'E', '7', 'B', 'I'}, {'K', 'D', '4', '8', 'J'}, {'6', '5', 'F', 'G', 'O'}, {'L', 'N', 'M', '2', '3'}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            boolean res = false;
            String s = sc.nextLine();
            char[] ch = s.toCharArray();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    if (matrix[i][j] == ch[0]) {
                        res = dfs(i, j, 0, ch);
                    }
                }
            }
            if (res) {
                System.out.println("Y");
            } else {
                System.out.println("N");
            }
        }
    }

    private static boolean dfs(int i, int j, int index, char[] ch) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length) {
            return false;
        }
        if (index == ch.length) {
            return true;
        }
        if (matrix[i][j] == ch[index]) {
            return (dfs(i + 1, j, index + 1, ch) || dfs(i - 1, j, index + 1, ch)
                    || dfs(i, j - 1, index + 1, ch) || dfs(i, j + 1, index + 1, ch));
        } else {
            return false;
        }
    }
}
