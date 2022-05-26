/*

Write a function that takes in a non-empty array of integers and returns the
greatest sum that can be generated from a strictly-increasing subsequence in
the array as well as an array of the numbers in that subsequence.

A subsequence of an array is a set of numbers that aren't necessarily adjacent
in the array but that are in the same order as they appear in the array. For
instance, the numbers [1, 3, 4] form a subsequence of the array
[1, 2, 3, 4], and so do the numbers [2, 4]. Note
that a single number in an array and the array itself are both valid
subsequences of the array.

You can assume that there will only be one increasing subsequence with the
greatest sum.
Sample Input
array = [10, 70, 20, 30, 50, 11, 30]
Sample Output
[110, [10, 20, 30, 50]]
*/
import java.util.*;
class MaxSumIncreasingSubSequence{
    public static void main(String args[]){
        int array[] = {10, 70, 20, 30, 50, 11, 30};
        List<List<Integer>> res = maxSumIncreasingSubsequence(array);
        System.out.println(res.get(0));
        for(int i=0;i<res.get(1).size();i++){
            System.out.println(res.get(1).get(i));
        }
    }

    public static List<List<Integer>> maxSumIncreasingSubsequence(int[] array){
        int dp[] = new int[array.length];
        int indexes[] = new int[array.length];
        Arrays.fill(indexes, -1);
        int maxIdx = 0;
        for(int i=0;i<array.length;i++){
            dp[i] = array[i];
            for(int j=0;j<i;j++){
                if(array[i] > array[j] && array[i]+dp[j] > dp[i]){
                    dp[i] = array[i]+dp[j];
                    indexes[i] = j;
                }
            }
            if(dp[i] >= dp[maxIdx]){
                maxIdx = i;
            }
        }
        List<Integer> sequence = new ArrayList<>();
        int idx = maxIdx;
        while(idx != -1){
            sequence.add(0, array[idx]);
            idx = indexes[idx];
        }
        List<List<Integer>> res = new ArrayList<>();
        res.add(Arrays.asList(dp[maxIdx]));
        res.add(sequence);
        return res;
    }
}