/*

Write a function that takes in an array of integers and returns a sorted
version of that array. Use the Bubble Sort algorithm to sort the array.

If you're unfamiliar with Bubble Sort, we recommend watching the Conceptual
Overview section of this question's video explanation before starting to code.
Sample Input:
array = [8, 5, 2, 9, 5, 6, 3]
Sample Output:
[2, 3, 5, 5, 6, 8, 9]
*/
class BubbleSort{
    public static void main(String args[]){
        int[] array = {8,5,2,9,5,6,3};
        int[] sortedArray = bubbleSort(array);
        for(int i=0;i<sortedArray.length;i++){
            System.out.print(sortedArray[i]+" ");
        }
    }

    public static int[] bubbleSort(int[] array){
        for(int i=0;i<array.length-1;i++){
            boolean isSorted = true;
            for(int j=0;j<array.length-i-1;j++){
                if(array[j] > array[j+1]){
                    int temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    isSorted = false;
                }
            }
            if(isSorted)
                break;
        }
        return array;
    }
}