package 小米;

/*  懂二进制
    世界上有10种人，一种懂二进制，一种不懂。那么你知道两个int32整数m和n的二进制表达，有多少个位(bit)不同么？

    输入
    1999 2299
    输出
    7
 */

public class 懂二进制 {

    /**
     * 获得两个整形二进制表达位数不同的数量
     *
     * @param m 整数m
     * @param n 整数n
     * @return 整型
     */
    public int countBitDiff(int m, int n) {
        int diff = m ^ n;
        return Integer.bitCount(diff);
    }
}
