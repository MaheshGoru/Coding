/*

You're given a two-dimensional array (a matrix) of potentially unequal height
and width containing only 0s and 1s. The matrix
represents a two-toned image, where each 1 represents black and
each 0 represents white. An island is defined as any number of
1s that are horizontally or vertically adjacent (but not
diagonally adjacent) and that don't touch the border of the image. In other
words, a group of horizontally or vertically adjacent 1s isn't an
island if any of those 1s are in the first row, last row, first
column, or last column of the input matrix.

Note that an island can twist. In other words, it doesn't have to be a
straight vertical line or a straight horizontal line; it can be L-shaped, for
example.

You can think of islands as patches of black that don't touch the border of
the two-toned image.

Write a function that returns a modified version of the input matrix, where
all of the islands are removed. You remove an island by replacing it with
0s.
Naturally, you're allowed to mutate the input matrix.
Sample Input
matrix =
[
[1, 0, 0, 0, 0, 0],
[0, 1, 0, 1, 1, 1],
[0, 0, 1, 0, 1, 0],
[1, 1, 0, 0, 1, 0],
[1, 0, 1, 1, 0, 0],
[1, 0, 0, 0, 0, 1],
]
Sample Output
[
[1, 0, 0, 0, 0, 0],
[0, 0, 0, 1, 1, 1],
[0, 0, 0, 0, 1, 0],
[1, 1, 0, 0, 1, 0],
[1, 0, 0, 0, 0, 0],
[1, 0, 0, 0, 0, 1],
]

// The islands that were removed can be clearly seen here:
// [
//   [ ,  ,  ,  ,  , ],
//   [ , 1,  ,  ,  , ],
//   [ ,  , 1,  ,  , ],
//   [ ,  ,  ,  ,  , ],
//   [ ,  , 1, 1,  , ],
//   [ ,  ,  ,  ,  , ],
// ]
*/
import java.util.*;
class RemoveIslands{
    public static void main(String args[]){
        int[][] matrix = {{1,0,0,0,0,0},{0,1,0,1,1,1},{0,0,1,0,1,0},{1,1,0,0,1,0},{1,0,1,1,0,0},{1,0,0,0,0,1}};
        int[][] updated = removeIslands(matrix);
        for(int i=0;i<updated.length;i++){
            for(int j=0;j<updated[i].length;j++){
                System.out.print(updated[i][j]+" ");
            }
            System.out.println();
        }
    }

    // O(n^4) Time Complexity | O(n^2) Space Complexity
    public static int[][] removeIslands1(int[][] matrix){
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int[][] updatedMatrix = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                updatedMatrix[i][j] = matrix[i][j];
            }
        }
        for(int i=1;i<matrix.length-1;i++){
            for(int j=1;j<matrix[i].length-1;j++){
                if(matrix[i][j] == 1){
                    boolean canReach = isReachedFromBoarders(matrix, i, j, visited);
                    if(!canReach) updatedMatrix[i][j] = 0;
                    for(int k=0;k<matrix.length;k++){
                        for(int l=0;l<matrix[k].length;l++)
                            visited[k][l] = false;
                    }
                }
            }
        }
        return updatedMatrix;
    }

    public static boolean isReachedFromBoarders(int[][] matrix, int i, int j,boolean[][] visited){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length)
            return false;
        if(visited[i][j] == true)
            return false;
        if(matrix[i][j] == 0)
            return false;
        if(i == 0 || i == matrix.length-1 || j == 0 || j == matrix[i].length-1)
            return true;
        visited[i][j] = true;
        return isReachedFromBoarders(matrix, i-1, j, visited) ||
                isReachedFromBoarders(matrix, i , j-1, visited) ||
                isReachedFromBoarders(matrix, i, j+1, visited) ||
                isReachedFromBoarders(matrix, i+1, j, visited);
    }

    // O(n^2) Time Complexity | O(n^2) Space Complexity
    public static int[][] removeIslands(int[][] matrix){
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for(int i=1;i<matrix.length-1;i++){
            updateMatrix(matrix, i, 0, visited);
            updateMatrix(matrix, i, matrix[i].length-1, visited);
        }
        for(int j=1;j<matrix[0].length-1;j++){
            updateMatrix(matrix, 0, j, visited);
            updateMatrix(matrix, matrix.length-1, j, visited);
        }
        for(int i=1;i<matrix.length-1;i++){
            for(int j=1;j<matrix[i].length-1;j++){
                if(matrix[i][j] == 1 && !visited[i][j])
                    matrix[i][j] = 0;
            }
        }
        return matrix;
    }

    public static void updateMatrix(int[][] matrix, int i, int j, boolean[][] visited){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[i].length)
            return ;
        if(visited[i][j])
            return;
        if(matrix[i][j] == 0)
            return;
        visited[i][j] = true;
        updateMatrix(matrix, i-1, j, visited);
        updateMatrix(matrix, i, j-1, visited);
        updateMatrix(matrix, i, j+1, visited);
        updateMatrix(matrix, i+1, j, visited);
    }
}