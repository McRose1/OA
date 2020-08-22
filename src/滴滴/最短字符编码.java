package 滴滴;

/*  最短字符编码
    给定一个非空字符串，按照如下方式编码，使得编码后长度最小，返回编码后的长度：
    编码规则为：k[encoding_string]，表示重复 k 次 encoding_string，
    例如 'abcdefabcdefabc' 可表示为 '2[abcdef]abc'，但是 'aaa' 仅能编码成 'aaa'，因为 len('3[a]') > len('aaa')。
    补充：
    1. k 为正整数，[] 内的 encoding_string 不得含有空格，不得为空；
    2. [] 内的 encoding_string 本身可以为编码过的字符串，例如 'abcdabcdeabcdabcde' 可以编码为 '2[abcdabcde]'（编码后长度从 18 减少到 12），
       [] 内的 'abcdabcde' 又可以编码为 '2[abcd]e'，最终编码为 '2[2[abcd]e]'，编码后长度为 11，营范围 11；这个编码路径也能是：
       'abcdabcdeabcdabcde' -> '2[abcd]e2[abcd]e' -> '2[2[abcd]e]';
    3. 输入字符串为全小写英文字母，长度 <= 160；
    4. 如果编码后长度没有更小，则保留原有字符串。

    输入描述:
    一行数据, 表示输入字符串
    输出描述:
    输出一个字符串表示编码后长度

    示例 1：
    输入：
    aaa
    输出：
    3
    说明：
    aaa，长度 3

    示例 2：
    输入：
    aaaaa
    输出：
    4
    说明：
    5[a]，长度 4

    示例 3：
    输入：
    aabcaabcd
    输出：
    8
    说明：
    2[aabc]d，长度8
 */

import java.util.Scanner;

public class 最短字符编码 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(helper(s).length());
    }

    private static String helper(String s) {
        if(s.length() <= 4) return s;
        int len = s.length();
        int rptLen = len>>1; // 当前尝试的重复的长度
        int bestRptTime = 0;
        int bestCompressLen = len;
        String seg1 = "", seg2 = "", seg3 = "";
        while(rptLen >= 1){
            for(int k = 0; k <= len - (rptLen<<1); k++){ // 从k位置开始寻找，至少留两段
                int count = 1;
                String s2 = s.substring(k,k+rptLen);
                for(int j = 1; k+j*rptLen+rptLen <= len; j++){ // 判断最多重复几次
                    String s3 = s.substring(k+j*rptLen, k+(j+1)*rptLen);
                    if(s2.equals(s3)) count++;
                    else break;
                }
                int newLen = len-count*rptLen+3+rptLen;
                if(newLen < len && newLen < bestCompressLen){ // 新长度合适
                    bestCompressLen = newLen;
                    bestRptTime = count;
                    seg1 = s.substring(0,k);
                    seg2 = s.substring(k,k+rptLen);
                    seg3 = s.substring(k+count*rptLen);
                }
            }
            rptLen--;
        }
        if(bestRptTime == 0) return s;
        return helper(seg1)+bestRptTime+"["+helper(seg2)+"]"+helper(seg3);
    }
}
