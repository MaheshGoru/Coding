/*

You're given an array of integers and another array of three distinct
integers. The first array is guaranteed to only contain integers that are in
the second array, and the second array represents a desired order for the
integers in the first array. For example, a second array of [x, y, z] represents a desired order of
[x, x, ..., x, y, y, ..., y, z, z, ..., z] in the first array.

Write a function that sorts the first array according to the desired order in
the second array.

The function should perform this in place (i.e., it should mutate the input
array), and it shouldn't use any auxiliary space (i.e., it should run with
constant space: O(1) space).

Note that the desired order won't necessarily be ascending or descending and
that the first array won't necessarily contain all three integers found in the
second array—it might only contain one or two.
Sample Input:
array = [1, 0, 0, -1, -1, 0, 1, 1]
order = [0, 1, -1]
Sample Output:
[0, 0, 0, 1, 1, 1, -1, -1]
*/

class ThreeNumberSort{
    public static void main(String args[]){
        int[] array = {1,0,0,-1,-1,0,1,1};
        int[] order = {0,1,-1};
        int[] sortedArray = threeNumberSort(array, order);
        for(int i=0;i<sortedArray.length;i++){
            System.out.print(sortedArray[i]+" ");
        }
    }
//    public static int[] threeNumberSort(int[] array, int[] order){
//        int idx=0;
//        for(int i=0;i<order.length-1;i++){
//            int j = idx;
//            while(j < array.length){
//                if(array[j] == order[i]){
//                    int temp = array[j];
//                    array[j] = array[idx];
//                    array[idx] = temp;
//                    idx++;
//                }
//                j++;
//            }
//        }
//        return array;
//    }

    public static int[] threeNumberSort(int[] array, int[] order){
        int firstIdx = 0;
        int secondIdx = 0;
        int thirdIdx = array.length-1;
        while(secondIdx <= thirdIdx){
            if(array[secondIdx] == order[0]){
                swap(array, secondIdx, firstIdx);
                firstIdx++;
                secondIdx++;
            }else if(array[secondIdx] == order[1]){
                secondIdx++;
            }else if(array[secondIdx] == order[2]){
                swap(array, secondIdx, thirdIdx);
                thirdIdx--;
            }
        }
        return array;
    }

    public static void swap(int[] array, int secondIdx, int idx){
        int temp = array[secondIdx];
        array[secondIdx] = array[idx];
        array[idx] = temp;
    }
}