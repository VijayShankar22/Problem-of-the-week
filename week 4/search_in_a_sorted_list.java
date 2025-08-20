/*

Problem Title: Search in a Sorted List Without Multiplication, Division, or Bit-Shifts 

Scenario:  
You are working on a constrained system where certain operations (multiplication, division,  
and bit-shifting) are not allowed due to hardware limitations. However, you still need to  
efficiently search for a given element x in a sorted list of integers.  

Your task is to determine if the element exists in the list in O(log N) time.  

Problem Statement:  
Given:  
• A sorted list of integers arr of length N.  
• A target value x.  
Return true if x exists in the list, otherwise return false.  

You cannot use multiplication (*), division (/), or bit-shift (<<, >>) operations.  

Input Format:  
• First line: integer N (size of the list).  
• Second line: N integers (sorted in ascending order).  
• Third line: integer x (target value).  

Output Format:  
• true if x is found, otherwise false.  

Example 1:  
Input:  
N = 7  
arr = [-5, -2, 0, 3, 7, 10, 15]  
x = 7  
Output:  
true  

Example 2:  
Input:  
N = 5  
arr = [1, 2, 4, 8, 16]  
x = 3  
Output:  
false  

*/

import java.util.*;

public class search_in_a_sorted_list {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        int x = sc.nextInt();
        
        int low = 0; 
        int high = N - 1;
        boolean found = false;

        while (low <= high) {
            int l = low, h = high;
            while (l < h) {
                l++;
                h--;
            }
            int mid = l;
            
            if (arr[mid] == x) {
                found = true;
                break;
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        if (found) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }

    }
}
