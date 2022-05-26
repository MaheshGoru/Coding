/*
  Given an array of positive integers representing the values of coins in your
  possession, write a function that returns the minimum amount of change (the
  minimum sum of money) that you cannot  create. The given coins can have
  any positive integer value and aren't necessarily unique (i.e., you can have
  multiple coins of the same value).

  For example, if you're given
  coins = [1, 2, 5] , the minimum
  amount of change that you can't create is 4 . If you're given no
  coins, the minimum amount of change that you can't create is 1.

  Sample Input
  coins  = [5, 7, 1, 1, 2, 3, 22]
  Sample Output
  20
 */
import java.util.*;
class NonConstructibleChange{
    public static void main(String args[]){
        int[] coins = {5,7,1,1,2,3,22};
        int nonConstructChange = nonConstructibleChange(coins);
        System.out.println(nonConstructChange);
    }

    private static int nonConstructibleChange(int[] coins){
        int nonConstructChange = 0;
        Arrays.sort(coins);
        for(int i=0;i<coins.length;i++){
            if(nonConstructChange+1 >= coins[i]){
                nonConstructChange += coins[i];
            }else break;
        }
        return nonConstructChange+1;
    }
}