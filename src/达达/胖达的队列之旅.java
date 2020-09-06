package 达达;

/*  胖达的队列之旅
    把 1 至 m 对应的 m 个数值按照一定的次序存放在队列 S 中

    // 2, 1, 3
    while (!queue.isEmpty()) {
        Integer head = queue.peek();       // head = 2
        queue.poll();                      // 1, 3
        queue.add(head);                   // 1, 3, 2
        head = queue.peek();               // head = 1
        System.out.print(head + "\n");     // 1
        queue.poll();                      // 3, 2
    }
    从队列头部做取值操作，但不弹出当前队列头

    这段程序的输出正好是顺序的 1、2、3、4 ...m

    现在先要得到初始队列的输入顺序，如何实现

    N < 1000
    1 <= M <= 10000

    输入：
    4
    7
    27
    4
    3

    输出：
    4 1 6 2 5 3 7
    14 1 21 2 15 3 26 4 16 5 22 6 17 7 25 8 18 9 23 10 19 11 27 12 20 13 24
    4 1 3 2
    2 1 3
 */

import java.util.Scanner;

/*  0%

 */
public class 胖达的队列之旅 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        while (N-- > 0) {
            int m = sc.nextInt();
            int[] res = new int[m];
            int begin = 1;
            for (int i = 1; i < m; i += 2) {
                res[i] = begin;
                begin += 1;
            }
            if (m % 2 == 1) {
             for (int i = 0; i < m; i += 4) {

             }
            }
        }
    }
}
