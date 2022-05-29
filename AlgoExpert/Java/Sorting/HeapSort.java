/*

Write a function that takes in an array of integers and returns a sorted
version of that array. Use the Heap Sort algorithm to sort the array.
Sample Input
array  = [8, 5, 2, 9, 5, 6, 3]
Sample Output
[2, 3, 5, 5, 6, 8, 9]*/
class HeapSort{
    public static void main(String args[]){
        int[] array = {8, 5, 2, 9, 5, 6, 3};
        int[] sortedArray = heapSort(array);
        for(int i=0;i<sortedArray.length;i++){
            System.out.print(sortedArray[i]+" ");
        }
    }

    public static int[] heapSort(int[] array){
        buildMaxHeap(array);
        int heapSize = array.length-1;
        while(heapSize >= 0){
            swap(array, 0, heapSize);
            heapSize--;
            heapify(array, 0, heapSize);
        }
        return array;
    }

    public static void buildMaxHeap(int[] array){
        for(int i=array.length/2;i>=0;i--){
            heapify(array, i, array.length-1);
        }
    }

    public static void heapify(int[] array, int idx, int heapSize){
        int leftIdx = idx * 2 + 1;
        int rightIdx = idx * 2 + 2;
        int largest = idx;
        if(leftIdx <= heapSize && array[largest] < array[leftIdx])
            largest = leftIdx;
        if(rightIdx <= heapSize && array[largest] < array[rightIdx])
            largest = rightIdx;
        if(largest != idx){
            swap(array, largest, idx);
            heapify(array, largest, heapSize);
        }
    }

    public static void swap(int[] array, int pos1, int pos2){
        int temp = array[pos1];
        array[pos1] = array[pos2];
        array[pos2] = temp;
    }
}