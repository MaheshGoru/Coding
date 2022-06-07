/*

Write a function that takes in a non-empty array of distinct integers and an
integer representing a target sum. The function should find all quadruplets in
the array that sum up to the target sum and return a two-dimensional array of
all these quadruplets in no particular order.

If no four numbers sum up to the target sum, the function should return an
empty array.
Sample Input
array = [7, 6, 4, -1, 1, 2]
targetSum = 16
Sample Output
[[7, 6, 4, -1], [7, 6, 1, 2]]
*/
import java.util.*;
class FourNumberSum{
    public static void main(String[] args){
        int[] array = {7, 6, 4, -1, 1, 2};
        int targetSum = 16;
        List<Integer[]> pairs = fourNumberSum(array, targetSum);
        for(int i=0;i<pairs.size();i++){
            Integer[] pair = pairs.get(i);
            System.out.println(pair[0]+ " "+pair[1]+" "+pair[2]+" "+pair[3]);
        }
    }

    public static List<Integer[]> fourNumberSum1(int[] array, int targetSum){
        List<Integer[]> res = new ArrayList<>();
        for(int i=0;i<array.length-3;i++){
            for(int j=i+1;j<array.length-2;j++){
                for(int k=j+1;k<array.length-1;k++){
                    for(int l=k+1;l<array.length;l++){
                        if(array[i] + array[j] + array[k] + array[l] == targetSum){
                            res.add(new Integer[]{array[i], array[j], array[k], array[l]});
                        }
                    }
                }
            }
        }
        return res;
    }

    public static List<Integer[]> fourNumberSum2(int[] array, int targetSum){
        Arrays.sort(array);
        List<Integer[]> res = new ArrayList<>();
        for(int i=0;i<array.length-3;i++){
            for(int j=i+1;j<array.length-2;j++){
                int start = j+1;
                int end = array.length-1;
                while(start < end){
                    int totalSum = array[i]+array[j]+array[start]+array[end];
                    if(totalSum == targetSum){
                        res.add(new Integer[]{array[i], array[j], array[start], array[end]});
                        start++;
                        end--;
                    }
                    else if(totalSum > targetSum)
                        end--;
                    else
                        start++;
                }
            }
        }
        return res;
    }

    public static List<Integer[]> fourNumberSum(int[] array, int targetSum){
        Map<Integer, List<Integer[]>> hashMap = new HashMap<>();
        List<Integer[]> res = new ArrayList<>();
        for(int i=0;i<array.length-1;i++){
            for(int j=i+1;j<array.length;j++){
                int currSum = array[i]+array[j];
                int diff = targetSum - currSum;
                if(hashMap.containsKey(diff)){
                    List<Integer[]> pairs = hashMap.get(diff);
                    for(int k=0;k<pairs.size();k++){
                        Integer[] pair = pairs.get(k);
                        res.add(new Integer[]{pair[0], pair[1], array[i], array[j]});
                    }
                }
            }
            for(int j=0;j<i;j++){
                int currSum = array[i]+array[j];
                if(!hashMap.containsKey(currSum)){
                    hashMap.put(currSum, new ArrayList<Integer[]>());
                }
                hashMap.get(currSum).add(new Integer[]{array[j], array[i]});
            }
        }
        return res;
    }
}