/*

You're given an array of arrays where each subarray holds two integer values
and represents an item; the first integer is the item's value, and the second
integer is the item's weight. You're also given an integer representing the
maximum capacity of a knapsack that you have.

Your goal is to fit items in your knapsack without having the sum of their
weights exceed the knapsack's capacity, all the while maximizing their
combined value. Note that you only have one of each item at your disposal.

Write a function that returns the maximized combined value of the items that
you should pick as well as an array of the indices of each item picked.

If there are multiple combinations of items that maximize the total value in
the knapsack, your function can return any of them.
Sample Input:
items = [[1, 2], [4, 3], [5, 6], [6, 7]]
capacity = 10
Sample Output:
[10, [1, 3]]// items [4, 3] and [6, 7]
*/
import java.util.*;
class KnapSackProblem{
    public static void main(String args[]){
        int[][] items = {{1,2}, {4,3}, {5,6}, {6,7}};
        int capacity = 10;
        List<List<Integer>> result = knapsackProblem(items, capacity);
        System.out.println(result);
    }

    public static List<List<Integer>> knapsackProblem(int[][] items, int capacity){
        int[][] dp = new int[items.length+1][capacity+1];
        for(int i=0;i<=items.length;i++)
            dp[i][0] = 0;
        for(int i=0;i<=capacity;i++)
            dp[0][i] = 0;
        for(int i=1;i<=items.length;i++){
            for(int j=1;j<=capacity;j++){
                int weight = items[i-1][1];
                int profit = items[i-1][0];
                if(weight <= j){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight]+profit);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        int row = items.length;
        int col = capacity;
        List<Integer> finalItems = new ArrayList<>();
        while(row != 0 && col != 0 && dp[row][col] != 0){
            if(dp[row][col] == dp[row-1][col]){
                row--;
            }else{
                finalItems.add(0,row-1);
                col = col - items[row-1][1];
                row--;
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(dp[items.length][capacity]));
        result.add(finalItems);
        return result;
    }
}