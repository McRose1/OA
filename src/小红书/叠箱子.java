package 小红书;

/*  叠箱子
    有多个长方体的箱子需要叠放起来，使得叠放的高度最大。叠放的原则是上面箱子的接触面严格小于下面箱子的接触面。
    叠放时箱子可以改变方向。

    例如，边长为1，3，6的箱子，可以放在1，2，7的箱子上，接触的面是1，3和2，7，总高度是7；
    1，2，7的箱子也可以叠放在1，3，6的箱子上，接触面是1，2和3，6，总高度是8。

    每个盒子在叠放时可以使用多次，但是每次都必须以一个不同的方向（所以最多只能使用3次，分别是三个方向）。

    输入描述
    第一行是一个数字N，表示后面有N个长方体，接下来是N行，每行3个正整数，分别表示长方体的三个边长。可能有M个这样的输入。

    0<N<10000

    0<M<10000

    输出描述
    输出M个整数，分别表示得到的M个最大高度。

    样例输入
    4
    4 2 5
    3 1 6
    3 2 1
    6 3 9
    3
    4 5 6
    3 1 6
    3 2 1
    样例输出
    23
    12

    提示
    第一个样例中可以如下叠放（最后一列是高度）：
    3，1，6
    4，2，5
    6，3，9
    9，6，3
    总高度6+5+9+3=23
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*  (20%)

 */
public class 叠箱子 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int N = sc.nextInt();
            List<int[]> box = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                int c = sc.nextInt();
                int[] temp1 = new int[]{a, b, c};
                int[] temp2 = new int[]{a, c, b};
                int[] temp3 = new int[]{b, c, a};
                box.add(temp1);
                box.add(temp2);
                box.add(temp3);
            }
            box.sort((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
            box.sort((a, b) -> a[1] == b[1] ? b[2] - a[2] : a[1] - b[1]);

            int height = box.get(1)[2];
            for (int i = 1; i < box.size(); i++) {
                if (box.get(i)[0] < box.get(i - 1)[0] && box.get(i)[1] < box.get(i - 1)[1]) {
                    height += box.get(i)[2];
                }
            }
            System.out.println(height);
        }
    }
}
