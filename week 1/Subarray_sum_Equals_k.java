/*

Problem Title:
Subarray Sum Equals K

Context:
You are working as a data analyst for a fitness app. Every day, users log the number of 
calories burned. Your task is to find how many continuous days (subarrays) exist where the 
total calories burned equals a certain target k. This helps the app identify specific goal-based 
streaks.

Problem Statement:
Given an integer array nums representing the calories burned each day, and an integer k 
representing a target calorie goal, return the total number of continuous subarrays whose 
sum is exactly equal to k.

Input Format:
• An integer n — the number of days.
• An array nums of n integers — calories burned each day.
• An integer k — the target calorie burn.

Output Format:
• A single integer — the total number of continuous subarrays whose sum equals k.

Constraints:
• 1 <= nums.length <= 2 * 10^4
• -1000 <= nums[i] <= 1000
• -10^7 <= k <= 10^7

Example 1:
Input:
nums = [1, 2, 3]
k = 3
Output:
2
Explanation:
There are two subarrays that sum to 3:
• [1, 2]
• [3]

Example 2:
Input:
nums = [1, 1, 1]
k = 2
Output:
2
Explanation:
Subarrays [1,1] at indices (0,1) and (1,2) both sum to 2.
*/

import java.util.*;

public class Subarray_sum_Equals_k {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3}; 
        int k = 3;
        int count = subarraySum(nums, k);
        System.out.println(count);
    }
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;

            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }
}

// Leetcode 560

/*
class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);
        
        int currentSum = 0;
        int count = 0;
        
        for (int num : nums) {
            currentSum += num;
            
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }
}
    
*/

// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int cnt = 0;
//         for(int i = 0; i < nums.length; i++){
//             for(int j = i; j < nums.length; j++){
//                 int curr = 0;
//                 for(int m = i; m <= j; m++){
//                     curr += nums[m];
//                 }
//                 if(curr == k){
//                     cnt++;
//                 }
//             }
//         }
//         return cnt;
//     }
// }