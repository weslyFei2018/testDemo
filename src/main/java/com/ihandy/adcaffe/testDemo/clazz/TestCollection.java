package com.ihandy.adcaffe.testDemo.clazz;


import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TestCollection {
    private static final int _1M = 1024 * 1024;
    public static void main(String[] args){
       //String s ="abcabcbb";
//       String s ="powwkew";
//       int ans = lengthOfLongestSubstring(s);
//       System.out.println(ans);

    }



    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<Character>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

}
