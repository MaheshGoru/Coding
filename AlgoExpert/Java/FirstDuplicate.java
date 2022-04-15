/*

Given an array of integers between 1 and n ,
inclusive, where n  is the length of the array, write a function
that returns the first integer that appears more than once (when the array is
read from left to right).

In other words, out of all the integers that might occur more than once in the
input array, your function should return the one whose first duplicate value
has the minimum index.

If no integer appears more than once, your function should return -1.
Note that you're allowed to mutate the input array.
Sample Input:
array  = [2, 1, 5, 2, 3, 3, 4]
Sample Output:
2
Sample Input:
array  = [2, 1, 5, 3, 3, 2, 4]
Sample Output:
3*/
class FirstDuplicate{
    public static void main(String args[]){
        int[] array = {2,1,5,2,3,3,4};
        int duplicateValue = firstDuplicateValue(array);
        System.out.println(duplicateValue);
    }
    public static int firstDuplicateValue(int[] array){
        for(int i=0;i<array.length;i++){
            int absValue = Math.abs(array[i]);
            if(array[absValue - 1] < 0){
                return absValue;
            }
            array[absValue - 1] *= -1;
        }
        return -1;
    }
}