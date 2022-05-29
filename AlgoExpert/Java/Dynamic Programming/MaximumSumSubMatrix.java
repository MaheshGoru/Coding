/*
You're given a two-dimensional array (a matrix) of potentially unequal height
and width that's filled with integers. You're also given a positive integer
size. Write a function that returns the maximum sum that can be
generated from a submatrix with dimensions size * size.
For example, consider the following matrix:[
[2, 4],
[5, 6],
[-3, 2],
]
If size = 2, then the 2x2 submatrices to consider are:[2, 4]
[5, 6]

------
[5, 6]
[-3, 2]

The sum of the elements in the first submatrix is 17, and the sum
of the elements in the second submatrix is 10. In this example,
your function should return 17.

Note: size will always be at least 1, and the
dimensions of the input matrix will always be at least
size * size.
Sample Input
matrix =
[
[5, 3, -1, 5],
[-7, 3, 7, 4],
[12, 8, 0, 0],
[1, -8, -8, 2],
]
size = 2
Sample Output
18
// [
//   [., ., ., .],
//   [., 3, 7, .],
//   [., 8, 0, .],
//   [., ., ., .],
// ]*/
class MaximumSumSubMatrix{
    public static void main(String args[]){
        int[][] matrix = {{5,3,-1,5},{-7,3,7,4},{12,8,0,0},{1,-8,-8,2}};
        int size = 2;
        int maxSumByIteration = maximumSumSubmatrixByIteration(matrix, size);
        System.out.println(maxSumByIteration);
        int maxSumByDP = maximumSumSubmatrix(matrix, size);
        System.out.println(maxSumByDP);
    }

    public static int maximumSumSubmatrixByIteration(int[][] matrix, int size){
        int maxSum = Integer.MIN_VALUE;
        for(int i=0;i<=matrix.length-size;i++){
            for(int j=0;j<=matrix[i].length-size;j++){
                int sum = 0;
                for(int k=i;k<i+size;k++){
                    for(int l=j;l<j+size;l++){
                        sum += matrix[k][l];
                    }
                }
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static int maximumSumSubmatrix(int[][] matrix, int size){
        int sums[][] = new int[matrix.length][matrix[0].length];
        int currentSum = 0;
        for(int i=0;i<matrix.length;i++){
            currentSum += matrix[i][0];
            sums[i][0] = currentSum;
        }
        currentSum = matrix[0][0];
        for(int i=1;i<matrix[0].length;i++){
            currentSum += matrix[0][i];
            sums[0][i] = currentSum;
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[i].length;j++){
                sums[i][j] = sums[i-1][j] + sums[i][j-1] - sums[i-1][j-1] + matrix[i][j];
            }
        }
        int maxVal = Integer.MIN_VALUE;
        for(int i=size-1;i<matrix.length;i++){
            for(int j=size-1;j<matrix[i].length;j++){
                int sum = sums[i][j];
                if(i != size-1)
                    sum -= sums[i-size][j];
                if(j != size-1)
                    sum -= sums[i][j-size];
                if(i != size-1 && j != size-1)
                    sum += sums[i-size][j-size];
                maxVal = Math.max(maxVal, sum);
            }
        }
        return maxVal;
    }
}