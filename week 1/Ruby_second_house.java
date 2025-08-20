/*

Problem: Ruby Second House (Medium)

Description:
You are a construction manager overseeing the painting of a long row of houses.  
Each house must be painted one of several available colors.  
However, adjacent houses cannot have the same color to preserve aesthetic appeal.  

Each painting option has a different cost.  
You are given a matrix where costs[i][j] represents the cost of painting house i with color j.  

Your task:
Paint all houses such that:
  • No two adjacent houses share the same color.  
  • The total painting cost is minimized.  

Input Format:
• First line: Two integers n and k — the number of houses and the number of colors.  
• Next n lines: Each line contains k space-separated integers, the painting costs for that house using each color.  

Output Format:
• A single integer — the minimum total cost to paint all the houses such that no two adjacent houses have the same color.  

Constraints:
• 1 <= n <= 100  
• 2 <= k <= 20  
• 1 <= costs[i][j] <= 20  

Example:
Input:
2 3
1 5 3
2 9 4

Output:
5

Explanation:
There are two optimal solutions:
• Paint house 0 with color 0 (cost = 1), house 1 with color 2 (cost = 4) → total = 1 + 4 = 5  
• Paint house 0 with color 2 (cost = 3), house 1 with color 0 (cost = 2) → total = 3 + 2 = 5  

*/



public class Ruby_second_house {
    public static void main(String[] args){
        int [][] cost = { {1,5,3},{2,9,4} };
        int n = 2;
        int k = 3;
        int ans = solve(cost, n, k, 0, -1);
        System.out.println("min cost = "+ ans);
    }

    static int solve(int [][]cost, int n , int k, int house, int prevcolour){
        if(house == n){
            return 0;
        }
        int mincost = Integer.MAX_VALUE;

        for(int i = 0; i < k; i++){
            if(i != prevcolour){
                int currcost = cost[house][i] + solve(cost, n , k, house + 1, i);
                mincost = Math.min(mincost, currcost);
            }
        }
        return mincost;
    }
}
