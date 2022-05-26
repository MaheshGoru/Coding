/*

Write a function that takes in an array of unique integers and returns its
powerset.

The powerset P(X) of a set X is the set of all
subsets of X. For example, the powerset of [1,2] is
[[], [1], [2], [1,2]].

Note that the sets in the powerset do not need to be in any particular order.
Sample Input:
array  = [1, 2, 3]
Sample Output:
[[], [1], [2], [3], [1, 2], [1, 3], [2, 3], [1, 2, 3]]
*/
import java.util.*;
class PowerSet{
    public static void main(String args[]){
        List<Integer> array = Arrays.asList(1,2,3);
        List<List<Integer>> powerSet = powerset(array);
        for(int i=0;i<powerSet.size();i++){
            for(int j=0;j<powerSet.get(i).size();j++){
                System.out.print(powerSet.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }

//    public static void powerSetHelper(List<Integer> array, List<List<Integer>> powerSet, List<Integer> subset, int index){
//        if(index == array.size())
//            return ;
//        for(int i=index;i<array.size();i++){
//            subset.add(array.get(i));
//            powerSet.add(new ArrayList<>(subset));
//            powerSetHelper(array, powerSet, subset, i+1);
//            subset.remove(subset.size()-1);
//        }
//    }
    public static List<List<Integer>> powerset(List<Integer> array){
        List<List<Integer>> powerSet = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        powerSet.add(subset);
//        powerSetHelper(array, powerSet, subset, 0);
        powerSetHelper1(array, powerSet);
        return powerSet;
    }

    public static void powerSetHelper1(List<Integer> array, List<List<Integer>> powerSet){
        for(int i=0;i<array.size();i++){
            int len = powerSet.size();
            for(int j=0;j<len;j++){
                List<Integer> subset = new ArrayList<>(powerSet.get(j));
                subset.add(array.get(i));
                powerSet.add(subset);
            }
        }
    }
}