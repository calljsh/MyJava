public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
    }
}
class Solution {
    public boolean isPalindrome(int x) {
        // 负数不是回文数
        if (x < 0) return false;

        // 将整数转换为字符串
        String str1 = Integer.toString(x);
        int left = 0;
        int right = str1.length() - 1;
        // 用双指针法检查是否为回文
        while (left < right) {
            if (str1.charAt(left) != str1.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
