import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
"pwke" is a subsequence and not a substring.
 */
public class Leet03LongestSubstring {

    /*
    abcad
    a left = 1 right = 0 result = 1
    ab       2         0          2
    acc      3         0          3
    bc       3         1          3
    c        3         2          3
             3         3          3
    a        4         3          3
    ad       5         3          3
    Time O(2n)
     */
    public int lengthOfLongestSubstring(String s){
        int n = s.length();
        int result = 0;
        int left = 0;
        int right = 0;
        Set<Character> hashSet = new HashSet<>();
        while (left < n && right < n) {
            if (!hashSet.contains(s.charAt(left))) {
                hashSet.add(s.charAt(left++));
                result = Math.max(result, left - right);
            }
            else {
                hashSet.remove(s.charAt(right++));
            }
        }
        return result;
    }
    /*
     abcad
     a  i = 0 result = 1
     ab i = 0 result = 2 
     */
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int result = 0;
        Map<Character, Integer> hashMap = new HashMap<>();
        for (int i= 0, j = 0; j < n; j++) {
            if (hashMap.containsKey(s.charAt(j))) {
                i = Math.max(hashMap.get(s.charAt(j)), i);
            }
            result = Math.max(result, j - i + 1);
            hashMap.put(s.charAt(j), j + 1);   //j + 1 vs j++
        }
        return result;
    }
}
