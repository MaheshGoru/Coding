/*

Write a function that takes in an array of integers and returns a sorted
version of that array. Use the Insertion Sort algorithm to sort the array.
Sample Input:
array = [8, 5, 2, 9, 5, 6, 3]
Sample Output:
[2, 3, 5, 5, 6, 8, 9]
*/
class InserionSort{
    public static void main(String args[]){
        int[] array = {8,5,2,9,5,6,3};
        int[] sortedArray = insertionSort(array);
        for(int i=0;i<sortedArray.length;i++){
            System.out.print(sortedArray[i]+" ");
        }
    }
    public static int[] insertionSort(int[] array){
        for(int i=1;i<array.length;i++){
            int key = array[i];
            int idx = i-1;
            while(idx >= 0 && array[idx] > key){
                array[idx+1] = array[idx];
                idx--;
            }
            array[idx+1] = key;
        }
        return array;
    }
}