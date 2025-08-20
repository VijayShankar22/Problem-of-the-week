/*

Problem Title: Count Friend Groups (Asked by Twitter)

Problem Statement:
You are given a classroom of N students. Students can be friends with one another, 
and this friendship relationship is mutual (i.e., if A is a friend of B, 
then B is also a friend of A).

We are given these relationships as an adjacency list, where each key is a student 
and the values are the list of students they are directly friends with.

A friend group is defined as a set of students where every student is connected 
(directly or indirectly) to every other student in that set. 
In graph terms, we want to find the number of connected components 
in an undirected graph (students = nodes, friendships = edges).

Your task is to count the total number of friend groups.

Input Format:
- An integer N, the total number of students (IDs from 0 to N-1)
- A dictionary "friendship" where:
  Key = student ID
  Value = list of friend student IDs

Output Format:
- An integer: total number of friend groups in the class

----------------------------------------------------------------
Examples:

Example 1:
Input:
N = 7
friendship = {
  0: [1, 2],
  1: [0, 5],
  2: [0],
  3: [6],
  4: [],
  5: [1],
  6: [3]
}
Output: 3

Explanation:
Group 1: {0, 1, 2, 5}
Group 2: {3, 6}
Group 3: {4}

---------------------------------------------------------------

Example 2:
Input:
N = 5
friendship = {
  0: [1],
  1: [0, 2],
  2: [1],
  3: [4],
  4: [3]
}
Output: 2

Explanation:
Group 1: {0, 1, 2}
Group 2: {3, 4}
*/

import java.util.*;

public class count_friend_groups {
    public static void main(String[] args) {
        int N = 7;
        Map<Integer, List<Integer>> friendship = new HashMap<>();
        friendship.put(0, Arrays.asList(1, 2));
        friendship.put(1, Arrays.asList(0, 5));
        friendship.put(2, Arrays.asList(0));
        friendship.put(3, Arrays.asList(6));
        friendship.put(4, Arrays.asList());
        friendship.put(5, Arrays.asList(1));
        friendship.put(6, Arrays.asList(3));

        boolean[] visited = new boolean[N];
        int groups = 0;

        for (int i = 0; i < N; i++) {
            if (!visited[i]) {
                groups++;

                Stack<Integer> stack = new Stack<>();
                stack.push(i);
                visited[i] = true;

                while (!stack.isEmpty()) {
                    int node = stack.pop();
                    for (int friend : friendship.getOrDefault(node, new ArrayList<>())) {
                        if (!visited[friend]) {
                            visited[friend] = true;
                            stack.push(friend);
                        }
                    }
                }
            }
        }
        System.out.println(groups);
    }
}
