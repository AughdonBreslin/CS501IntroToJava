package SetsAndMaps_15;

import java.util.Set;
import java.util.HashSet;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 3/29/2025, Saturday
 **/
public class LongestUniqueSubstring {
    int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0, left = 0;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            while (set.contains(c)) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(c);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
    public static void main(String[] args) {
        String s = "abcabcbb";
        LongestUniqueSubstring solution = new LongestUniqueSubstring();

    }
}
