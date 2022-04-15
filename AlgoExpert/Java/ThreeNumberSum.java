//Write a function that takes in a non-empty array of distinct integers and an
//integer representing a target sum. The function should find all triplets in
//the array that sum up to the target sum and return a two-dimensional array of
//all these triplets. The numbers in each triplet should be ordered in ascending
//order, and the triplets themselves should be ordered in ascending order with
//respect to the numbers they hold.
//
//If no three numbers sum up to the target sum, the function should return an
//empty array.
//Sample Input:
//array = [12, 3, 1, 2, -6, 5, -8, 6]
//targetSum = 0
//Sample Output:
//[[-8, 2, 6], [-8, 3, 5], [-6, 1, 5]]
//
import java.util.*;
class ThreeNumberSum{
    public static void main(String args[]){
        int[] array = {12,3,1,2,-6,5,-8,6};
        int targetSum = 0;
        List<Integer[]> result = threeNumberSum(array, targetSum);
        for(int i=0;i<result.size();i++){
            Integer[] pair = result.get(i);
            System.out.println(pair[0]+" "+pair[1]+" "+pair[2]);
        }
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum){
        Arrays.sort(array);
        List<Integer[]> res = new ArrayList<Integer[]>();
        for(int i=0;i<array.length-2;i++){
            int leftIdx = i+1;
            int rightIdx = array.length-1;
            int difference = targetSum - array[i];
            while(leftIdx < rightIdx){
                int leftRightSum = array[leftIdx] + array[rightIdx];
                if(leftRightSum == difference){
                    res.add(new Integer[]{array[i], array[leftIdx], array[rightIdx]});
                    leftIdx++;
                    rightIdx--;
                }else if(leftRightSum > difference){
                    rightIdx--;
                }else{
                    leftIdx++;
                }
            }
        }
        return res;
    }
}