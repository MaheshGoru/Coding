/*

You're given a two-dimensional array (a matrix) of potentially unequal height
and width containing only 0s and 1s. Each
0 represents land, and each 1 represents part of a
river. A river consists of any number of 1s that are either
horizontally or vertically adjacent (but not diagonally adjacent). The number
of adjacent 1s forming a river determine its size.

Note that a river can twist. In other words, it doesn't have to be a straight
vertical line or a straight horizontal line; it can be L-shaped, for example.

Write a function that returns an array of the sizes of all rivers represented
in the input matrix. The sizes don't need to be in any particular order.
Sample Input
matrix = [
[1, 0, 0, 1, 0],
[1, 0, 1, 0, 0],
[0, 0, 1, 0, 1],
[1, 0, 1, 0, 1],
[1, 0, 1, 1, 0],
]
Sample Output
[1, 2, 2, 2, 5]
// The numbers could be ordered differently.
// The rivers can be clearly seen here:
// [
//   [1,  ,  , 1,  ],
//   [1,  , 1,  ,  ],
//   [ ,  , 1,  , 1],
//   [1,  , 1,  , 1],
//   [1,  , 1, 1,  ],
// ]
*/
import java.util.*;
class RiverSizes{
    public static void main(String args[]){
        int[][] matrix = {{1,0,0,1,0},{1,0,1,0,0},{0,0,1,0,1},{1,0,1,0,1},{1,0,1,1,0}};
        List<Integer> riverSizes = riverSizes(matrix);
        for(int i=0;i<riverSizes.size();i++){
            System.out.println(riverSizes.get(i));
        }
    }

    public static List<Integer> riverSizes(int[][] matrix){
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        List<Integer> res = new ArrayList<>();
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == 1 && visited[i][j] == false){
                    int count = riverSizeHelper(matrix, i, j, visited);
                    res.add(count);
                }
            }
        }
        return res;
    }

    public static int riverSizeHelper(int[][] matrix, int row, int col, boolean[][] visited){
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[row].length)
            return 0;
        if(matrix[row][col] == 0)
            return 0;
        if(visited[row][col] == true)
            return 0;
        visited[row][col] = true;
        return 1 + riverSizeHelper(matrix, row-1, col, visited) +
                riverSizeHelper(matrix, row, col-1, visited) +
                riverSizeHelper(matrix, row, col+1, visited) +
                riverSizeHelper(matrix, row+1, col, visited);
    }
}