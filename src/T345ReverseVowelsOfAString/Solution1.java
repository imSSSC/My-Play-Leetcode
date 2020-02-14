package T345ReverseVowelsOfAString;

// 345. 反转字符串中的元音字母
// https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
//
// 对撞指针
// 时间复杂度: O(n)
// 空间复杂度: O(1)
public class Solution1 {

    public String reverseVowels(String s) {

        char[] chars = s.toCharArray();
        int l = 0, r = chars.length - 1;
        while (l < r) {
            while (l < r && !isVowel(chars[l])) l++;
            while (l < r && !isVowel(chars[r])) r--;
            char t = chars[l];
            chars[l++] = chars[r];
            chars[r--] = t;
        }

        return new String(chars);
    }

    public boolean isVowel(char s) {
        return s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u' || s == 'A' || s == 'E' || s == 'I' || s == 'O' || s == 'U';
    }

    public static void main(String[] args) {
        System.out.println(new Solution1().reverseVowels("leetcode"));
    }
}
