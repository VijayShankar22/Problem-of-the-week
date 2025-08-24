/*
Problem Title: Flood Fill Algorithm  
Company Tag: Asked by Facebook  

Problem Scenario:  
You're given an image represented as a 2D matrix of characters, where each character  
represents a pixel color. You’re also given the coordinates of a pixel (row, col) and a new  
color C.  

Your task is to perform a flood fill operation starting from the given pixel:  
Change the color of the pixel and all connected pixels that have the same original color  
to the new color C. Pixels are connected 4-directionally (up, down, left, right — no diagonals).  

Input Format:  
• A 2D character matrix image[n][m] representing the image  
• Two integers sr and sc representing the row and column of the starting pixel  
• A character C representing the new color  

Output Format:  
• The updated image matrix after applying the flood fill algorithm.  

Example:  
Input:  
image = [  
['B', 'B', 'W'],  
['W', 'W', 'W'],  
['W', 'W', 'W'],  
['B', 'B', 'B']  
]  
sr = 2, sc = 2  
C = 'G'  

Output:  
[  
['B', 'B', 'G'],  
['G', 'G', 'G'],  
['G', 'G', 'G'],  
['B', 'B', 'B']  
]  

Explanation:  
The pixel at (2, 2) is originally 'W'.  
The flood fill algorithm changes all connected 'W' pixels (including itself) to 'G'.  
Only the 'W' pixels that are connected in four directions are changed. 'B' pixels are left unchanged.  

Constraints:  
• 1 <= rows, cols <= 100  
• C is an uppercase character  
• The original image contains only uppercase characters  
*/


public class flood_fill_algorithm {
    public static void main(String[] args) {
        // Example input
        char[][] image = {
            {'B', 'B', 'W'},
            {'W', 'W', 'W'},
            {'W', 'W', 'W'},
            {'B', 'B', 'B'}
        };
        int sr = 2, sc = 2;
        char newColor = 'G';
        char originalColor = image[sr][sc];
        
        if (originalColor != newColor) {
            floodFill(image, sr, sc, originalColor, newColor);
        }
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[0].length; j++) {
                System.out.print(image[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void floodFill(char[][] image, int row, int col, char originalColor, char newColor) {

        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length)
            return;

        if (image[row][col] != originalColor)
            return;
        image[row][col] = newColor;

        floodFill(image, row + 1, col, originalColor, newColor);
        floodFill(image, row - 1, col, originalColor, newColor);
        floodFill(image, row, col + 1, originalColor, newColor);
        floodFill(image, row, col - 1, originalColor, newColor);
    }
}

