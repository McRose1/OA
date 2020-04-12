package 美团;

/*  字符串排序
    用拼音表示之后按字母逆序排序，字母逆序指从 z 到 a 排序，比如对两个字符串排序时，先比较第一个字母按字母逆序排 z 在 a 的前面，
    当第一个字母一样时再比较第二个字母按字母逆序排，以此类推。
    特殊情况：1. 空字符串需排在最前面；2. 若一个短字符串是另一个长字符串的前缀则短字符串排在前面。
    请自行实现代码进行排序，直接调用 sort 等排序方法将不得分且视为作弊。

    输入描述：
    输入为一行，由多个字符串以英文逗号拼接而成，最多不超过 128 个字符串且可能有重复。
    每个字符串由小写字母 a-z 组成，可以为空，最长不超过 128 个字符。
    输出描述：
    输出一行，为排序之后的字符串，用逗号隔开。

    输入例子：
    waimai,dache,lvyou,liren,meishi,jiehun,lvyoujingdian,jiaopei,menpiao,jiudian

    输出例子：
    waimai,menpiao,meishi,lvyou,lvyoujingdian,liren,jiudian,jiehun,jiaopei,dache
 */

import java.util.Scanner;

public class 字符串排序 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String string = sc.nextLine();
        String[] strs = string.split(",");
        for(int i = 0; i < strs.length - 1; i++){
            for(int j = 0; j < strs.length - i - 1; j++){
                if(compareString(strs[j], strs[j + 1]) < 0){
                    String temp = strs[j];
                    strs[j] = strs[j + 1];
                    strs[j + 1] = temp;
                }
            }
        }
        for(int i = 0; i < strs.length - 1;i++){
            System.out.print(strs[i] + ",");
        }
        System.out.print(strs[strs.length - 1]);

    }
    public static int compareString(String str1, String str2){
        if(str1.equals("") && !str2.equals("")){
            return 1;
        }
        if(!str1.equals("") && str2.equals("")){
            return -1;
        }
        if(str1 != null && str2 != null && str2.indexOf(str1) == 0){
            return 1;
        }
        if(str1 != null && str2 != null && str1.indexOf(str2) == 0){
            return -1;
        }
        return str1.compareTo(str2);
    }
}
