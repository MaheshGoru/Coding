/*

Write a function that takes in an array of integers and returns a sorted
version of that array. Use the Merge Sort algorithm to sort the array.
Sample Input
array  = [8, 5, 2, 9, 5, 6, 3]
Sample Output
[2, 3, 5, 5, 6, 8, 9]*/
class MergeSort{
    public static void main(String args[]){
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        int[] sortedArray = mergeSort(array);
        for(int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
    }

    public static int[] mergeSort(int[] array){
        mergeSortHelper(array, 0, array.length-1);
        return array;
    }

    public static void mergeSortHelper(int[] array, int start, int end){
        if(start < end){
            int mid = (start+end) / 2;
            mergeSortHelper(array, start, mid);
            mergeSortHelper(array, mid+1, end);
            merge(array, start, mid, end);
        }
    }

    public static void merge(int[] array, int start, int mid, int end){
        int leftArr[] = new int[mid-start+1];
        int rightArr[] = new int[end-mid];
        int leftIdx = 0;
        int rightIdx = 0;
        for(int i=start;i<=mid;i++){
            leftArr[leftIdx++] = array[i];
        }
        for(int i=mid+1;i<=end;i++){
            rightArr[rightIdx++] = array[i];
        }
        leftIdx = 0;
        rightIdx = 0;
        int arrIdx = start;
        while(leftIdx < leftArr.length && rightIdx < rightArr.length){
            if(leftArr[leftIdx] < rightArr[rightIdx])
                array[arrIdx++] = leftArr[leftIdx++];
            else
                array[arrIdx++] = rightArr[rightIdx++];
        }
        while(leftIdx < leftArr.length){
            array[arrIdx++] = leftArr[leftIdx++];
        }
        while(rightIdx < rightArr.length){
            array[arrIdx++] = rightArr[rightIdx++];
        }
    }
}