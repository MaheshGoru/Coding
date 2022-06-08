/*

An array of integers is said to represent the Binary Search Tree (BST)
obtained by inserting each integer in the array, from left to right, into the
BST.

Each BST node has an integer value, a
left child node, and a right child node. A node is
said to be a valid BST node if and only if it satisfies the BST
property: its value is strictly greater than the values of every
node to its left; its value is less than or equal to the values
of every node to its right; and its children nodes are either valid
BST nodes themselves or None / null.

Write a function that takes in two arrays of integers and determines whether
these arrays represent the same BST. Note that you're not  allowed to
construct any BSTs in your code.

Sample Input
arrayOne = [10, 15, 8, 12, 94, 81, 5, 2, 11]
arrayTwo = [10, 8, 5, 15, 2, 12, 11, 94, 81]
Sample Output
true
*/
import java.util.*;
class SameBSTs{
    public static void main(String args[]){
        List<Integer> arrayOne = Arrays.asList(10,15,8,12,94,81,5,2,11);
        List<Integer> arrayTwo = Arrays.asList(10,8,5,15,2,12,11,94,81);
        boolean sameBsts = sameBsts(arrayOne, arrayTwo);
        System.out.println(sameBsts);
    }

    // O(n^2) Time | O(n^2) Space
    public static boolean sameBsts1(List<Integer> arrayOne, List<Integer> arrayTwo){
        if(arrayOne.size() != arrayTwo.size())
            return false;
        if(arrayOne.size() == 0)
            return true;
        if(arrayOne.get(0) != arrayTwo.get(0))
            return false;
        List<Integer> leftArrayOne = new ArrayList<Integer>();
        List<Integer> rightArrayOne = new ArrayList<Integer>();
        List<Integer> leftArrayTwo = new ArrayList<Integer>();
        List<Integer> rightArrayTwo = new ArrayList<Integer>();
        for(int i=1;i<arrayOne.size();i++){
            if(arrayOne.get(i) < arrayOne.get(0))
                leftArrayOne.add(arrayOne.get(i));
            else
                rightArrayOne.add(arrayOne.get(i));
        }
        for(int i=1;i<arrayTwo.size();i++){
            if(arrayTwo.get(i) < arrayTwo.get(0))
                leftArrayTwo.add(arrayTwo.get(i));
            else
                rightArrayTwo.add(arrayTwo.get(i));
        }
        return sameBsts(leftArrayOne, leftArrayTwo) && sameBsts(rightArrayOne, rightArrayTwo);
    }

    // O(n^2) Time | O(n) Space
    public static boolean sameBsts(List<Integer> arrayOne, List<Integer> arrayTwo){
        if(arrayOne.size() != arrayTwo.size())
            return false;
        if(arrayOne.size() == 0)
            return true;
        return sameBstsHelper(arrayOne, arrayTwo, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public static boolean sameBstsHelper(List<Integer> arrayOne, List<Integer> arrayTwo, int idxOne, int idxTwo, int minVal, int maxVal){
        if(idxOne == -1 || idxTwo == -1)
            return idxOne == idxTwo;
        if(arrayOne.get(idxOne) != arrayTwo.get(idxTwo))
            return false;
        int currentVal = arrayOne.get(idxOne);
        int leftIdxOne = getNextIdx(arrayOne, idxOne, minVal, currentVal);
        int rightIdxOne = getNextIdx(arrayOne, idxOne, currentVal, maxVal);
        int leftIdxTwo = getNextIdx(arrayTwo, idxTwo, minVal, currentVal);
        int rightIdxTwo = getNextIdx(arrayTwo, idxTwo, currentVal, maxVal);
        return sameBstsHelper(arrayOne, arrayTwo, leftIdxOne, leftIdxTwo, minVal, currentVal) && sameBstsHelper(arrayOne, arrayTwo, rightIdxOne, rightIdxTwo, currentVal, maxVal);
    }

    public static int getNextIdx(List<Integer> array, int idx, int minVal, int maxVal){
        int index = -1;
        for(int i=idx+1; i<array.size();i++){
            int value = array.get(i);
            if(value >= minVal && value < maxVal){
                index = i;
                break;
            }
        }
        return index;
    }
}