/*

Given an array of distinct positive integers representing coin denominations and a
single non-negative integer n  representing a target amount of
money, write a function that returns the number of ways to make change for
that target amount using the given coin denominations.
Note that an unlimited amount of coins is at your disposal.
Sample Input:
n = 6
denoms = [1, 5]
Sample Output:
2 // 1x1 + 1x5 and 6x1

*/
class NumberOfWaysToMakeChange{
    public static void main(String args[]){
        int[] denoms = {1, 5};
        int n = 6;
        int noOfWays = numberOfWaysToMakeChangeByRecursion(n, denoms);
        System.out.println(noOfWays);
        int noOfWaysByDP = numberOfWaysToMakeChangeByDP(n, denoms);
        System.out.println(noOfWaysByDP);
    }

    public static int numberOfWaysToMakeChangeHelper(int n, int index, int[] denoms){
        if(n == 0) return 1;
        int sum = 0;
        for(int i=index;i<denoms.length;i++){
            if(denoms[i] <= n) {
                sum += numberOfWaysToMakeChangeHelper(n - denoms[i], i, denoms);
            }
        }
        return sum;
    }

    public static int numberOfWaysToMakeChangeByRecursion(int n, int[] denoms){
        return numberOfWaysToMakeChangeHelper(n, 0, denoms);
    }

    public static int numberOfWaysToMakeChangeByDP(int n, int[] denoms){
        int ways[] = new int[n+1];
        ways[0] = 1;
        for(int i=0; i<denoms.length;i++){
            for(int j=1;j<=n;j++){
                if(denoms[i] <= j) {
                    ways[j] += ways[j-denoms[i]];
                }
            }
        }
        return ways[n];
    }
}