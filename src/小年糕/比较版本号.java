package 小年糕;

/*  比较版本号
    请实现一个比较版本号大小的函数，比如 1.2.3 和 1.2.4，后者的版本号更大。

    输入：
    "1.2.3","1.2.4"

    输出：
    -1

    备注：
    版本号由数字和.组成
 */

public class 比较版本号 {
    /**
     * 返回两个版本号的比较结果，返回 0 表示 v1 = v2，1 表示 v1 > v2，-1 表示 v1 < v2
     * @param v1 string字符串 版本号
     * @param v2 string字符串 版本号
     * @return int整型
     */
    public int compareVersion(String v1, String v2) {
        String[] version1 = v1.split("\\.");
        String[] version2 = v2.split("\\.");

        int len1 = version1.length;
        int len2 = version2.length;

        if (len1 == 0) {
            return -1;
        }

        if (len2 == 0) {
            return 1;
        }

        int i = 0;
        while (i < len1 && i < len2) {
            if (Integer.parseInt(version1[i]) > Integer.parseInt(version2[i])) {
                return 1;
            } else if (Integer.parseInt(version1[i]) < Integer.parseInt(version2[i])) {
                return -1;
            } else {
                i++;
            }
        }
        if (i == len1 && i == len2) {
            return 0;
        } else if (i == len1) {
            return -1;
        } else {
            return 1;
        }
    }
}
