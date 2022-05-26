/*

Write a function that takes in an array of integers and returns a sorted
version of that array. Use the Selection Sort algorithm to sort the array.
Sample Input:
array = [8, 5, 2, 9, 5, 6, 3]
Sample Output:
[2, 3, 5, 5, 6, 8, 9]
*/
class SelectionSort{
    public static void main(String args[]){
        int[] array = {8,5,2,9,5,6,3};
        int[] sortedArray = selectionSort(array);
        for(int i=0;i<sortedArray.length;i++){
            System.out.print(sortedArray[i]+" ");
        }
    }

    public static int[] selectionSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                if(array[j] < array[i]){
                    int temp = array[j];
                    array[j] = array[i];
                    array[i] = temp;
                }
            }
        }
        return array;
    }
}