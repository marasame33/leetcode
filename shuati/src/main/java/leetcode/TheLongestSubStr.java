package leetcode;

import java.util.HashSet;
import java.util.Set;

public class TheLongestSubStr {

    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int res = 0;
        Set<Character> sets = new HashSet<>();
        int rk = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0) {
                sets.remove(s.charAt(i-1));
            }
            while (rk < n && !sets.contains(s.charAt(rk))) {
                sets.add(s.charAt(rk));
                res = Math.max(res, rk - i + 1);
                rk++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
