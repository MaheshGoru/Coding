//
//Write a function that takes in an array of integers and returns a boolean
//representing whether the array is monotonic.
//
//An array is said to be monotonic if its elements, from left to right, are
//entirely non-increasing or entirely non-decreasing.
//
//Non-increasing elements aren't necessarily exclusively decreasing; they simply
//don't increase. Similarly, non-decreasing elements aren't necessarily
//exclusively increasing; they simply don't decrease.
//Note that empty arrays and arrays of one element are monotonic.
//
//Sample Input:
//array  = [-1, -5, -10, -1100, -1100, -1101, -1102, -9001]
//Sample Output:
//true
class MonotonicArray{
    public static void main(String args[]){
        int[] array = new int[]{-1, -5, -10, -1100, -1100, -1101, -1102, -9001};
        boolean isMonotonicArray = isMonotonic(array);
        System.out.println(isMonotonicArray);
    }
    public static boolean isMonotonic(int[] array){
        boolean isNonIncreasing = true;
        boolean isNonDecreasing = true;
        for(int i=1;i<array.length;i++){
            if(array[i-1] < array[i])
                isNonIncreasing = false;
            if(array[i-1] > array[i])
                isNonDecreasing = false;
        }
        return isNonIncreasing || isNonDecreasing;
    }
}






