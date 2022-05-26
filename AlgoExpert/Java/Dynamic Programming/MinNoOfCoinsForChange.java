/*

Given an array of positive integers representing coin denominations and a
single non-negative integer n  representing a target amount of
money, write a function that returns the smallest number of coins needed to
make change for (to sum up to) that target amount using the given coin
denominations.

Note that you have access to an unlimited amount of coins. In other words, if
the denominations are [1, 5, 10], you have access to an unlimited
amount of 1s, 5s, and 10s.
If it's impossible to make change for the target amount, return
-1.
Sample Input
n = 7
denoms = [1,5,10]
Sample Output
3 // 2x1 + 1x5
*/
import java.util.*;
class MinNoOfCoinsForChange{
    public static void main(String args[]){
        int denoms[] = {1, 5, 10};
        int n = 7;
        int minCoinsByRecursion = minNumberOfCoinsForChangeByRecursion(n, denoms);
        System.out.println(minCoinsByRecursion);
        int minCoinsByDP = minNumberOfCoinsForChangeByDP(n, denoms);
        System.out.println(minCoinsByDP);
    }

    public static int minNumberOfCoinsForChangeHelper(int n, int idx, int[] denoms){
        if(n == 0)
            return 0;
        int minimum = Integer.MAX_VALUE;
        for(int i=idx;i<denoms.length;i++){
            if(denoms[i] <= n){
                int value = minNumberOfCoinsForChangeHelper(n - denoms[i], i, denoms);
                if(value != -1)
                    minimum = Math.min(minimum, value + 1);
            }
        }
        return minimum == Integer.MAX_VALUE ? -1 : minimum;
    }
    public static int minNumberOfCoinsForChangeByRecursion(int n, int[] denoms){
        return minNumberOfCoinsForChangeHelper(n, 0, denoms);
    }

    public static int minNumberOfCoinsForChangeByDP(int n, int[] denoms){
        int minCoins[] = new int[n+1];
        minCoins[0] = 0;
        for(int i=1;i<=n;i++) minCoins[i] = Integer.MAX_VALUE;
        for(int i=0;i<denoms.length;i++){
            for(int amount=1; amount <= n;amount++){
                if(amount >= denoms[i]){
                    int value = minCoins[amount-denoms[i]] == Integer.MAX_VALUE ? Integer.MAX_VALUE : minCoins[amount-denoms[i]]+1;
                    minCoins[amount] = Math.min(value, minCoins[amount]);
                }
            }
        }
        return minCoins[n] == Integer.MAX_VALUE ? -1: minCoins[n];
    }
}