package 携程;

/*  查询满足区间的记录
    有一批订单记录，数据有订单号，入店时间，离店时间；
    输入一个时间值A，需要在这批记录中找到符合入离店时间范围（A大于等于入店时间，并且A小于等于离店时间）内的所有记录。
    单次查询时间复杂度控制在O(logN)
    ※注意：订单号升序输出

    输入例子 1：
    10
    20180602
    1001 20180103 20180105
    1002 20180202 20180203
    1003 20180304 20180306
    1004 20180401 20180408
    1005 20180501 20180504
    1006 20180601 20180604
    1007 20180705 20180706
    1008 20180801 20180804
    1009 20180903 20180903
    1010 20181003 20181003

    输出例子 1：
    1006

    输入例子 2：
    5
    20170103
    1013 20180103 20180105
    1022 20180102 20180103
    1103 20180104 20180106
    1034 20180101 20180102
    1105 20180201 20180204

    输出例子 2：
    null

    输入例子 3：
    4
    20180103
    1013 20180103 20180105
    1022 20180102 20180103
    1026 20180103 20180103
    1007 20180101 20180109

    输出例子 3：
    1007
    1013
    1022
    1026
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class 查询满足区间的记录 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = sc.nextInt();
        int target = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        // 用二维数组来存输入信息
        int[][] data = new int[count][3];
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 3; j++) {
                data[i][j] = sc.nextInt();
            }
            // 边存边判断，符合条件的存入 list 中
            if (data[i][1] <= target && data[i][2] >= target) {
                list.add(data[i][0]);
            }
        }
        if (list.size() == 0) {
            System.out.println("null");
            return;
        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }
}
