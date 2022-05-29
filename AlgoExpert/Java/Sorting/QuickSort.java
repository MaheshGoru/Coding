/*

Write a function that takes in an array of integers and returns a sorted
version of that array. Use the Quick Sort algorithm to sort the array.
Sample Input
array  = [8, 5, 2, 9, 5, 6, 3]
Sample Output
[2, 3, 5, 5, 6, 8, 9]*/
class QuickSort{
    public static void main(String args[]){
        int[] array = {8,5,2,9,6,3};
        int[] sortedArray = quickSort(array);
        for(int i=0;i<sortedArray.length;i++){
            System.out.print(sortedArray[i]+" ");
        }
    }
    public static int[] quickSort(int[] array){
        quickSortHelper(array, 0, array.length-1);
        return array;
    }
    public static void quickSortHelper(int[] array, int start, int end){
        if(start < end){
            int pos = placePivot(array, start, end);
            quickSortHelper(array, start, pos-1);
            quickSortHelper(array, pos+1, end);
        }
    }
    public static int placePivot(int[] array, int start, int end){
        int left = start-1;
        for(int i=start;i<end;i++){
            if(array[i] < array[end]){
                left++;
                swap(array, left, i);
            }
        }
        left++;
        swap(array, left, end);
        return left;
    }
    public static void swap(int[] array, int pos1, int pos2){
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }
}