/*

You're given a non-empty array of positive integers where each integer represents the
maximum number of steps you can take forward in the array. For example, if the
element at index 1 is 3, you can go from index
1 to index 2, 3, or 4.
Write a function that returns the minimum number of jumps needed to reach the
final index.

Note that jumping from index i to index i + x always
constitutes one jump, no matter how large x is.
Sample Input
array = [3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3]
Sample Output
4 // 3 --> (4 or 2) --> (2 or 3) --> 7 --> 3
*/
import java.util.*;
class MinNumberOfJumps{
    public static void main(String args[]){
        int array[] = {3, 4, 2, 1, 2, 3, 7, 1, 1, 1, 3};
        int jumpsByDP = minNumberOfJumpsByDP(array);
        System.out.println(jumpsByDP);
        int jumps = minNumberOfJumps(array);
        System.out.println(jumps);
    }

    public static int minNumberOfJumpsByDP(int[] array){
        int dp[] = new int[array.length];
        dp[0] = 0;
        for(int i=1;i<array.length;i++){
            dp[i] = i;
            for(int j=0;j<i;j++){
                if(j+array[j] >= i){
                    dp[i] = Math.min(dp[i], dp[j]+1);
                }
            }
        }
        return dp[array.length-1];
    }

    public static int minNumberOfJumps(int[] array){
        if(array.length == 1)
            return 0;
        int maxReach = array[0];
        int steps = array[0];
        int jumps = 0;
        for(int i=1;i<array.length-1;i++){
            maxReach = Math.max(maxReach, i+array[i]);
            steps--;
            if(steps == 0){
                jumps++;
                steps = maxReach-i;
            }
        }
        return jumps+1;
    }
}