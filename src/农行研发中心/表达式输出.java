package 农行研发中心;

public class 表达式输出 {
    public static void main(String[] args) {
        String expr = "10+23-5";
        boolean add = true;
        int res = 0;
        int idx = 0;
        while (idx < expr.length()) {
            char c = expr.charAt(idx);
            if (c == '+') {
                add = true;
                idx++;
            } else if (c == '-') {
                add = false;
                idx++;
            } else {
                int start = idx;
                while (idx < expr.length() && Character.isDigit(expr.charAt(idx))) {
                    idx++;
                }
                int temp = Integer.parseInt(expr.substring(start, idx));
                if (add) {
                    res += temp;
                } else {
                    res -= temp;
                }
            }
        }
        System.out.print(res);
    }
}
