/*

Write a function that takes in a non-empty array of integers and returns the
maximum sum that can be obtained by summing up all of the integers in a
non-empty subarray of the input array. A subarray must only contain adjacent
numbers (numbers next to each other in the input array).
Sample Input
array = [3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4]
Sample Output
19// [1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1]
*/
class KadaneAlgorithm{
    public static void main(String args[]){
        int[] array = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        int maxSum = kadanesAlgorithm(array);
        System.out.println(maxSum);
    }

    public static int kadanesAlgorithm(int[] array){
        int maxSum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int i=0;i<array.length;i++){
            currentSum += array[i];
            maxSum = Math.max(currentSum, maxSum);
            if(currentSum < 0)
                currentSum = 0;
        }
        return maxSum;
    }
}