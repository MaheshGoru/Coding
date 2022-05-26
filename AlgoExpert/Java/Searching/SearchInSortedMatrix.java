/*

You're given a two-dimensional array (a matrix) of distinct integers and a
target integer. Each row in the matrix is sorted, and each column is also sorted; the
matrix doesn't necessarily have the same height and width.

Write a function that returns an array of the row and column indices of the
target integer if it's contained in the matrix, otherwise [-1,-1]
Sample Input:
array  = [
[1, 4, 7, 12, 15, 1000],
[2, 5, 19, 31, 32, 1001],
[3, 8, 24, 33, 35, 1002],
[40, 41, 42, 44, 45, 1003],
[99, 100, 103, 106, 128, 1004],
]
Sample Output:
[3.3]
*/
class SearchInSortedMatrix{
    public static void main(String args[]){
        int[][] array = {{1, 4, 7, 12, 15, 1000},{2, 5, 19, 31, 32, 1001},{3, 8, 24, 33, 35, 1002},{40, 41, 42, 44, 45, 1003},{99, 100, 103, 106, 128, 1004}};
        int target = 44;
        int indexes[] = searchInSortedMatrix(array, target);
        System.out.println(indexes[0] + " "+indexes[1]);
    }

    public static int[] searchInSortedMatrix(int[][] array, int target){
        int row = 0;
        int column = array[0].length - 1;
        while(row < array.length && column >= 0){
            if(array[row][column] == target)
                return new int[]{row, column};
            if(array[row][column] > target)
                column--;
            else
                row++;
        }
        return new int[]{-1,-1};
    }
}