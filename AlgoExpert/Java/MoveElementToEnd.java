//
//You're given an array of integers and an integer. Write a function that moves
//all instances of that integer in the array to the end of the array and returns
//the array.
//
//The function should perform this in place (i.e., it should mutate the input
//array) and doesn't need to maintain the order of the other integers.
//
//Sample Input:
//array = [2,1,2,2,2,3,4,2]
//toMove = 2
//Sample Output:
//[1,3,4,2,2,2,2,2] // the numbers 1, 3, and 4 could be ordered differently
import java.util.*;
class MoveElementToEnd{
    public static void main(String args[]){
        List<Integer> array = Arrays.asList(2,1,2,2,2,3,4,2);
        List<Integer> outputArray = moveElementToEnd(array, 2);
        for(int i=0;i<outputArray.size();i++){
            System.out.print(outputArray.get(i)+" ");
        }
    }
    public static List<Integer> moveElementToEnd(List<Integer> array, int toMove){
        int leftIdx = 0;
        int rightIdx = array.size() - 1;
        while(leftIdx < rightIdx){
            while(leftIdx < rightIdx && array.get(rightIdx) == toMove) rightIdx--;
            if(array.get(leftIdx) == toMove){
                int temp = array.get(leftIdx);
                array.set(leftIdx, array.get(rightIdx));
                array.set(rightIdx, temp);
            }
            leftIdx++;
        }
        return array;
    }
}