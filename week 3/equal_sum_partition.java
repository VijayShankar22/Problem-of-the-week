/*
Problem Title: Equal Sum Partition

Problem Statement:
You are given a multiset (a list that can have duplicate integers).
Determine whether it can be partitioned into two subsets such that
the sum of elements in both subsets is equal.

Description:
This challenge is a variation of the Subset Sum Problem and is
commonly known as the Partition Equal Subset Sum problem.
You need to check if the given array can be split into two subsets
A and B such that:
    sum(A) == sum(B)

Input Format:
- A list of integers (may contain duplicates).
- The list may contain up to 100 elements.

Output Format:
- Return true if the set can be partitioned into two subsets with
  equal sum, else return false.

Constraints:
- All numbers are non-negative integers.
- At least one number exists in the input.

Hints:
- If the total sum is odd, it cannot be split evenly.
- Use Dynamic Programming or recursion + memoization.

Examples:

Example 1:
Input:  [15, 5, 20, 10, 35, 15, 10]
Output: true
Explanation:
- Subset 1: [15, 5, 10, 15, 10] → Sum = 55
- Subset 2: [20, 35] → Sum = 55

Example 2:
Input: [15, 5, 20, 10, 35]
Output: false
Explanation:
- Total sum = 85 → Cannot be equally split into two parts.

*/

import java.util.*;

public class equal_sum_partition {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        int total = 0;
        for (int x : nums) total += x;

        if (total % 2 != 0) {
            System.out.println(false);
            return;
        }
        int target = total / 2;

        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for (int num : nums) {
            for (int j = target; j >= num; j--) {
                if (dp[j - num]) dp[j] = true;
            }
        }
        System.out.println(dp[target]);
    }
}
