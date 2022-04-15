/*

Write a function that takes in a non-empty array of arbitrary intervals,
merges any overlapping intervals, and returns the new intervals in no
particular order.

Each interval interval is an array of two integers, with
interval[0] as the start of the interval and
interval[1] as the end of the interval.
Note that back-to-back intervals aren't considered to be overlapping. For
example, [1, 5] and [6, 7] aren't overlapping;
however, [1, 6] and [6, 7] are indeed
overlapping.
Also note that the start of any particular interval will always be less than
or equal to the end of that interval.
Sample Input:
intervals  = [[1, 2], [3, 5], [4, 7], [6, 8], [9, 10]]
Sample Output:
[[1, 2], [3, 8], [9, 10]]
*/
import java.util.*;
class MergeOverlappingIntervals{
    public static void main(String args[]){
        int[][] intervals = {{1,2},{3,5},{4,7},{6,8},{9,10}};
        int[][] overlappedIntervals = mergeOverlappingIntervals(intervals);
        for(int i=0;i<overlappedIntervals.length;i++){
            System.out.println(overlappedIntervals[i][0]+" "+overlappedIntervals[i][1]);
        }
    }
    public static int[][] mergeOverlappingIntervals(int[][] array){
        Arrays.sort(array, (a,b) -> Integer.compare(a[0], b[0]));
        int prevValue = array[0][0];
        int lastValue = array[0][1];
        List<List<Integer>> resultList = new ArrayList<>();
        for(int i=1;i<array.length;i++){
            if(array[i][0] > lastValue){
                resultList.add(Arrays.asList(prevValue, lastValue));
                prevValue = array[i][0];
            }
            lastValue = Math.max(lastValue, array[i][1]);
        }
        resultList.add(Arrays.asList(prevValue, lastValue));
        int[][] result = new int[resultList.size()][2];
        for(int i=0;i<result.length;i++){
            result[i][0] = resultList.get(i).get(0);
            result[i][1] = resultList.get(i).get(1);
        }
        return result;
    }
}