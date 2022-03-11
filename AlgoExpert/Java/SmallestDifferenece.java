/*

  Write a function that takes in two non-empty arrays of integers, finds the
  pair of numbers (one from each array) whose absolute difference is closest to
  zero, and returns an array containing these two numbers, with the number from
  the first array in the first position.


  Note that the absolute difference of two integers is the distance between
  them on the real number line. For example, the absolute difference of -5 and 5
  is 10, and the absolute difference of -5 and -4 is 1.

  You can assume that there will only be one pair of numbers with the smallest
  difference.

  SampleInput
  arrayOne  = [-1, 5, 10, 20, 28, 3]
  arrayTwo  = [26, 134, 135, 15, 17]
  Sample Output
  [28, 26]
 */
import java.util.*;
class SmallestDifference{
    public static void main(String args[]){
        int[] arrayOne = {-1,5,10,20,28,3};
        int[] arrayTwo = {26,134,135,15,17};
        int[] smallestDiff = smallestDifference(arrayOne, arrayTwo);
        System.out.println(smallestDiff[0]+" "+smallestDiff[1]);
    }
    private static int[] smallestDifference(int[] arrayOne, int[] arrayTwo){
        int[] result = new int[2];
        int absoluteDiff = Integer.MAX_VALUE;
        int firstIdx = 0;
        int secondIdx = 0;
        Arrays.sort(arrayOne);
        Arrays.sort(arrayTwo);
        while(firstIdx < arrayOne.length && secondIdx < arrayTwo.length){
            int currentDiff = arrayOne[firstIdx] < arrayTwo[secondIdx] ? arrayTwo[secondIdx] - arrayOne[firstIdx] : arrayOne[firstIdx] - arrayTwo[secondIdx];
            if(absoluteDiff > currentDiff){
                absoluteDiff = currentDiff;
                result = new int[] {arrayOne[firstIdx], arrayTwo[secondIdx]};
            }
            if(arrayOne[firstIdx] < arrayTwo[secondIdx]){
                firstIdx++;
            }else {
                secondIdx++;
            }
        }
        return result;
    }
}