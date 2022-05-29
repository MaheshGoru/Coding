/*
Write a function that takes in an array of integers and returns an array of
length 2 representing the largest range of integers contained in that array.

The first number in the output array should be the first number in the range,
while the second number should be the last number in the range.

A range of numbers is defined as a set of numbers that come right after each
other in the set of real integers. For instance, the output array
[2, 6] represents the range {2, 3, 4, 5, 6}, which
is a range of length 5. Note that numbers don't need to be sorted or adjacent
in the input array in order to form a range.
You can assume that there will only be one largest range.
Sample Input
array = [1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6]
Sample Output
[0, 7]*/
import java.util.*;
class LargestRange{
    public static void main(String args[]){
        int[] array = {1, 11, 3, 0, 15, 5, 2, 4, 10, 7, 12, 6};
        int[] res = largestRange1(array);
        System.out.println(res[0]+" "+res[1]);
        int[] res1 = largestRange(array);
        System.out.println(res1[0]+" "+res1[1]);
    }

    // O(nlogn) Time | O(1) space
    public static int[] largestRange1(int[] array){
        Arrays.sort(array);
        int leftVal = array[0];
        int rightVal = array[0];
        int maxRange = 0;
        int finalLeft = leftVal;
        int finalRight = rightVal;
        for(int i=1;i<array.length;i++){
            if(array[i] == array[i-1] || array[i-1]+1 == array[i]){
                rightVal = array[i];
            }else{
                if(maxRange < rightVal - leftVal + 1){
                    maxRange = rightVal - leftVal + 1;
                    finalLeft = leftVal;
                    finalRight = rightVal;
                    leftVal = array[i];
                    rightVal = array[i];
                }
            }
        }
        if(maxRange < rightVal - leftVal + 1){
            finalLeft = leftVal;
            finalRight = rightVal;
        }
        return new int[]{finalLeft, finalRight};
    }

    // O(n) Time | O(n) Space
    public static int[] largestRange(int[] array){
        Map<Integer,Boolean> map = new HashMap<Integer, Boolean>();
        for(int i=0;i<array.length;i++){
            map.put(array[i], false);
        }
        int finalLeft = array[0];
        int finalRight = array[0];
        int maxRange = 0;
        for(int i=0;i<array.length;i++){
            if(map.get(array[i]))
                continue;
            map.put(array[i], true);
            int left = array[i]-1;
            int currentCount = 1;
            while(map.containsKey(left)){
                map.put(left, true);
                left--;
                currentCount++;
            }
            int right = array[i]+1;
            while(map.containsKey(right)){
                map.put(right, true);
                right++;
                currentCount++;
            }
            if(maxRange < currentCount){
                maxRange = currentCount;
                finalLeft = left+1;
                finalRight = right-1;
            }
        }
        return new int[]{finalLeft, finalRight};
    }
}