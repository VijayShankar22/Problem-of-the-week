/*
Problem: Minimum in Sorted Rotated Array

Imagine you're working on an update system for a fleet of 
autonomous vehicles at Uber. The system stores updates in a 
sorted array for efficiency, but due to unexpected reboots, 
the array sometimes gets rotated at a pivot point. 

Your task is to quickly identify the first version 
(the minimum value) after a rotation.

------------------------------------------------------------
Problem Statement:
Given an array that was initially sorted in ascending order 
but then rotated at an unknown pivot, write an efficient 
algorithm to find the minimum element in the array.

Conditions:
- The array contains no duplicate elements.
- Your solution must run in O(log N) time.

------------------------------------------------------------
Input Format:
- A single integer N denoting the number of elements in the array.
- A line containing N space-separated integers, representing 
  the rotated sorted array.

Output Format:
- Print a single integer — the minimum element in the rotated array.

------------------------------------------------------------
Constraints:
1 <= N <= 10^5
-10^9 <= A[i] <= 10^9
No duplicate elements.
The array is a rotated version of a sorted array.

------------------------------------------------------------
Example 1:
Input:
5
5 7 10 3 4

Output:
3

Explanation:
The original array before rotation might have been [3, 4, 5, 7, 10]. 
After rotation, it becomes [5, 7, 10, 3, 4]. 
The minimum element is 3.

------------------------------------------------------------
*/


public class Min_in_Sort_rotated_Array {
    public static void main(String[] args) {

        int[] nums = {5, 7, 10, 3, 4};
        int N = nums.length;

        int left = 0, right = N - 1;
        while (left < right) {
            int mid = (left + right) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        System.out.println(nums[left]);
    }
}

// leetcode 153

/*
class Solution {
    public int findMin(int[] nums) {
        int n = nums.length;
        int left  = 0; int right = n-1;

        while(left < right){
            int mid = (left + right) / 2;

            if(nums[mid] > nums[right]){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        return nums[left];
    }
}
*/
