/*

Write a function that takes in an array of at least two integers and that
returns an array of the starting and ending indices of the smallest subarray
in the input array that needs to be sorted in place in order for the entire
input array to be sorted (in ascending order).

If the input array is already sorted, the function should return
[-1, -1].
Sample Input:
array = [1, 2, 4, 7, 10, 11, 7, 12, 6, 7, 16, 18, 19]
Sample Output:
[3, 9]
*/
class SubArraySort{
    public static void main(String args[]){
        int[] array = {1,2,4,7,10,11,7,12,6,7,16,18,19};
        int[] res = subArraySort(array);
        System.out.println(res[0]+" "+res[1]);
        int[] res1 = subarraySort(array);
        System.out.println(res1[0]+" "+res1[1]);
    }

    // O(n^2) Time | O(1) Space
    public static int[] subArraySort(int[] array){
        int leftIdx = -1;
        int rightIdx = -1;
        boolean leftFound = false;
        boolean rightFound = false;
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[i] > array[j]){
                    leftIdx = i;
                    leftFound = true;
                    break;
                }
            }
            if(leftFound) break;
        }
        for(int i=array.length-1;i>0;i--){
            for(int j=i-1;j>=0;j--){
                if(array[i] < array[j]){
                    rightIdx = i;
                    rightFound = true;
                    break;
                }
            }
            if(rightFound) break;
        }
        return new int[]{leftIdx, rightIdx};
    }

    // O(n) Time | O(1) Space
    public static int[] subarraySort(int[] array){
        int leftIdx = -1;
        int rightIdx = -1;
        for(int i=0;i<array.length-1;i++){
            if(array[i] > array[i+1]) {
                leftIdx = i;
                break;
            }
        }
        for(int i=array.length-1;i>0;i--){
            if(array[i] < array[i-1]){
                rightIdx = i;
                break;
            }
        }
        if(leftIdx != -1 && rightIdx != -1) {
            int minVal = Integer.MAX_VALUE;
            int maxVal = Integer.MIN_VALUE;
            for (int i = leftIdx; i <= rightIdx; i++) {
                minVal = Math.min(array[i], minVal);
                maxVal = Math.max(array[i], maxVal);
            }
            for (int i = 0; i < array.length; i++) {
                if (array[i] > minVal) {
                    leftIdx = i;
                    break;
                }
            }
            for (int i = array.length - 1; i >= 0; i--) {
                if (array[i] < maxVal) {
                    rightIdx = i;
                    break;
                }
            }
        }
        return new int[]{leftIdx, rightIdx};
    }
}