/*
Problem of the Week – Longest Common Subsequence of Three Strings

Scenario:
In many real-world applications like version control, spell checking, 
or DNA sequencing, comparing multiple strings and identifying 
common patterns is crucial. 

In this challenge, you're given three strings, and you need to compute 
the length of the Longest Common Subsequence (LCS) that is present 
in all three strings.

Definition:
A subsequence is a sequence that appears in the same relative order, 
but not necessarily contiguous. 
For example:
In "abcde" and "ace", "ace" is a subsequence.

Goal:
Implement an efficient algorithm that returns the length of the 
longest subsequence common to all three strings.

-------------------------------------------------
Input Format:
-------------------------------------------------
• Three lines of input, each containing one string:
   - S1 (string 1)
   - S2 (string 2)
   - S3 (string 3)

-------------------------------------------------
Output Format:
-------------------------------------------------
• A single integer representing the length of the longest 
  common subsequence among the three strings.

-------------------------------------------------
Constraints:
-------------------------------------------------
• 1 ≤ |S1|, |S2|, |S3| ≤ 100  
• Strings may contain lowercase or uppercase English letters

-------------------------------------------------
Example:
-------------------------------------------------
Input:
epidemiologist
refrigeration
supercalifragilisticexpialodocious

Output:
5

Explanation:
The longest common subsequence among the three input strings is:
"eieio"
So, the output is 5.

*/

public class Longest_common_subsequence {
    public static int LCSof3(String s1, String s2, String s3) {
        int n1 = s1.length();
        int n2 = s2.length();
        int n3 = s3.length();

        int[][][] dp = new int[n1 + 1][n2 + 1][n3 + 1];
        
        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                for (int k = 1; k <= n3; k++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1) && s2.charAt(j - 1) == s3.charAt(k - 1)) {
                        dp[i][j][k] = 1 + dp[i - 1][j - 1][k - 1];
                    } else {
                        dp[i][j][k] = Math.max(
                            dp[i - 1][j][k],
                            Math.max(dp[i][j - 1][k], dp[i][j][k - 1])
                        );
                    }
                }
            }
        }
        return dp[n1][n2][n3];
    }
    
    public static void main(String[] args) {
        String s1 = "epidemiologist";
        String s2 = "refrigeration";
        String s3 = "supercalifragilisticexpialodocious";
        
        System.out.println(LCSof3(s1, s2, s3));
    }
}

// Leetcode 1143

/*
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

*/

