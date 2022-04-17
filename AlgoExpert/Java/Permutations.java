/*

Write a function that takes in an array of unique integers and returns an
array of all permutations of those integers in no particular order.
If the input array is empty, the function should return an empty array.

Sample Input:
array  = [1, 2, 3]
Sample Output:
[[1, 2, 3], [1, 3, 2], [2, 1, 3], [2, 3, 1], [3, 1, 2], [3, 2, 1]]
*/
import java.util.*;
class Permutation{
    public static void main(String args[]){
        List<Integer> array = Arrays.asList(1,2,3);
        List<List<Integer>> permutations = getPermutations(array);
        for(int i=0;i<permutations.size();i++){
            for(int j=0;j<permutations.get(i).size();j++){
                System.out.print(permutations.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

//    public static void permutationHelper(List<Integer> array, List<List<Integer>> permutations, List<Integer> currentPermutation,boolean[] freq){
//        if(array.size() == 0)
//            return ;
//        if(array.size() == currentPermutation.size())
//        {
//            permutations.add(new ArrayList<>(currentPermutation));
//            return;
//        }
//        for(int i=0;i<array.size();i++){
//            if(!freq[i]){
//                freq[i] = true;
//                currentPermutation.add(array.get(i));
//                permutationHelper(array, permutations, currentPermutation, freq);
//                currentPermutation.remove(currentPermutation.size()-1);
//                freq[i] = false;
//            }
//        }
//    }
//
    public static List<List<Integer>> getPermutations(List<Integer> array){
        List<List<Integer>> permutations = new ArrayList<>();
        List<Integer> currentPermutation = new ArrayList<>();
        boolean freq[] = new boolean[array.size()];
//        permutationHelper(array, permutations, currentPermutation, freq);
        permutationHelperWithSwapping(array, permutations, 0);
        return permutations;
    }

    public static void swap(List<Integer> array, int index1, int index2){
        int temp = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, temp);
    }
    public static void permutationHelperWithSwapping(List<Integer> array, List<List<Integer>> currentPermutations, int index){
        if(array.size() == 0)
            return;
        if(index == array.size()) {
            List<Integer> tempList = new ArrayList<>();
            for(int i=0;i<array.size();i++){
                tempList.add(array.get(i));
            }
            currentPermutations.add(tempList);
            return;
        }
        for(int i=index; i < array.size();i++){
            swap(array, index, i);
            permutationHelperWithSwapping(array, currentPermutations, index+1);
            swap(array, index, i);
        }
    }


}