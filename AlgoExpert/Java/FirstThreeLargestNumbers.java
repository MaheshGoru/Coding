/*

Write a function that takes in an array of at least three integers and,
without sorting the input array, returns a sorted array of the three largest
integers in the input array.

The function should return duplicate integers if necessary; for example, it
should return [10, 10, 12] for an input array of [10, 5, 9, 10, 12].
Sample Input:
array = [141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7]
Sample Output:
[18, 141, 541]

*/
class FirstThreeLargestNumbers{
    public static void main(String args[]){
        int[] array = {141, 1, 17, -7, -17, -27, 18, 541, 8, 7, 7};
        int[] largeNumbers = findThreeLargestNumbers(array);
        for(int i=0;i<largeNumbers.length;i++){
            System.out.print(largeNumbers[i]+" ");
        }
    }
    public static int[] findThreeLargestNumbers(int[] array){
        int[] largeNumbers = new int[3];
        for(int i=0;i<3;i++){
            largeNumbers[i] = Integer.MIN_VALUE;
        }
        for(int i=0;i<array.length;i++){
            if(array[i] > largeNumbers[0]){
                adjustNumbers(largeNumbers, array[i]);
            }
        }
        return largeNumbers;
    }
    public static void adjustNumbers(int[] largeNumbers, int value){
        for(int i=2;i>=0;i--){
            if(largeNumbers[i] < value){
                for(int j=0;j<=i;j++){
                    if(j==i)
                        largeNumbers[j] = value;
                    else
                        largeNumbers[j] = largeNumbers[j+1];
                }
                break;
            }
        }
    }
}