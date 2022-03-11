/*
  Given two non-empty arrays of integers, write a function that determines
  whether the second array is a subsequence of the first one.

  A subsequence of an array is a set of numbers that aren't necessarily adjacent
  in the array but that are in the same order as they appear in the array. For
  instance, the numbers [1, 3, 4]  form a subsequence of the array [1, 2, 3, 4]  , and so do the numbers [2, 4]
  Note that a single number in an array and the array itself are both valid subsequences of the array.

  Sample Input
  array = [3, 5, -4, 8, 11, 1, -1, 6]
  targetSum = 10
  Sample Output
  [-1,11]
 */
import java.util.*;
class ValidateSubsequence{
    public static void main(String args[]){
        List<Integer> array = new ArrayList<Integer>(){{
            add(5);
            add(1);
            add(22);
            add(25);
            add(6);
            add(-1);
            add(8);
            add(10);}};
        List<Integer> sequence = new ArrayList<Integer>(){{
            add(1);
            add(6);
            add(-1);
            add(10);
        }};
        boolean isValid = isValidSubsequence(array, sequence);
        System.out.println(isValid);
    }
    public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence){
        int arrayIdx = 0;
        int seqIdx = 0;
        while(seqIdx < sequence.size() && arrayIdx < array.size()){
            if(array.get(arrayIdx) == sequence.get(seqIdx)){
                seqIdx++;
            }
            arrayIdx++;
        }
        return seqIdx == sequence.size();
    }
}