package 映客;

public class 回文串 {
    public boolean isHuiWen (String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            } else {
                break;
            }
        }
        return left >= right;
    }
}
