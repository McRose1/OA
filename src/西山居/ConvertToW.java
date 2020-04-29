package 西山居;

/*  LC 6 变形题
    输入：字符串 abcdefghijklmnopqr，row = 4
    a     g     m
     b   f h   l n   r
      c e   i k   o q
       d     j     p
    输出：agmbfhlnrceikoqdjp
 */

import java.util.ArrayList;
import java.util.List;

public class ConvertToW {
    public static void main(String[] args) {
        String s = "abcdefghijklmnopqr";
        int row = 4;
        String res = convert(s, row);
        System.out.println(res);
    }

    private static String convert(String s, int row) {
        if (row == 1) return s;

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(row, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            // 遍历到两端
            if (curRow == 0 || curRow == row - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder r : rows) {
            ret.append(r);
        }
        return ret.toString();
    }
}
