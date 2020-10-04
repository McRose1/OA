package 竞技世界;

/*  intReplace
    1. 如果 n 是偶数，则用 n/2 替换 n
    2. 如果 n 是奇数，则可以用 n+1 或 n-1 替换 n
    n 变为 1 所需的最小替换次数是多少？

    输入：
    8
    输出：
    3
    解释：
    8 -> 4 -> 2 -> 1

    输入：
    7
    输出：
    4
    解释：
    7 -> 8 -> 4 -> 2 -> 1
 */

/*  找规律
    如果 n 是偶数，则用 n/2 替换。当 n 为 2 的幂时，降幂是最快的选择
    如果 n 是奇数，则可以用 n+1 或 n-1 替换。n+1 或 n-1 谁是 2 的幂次方，优先选择
    如果都不是，那么去判断 n+1 或 n-1 除以 2 之后是否是偶数，如果是偶数，则优先选择，因为奇数比偶数多一步处理，如果 2 个都是偶数，则选择 n-1
 */
public class intReplace {
    public long intReplace(long n) {
        if (n == 0 || n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int count = 0;
        while (n != 0 && n != 1) {
            // 如果是奇数
            if (n % 2 == 1) {
                // 分别判断是否为 2 的幂
                if (isPower2(n - 1)) {
                    n = n - 1;
                    count++;
                    continue;
                }
                if (isPower2(n + 1)) {
                    n = n + 1;
                    count++;
                    continue;
                }
                // 如果都不是 2 的幂
                n = select(n);
                count++;
            }
            count++;
            n /= 2;
        }
        return count;
    }

    private static long select(long n) {
        if (n == 3) {
            n = n - 1;
        }
        boolean flag1 = false;
        boolean flag2 = false;

        long temp;
        temp = (n - 1) / 2;
        if (temp % 2 == 0) {
            flag1 = true;
        }
        temp = (n + 1) / 2;
        if (temp % 2 == 0) {
            flag2 = true;
        }
        if (flag1) {
            n = n - 1;
            return n;
        }
        if (flag2) {
            n = n + 1;
            return n;
        }
        return n;
    }

    private boolean isPower2(long n) {
        if (n <= 0) {
            return false;
        }
        for (int i = 0; i <= 32; i++) {
            if (n == 2 << i) {
                return true;
            }
        }
        return false;
    }
}
