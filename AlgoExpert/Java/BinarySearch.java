/*

Write a function that takes in a sorted array of integers as well as a target
integer. The function should use the Binary Search algorithm to determine if
the target integer is contained in the array and should return its index if it
is, otherwise -1.

If you're unfamiliar with Binary Search, we recommend watching the Conceptual
Overview section of this question's video explanation before starting to code.
Sample Input:
array  = [0, 1, 21, 33, 45, 45, 61, 71, 72, 73]
target = 33
Sample Output:
3
*/
class BinarySearch{
    public static void main(String args[]){
        int[] array = {0, 1, 21, 33, 45, 45, 61, 71, 72, 73};
        int target = 33;
        int index = binarySearch(array, target);
        System.out.println(index);
    }

    public static int binarySearch(int[] array, int target){
        int left = 0;
        int right = array.length - 1;
        while(left <= right){
            int mid = (left+right) / 2;
            if(array[mid] == target)
                return mid;
            if(array[mid] < target)
                left = mid+1;
            else
                right = mid-1;
        }
        return -1;
    }
}