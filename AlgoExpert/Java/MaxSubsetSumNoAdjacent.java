/*

Write a function that takes in an array of positive integers and returns the
        maximum sum of non-adjacent elements in the array.
        If the input array is empty, the function should return 0.
Sample Input:
array = [75, 105, 120, 75, 90, 135]
Sample Output:
330 // 75+120+135
*/
import java.util.*;
class MaxSubsetSumNoAdjacent{
    public static void main(String args[]){
        int[] array = {75, 105, 120, 75, 90, 135};
        int maxSumByRecursion = maxSubsetSumNoAdjacentByRecursion(array);
        System.out.println(maxSumByRecursion);
        int maxSumByDP = maxSubsetSumNoAdjacentByDP(array);
        System.out.println(maxSumByDP);
        int maxSumByTwoVariables = maxSubsetSumNoAdjacentByTwoVariables(array);
        System.out.println(maxSumByTwoVariables);
    }

    public static int maxSubsetSumNoAdjacentByRecursion(int[] array){
        return maxSubsetSumNoAdjacentHelper(array, array.length-1);
    }

    public static int maxSubsetSumNoAdjacentHelper(int[] array, int n){
        if(n < 0) return 0;
        if(n == 0) return array[0];
        if(n == 1) return Math.max(array[0], array[1]);
        return Math.max(maxSubsetSumNoAdjacentHelper(array, n-1),
                maxSubsetSumNoAdjacentHelper(array, n-2) + array[n]);
    }

    public static int maxSubsetSumNoAdjacentByDP(int[] array){
        int n = array.length;
        if(n == 0) return 0;
        if(n == 1) return array[0];
        int dp[] = new int[array.length];
        dp[0] = array[0];
        dp[1] = Math.max(array[0], array[1]);
        for(int i=2;i<n;i++){
            dp[i] = Math.max(dp[i-1], dp[i-2]+array[i]);
        }
        return dp[n-1];
    }

    public static int maxSubsetSumNoAdjacentByTwoVariables(int[] array){
        int n = array.length;
        if(n == 0) return 0;
        if(n == 1) return array[0];
        int firstVal = array[0];
        int secondVal = Math.max(array[0], array[1]);
        for(int i=2;i<n;i++){
            int temp = Math.max(firstVal + array[i], secondVal);
            firstVal = secondVal;
            secondVal = temp;
        }
        return secondVal;
    }
}