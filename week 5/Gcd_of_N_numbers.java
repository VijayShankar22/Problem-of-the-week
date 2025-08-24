/*
Problem Title: Find the Greatest Common Divisor (GCD) of N Numbers  

Company: Amazon  

Scenario:  
In large-scale systems, finding a common pattern or factor among multiple datasets is often required for optimization.  
Similarly, in number theory, the Greatest Common Divisor (GCD) helps determine the largest number that divides a set of numbers without leaving a remainder.  

Your task is to compute the GCD of n integers efficiently.  

Problem Statement:  
Given n numbers, find the greatest common denominator between them.  

Example:  
Input: [42, 56, 14]  
Output: 14  

Input Format:  
• First line: integer n (number of integers).  
• Second line: n integers separated by space.  

Output Format:  
• A single integer representing the GCD of the given numbers.  

Example 1:  
Input:  
3  
42 56 14  

Output:  
14  

Explanation:  
• Factors of 42 → {1, 2, 3, 6, 7, 14, 21, 42}  
• Factors of 56 → {1, 2, 4, 7, 8, 14, 28, 56}  
• Factors of 14 → {1, 2, 7, 14}  
• Greatest common factor = 14  

Example 2:  
Input:  
4  
8 16 32 64  

Output:  
8  

Constraints:  
• 1 ≤ n ≤ 10^5  
• 1 ≤ arr[i] ≤ 10^9  

Approach Hints:  
• Use the Euclidean Algorithm for efficiency:  
  - gcd(a, b) = gcd(b, a % b)  
  - Extend to n numbers by iteratively applying gcd(result, arr[i]).  

• Time Complexity: O(n log M), where M is the largest number.  
*/

import java.util.*;

public class Gcd_of_N_numbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int gcd = arr[0];
        for (int i = 1; i < n; i++) {
            gcd = findGCD(gcd, arr[i]);
        }
        System.out.println(gcd);
        sc.close();
    }
    private static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

