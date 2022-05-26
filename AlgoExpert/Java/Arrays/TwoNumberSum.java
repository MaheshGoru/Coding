/*
  Write a function that takes in a non-empty array of distinct integers and an
   integer representing a target sum. If any two numbers in the input array sum
   up to the target sum, the function should return them in an array, in any
   order. If no two numbers sum up to the target sum, the function should return
   an empty array.

   Note that the target sum has to be obtained by summing two different integers
   in the array; you can't add a single integer to itself in order to obtain the
   target sum.
  
   You can assume that there will be at most one pair of numbers summing up to
   the target sum.

   Sample Input
   array  = [5, 1, 22, 25, 6, -1, 8, 10]
   sequence  = [1, 6, -1, 10]
   Sample Output
   true
 */
import java.util.*;
class TwoNumberSum{
	public static void main(String args[]){
		int[] array = {3,5,-4,8,11,1,-1,6};
		int targetSum = 10;
		int[] result = twoNumberSum(array, targetSum);
		for(int i=0;i<result.length;i++){
			System.out.print(result[i]+" ");
		}
	}
	public static int[] twoNumberSum(int[] array, int targetSum){
		Set<Integer> visitedNums = new HashSet<Integer>();
		for(int i=0;i<array.length;i++){
			int difference = targetSum - array[i];
			if(visitedNums.contains(difference)){
				return new int[]{array[i], difference};
			}else{
				visitedNums.add(array[i]);
			}
		}
		return new int[]{};
	}
}