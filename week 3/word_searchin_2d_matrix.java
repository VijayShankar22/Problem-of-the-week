/*

Problem of the Week – Word Search in 2D Matrix (Easy)

----------------------------------------------------
Problem Description:
----------------------------------------------------

Scenario:
In many document processing, word puzzles, and image processing systems, 
scanning a grid for a target pattern is a common task. You are given 
a 2D matrix of characters, and a target word. Your task is to check 
if the word exists in the matrix either:
  • Left-to-right (horizontally)
  • Top-to-bottom (vertically)

----------------------------------------------------
Input Format:
----------------------------------------------------
• A 2D character matrix of size M x N
• A string representing the target word

----------------------------------------------------
Output Format:
----------------------------------------------------
• Return true if the word exists in the matrix 
  (either row-wise left to right or column-wise top to bottom)
• Else return false

----------------------------------------------------
Constraints:
----------------------------------------------------
• 1 ≤ M, N ≤ 100
• Word length ≤ max(M, N)
• All characters are uppercase English letters

----------------------------------------------------
Example Input:
----------------------------------------------------
matrix = [ 
  ['F', 'A', 'C', 'I'], 
  ['O', 'B', 'Q', 'P'], 
  ['A', 'N', 'O', 'B'], 
  ['M', 'A', 'S', 'S'] 
] 
word = "FOAM"

----------------------------------------------------
Example Output:
----------------------------------------------------
True

----------------------------------------------------
Explanation:
----------------------------------------------------
• "FOAM" appears in the first column: F → O → A → M (top to bottom) 
• "MASS" appears in the last row: M → A → S → S (left to right)
*/


public class word_searchin_2d_matrix {
    public static void main(String[] args) {
        char[][] matrix = {
            {'F', 'A', 'C', 'I'},
            {'O', 'B', 'Q', 'P'},
            {'A', 'N', 'O', 'B'},
            {'M', 'A', 'S', 'S'}
        };
        String word = "FOAM";

        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean found = false;

        for (int i = 0; i < rows; i++) {
            StringBuilder rowString = new StringBuilder();
            for (int j = 0; j < cols; j++) {
                rowString.append(matrix[i][j]);
            }
            if (rowString.toString().contains(word)) {
                found = true;
                break;
            }
        }
        if (!found) {
            for (int j = 0; j < cols; j++) {
                StringBuilder colString = new StringBuilder();
                for (int i = 0; i < rows; i++) {
                    colString.append(matrix[i][j]);
                }
                if (colString.toString().contains(word)) {
                    found = true;
                    break;
                }
            }
        }
        System.out.println(found);
    }
}

