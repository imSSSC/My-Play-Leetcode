package T17LetterCombinationsOfAPhoneNumber;

import java.util.*;

// 17. 电话号码的字母组合
// https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
//
// 时间复杂度: 3^n  =  O(2^n)
// 空间复杂度: ？
// 排序+双指针
public class Solution1 {

    List<String> result = new ArrayList<>();

    Map<Integer, String> letterMap = new HashMap<Integer, String>() {
        {
            put(0, " ");
            put(1, "");
            put(2, "abc");
            put(3, "def");
            put(4, "ghi");
            put(5, "jkl");
            put(6, "mno");
            put(7, "pqrs");
            put(8, "tuv");
            put(9, "wxyz");
        }
    };

    void findCombination(String digits, int index, String s) {

        if (index == digits.length()) {
            result.add(s);
            return;
        }
        int c = Integer.parseInt(String.valueOf(digits.charAt(index)));
        String letters = letterMap.get(c);
        char[] chars = letters.toCharArray();
        for (char aChar : chars) {
            findCombination(digits, index + 1, s + aChar);
        }
    }

    public List<String> letterCombinations(String digits) {
        if (digits.equals(""))
            return result;
        findCombination(digits, 0, "");
        return result;
    }

    public static void main(String[] args) {
        String digits = "23";
        System.out.println((new Solution1().letterCombinations(digits)));
    }
}
