/*

You're given two positive integers representing the width and height of a
grid-shaped, rectangular graph. Write a function that returns the number of
ways to reach the bottom right corner of the graph when starting at the top
left corner. Each move you take must either go down or right. In other words,
you can never move up or left in the graph.

For example, given the graph illustrated below, with
width = 2 and height = 3, there are three ways to
reach the bottom right corner when starting at the top left corner:
_ _
|_|_|
|_|_|
|_|_|
Down, Down, Right
Right, Down, Down
Down, Right, Down

Note: you may assume that width * height >= 2. In other words,
the graph will never be a 1x1 grid.
Sample Input
width = 4
height = 3
Sample Output
10
*/
class NumberOfWaysToTraverseGraph{
    public static void main(String args[]){
        int width = 4;
        int height = 3;
        int noOfWaysByRecursion = numberOfWaysToTraverseGraphByRecursion(width, height);
        System.out.println(noOfWaysByRecursion);
        int noOfWaysByDP = numberOfWaysToTraverseGraphByDP(width, height);
        System.out.println(noOfWaysByDP);
        int noOfWaysByMathsTrick = numberOfWaysToTraverseGraphByMathsTrick(width, height);
        System.out.println(noOfWaysByMathsTrick);
    }

    public static int numberOfWaysToTraverseGraphByRecursion(int width, int height){
        if(width == 1 || height == 1)
            return 1;
        return numberOfWaysToTraverseGraphByRecursion(width-1, height) + numberOfWaysToTraverseGraphByRecursion(width, height-1);
    }

    public static int numberOfWaysToTraverseGraphByDP(int width, int height){
        int ways[][] = new int[height][width];
        for(int i=0;i<height;i++){
            ways[i][0] = 1;
        }
        for(int i=0;i<width;i++){
            ways[0][i] = 1;
        }
        for(int i=1;i<height;i++){
            for(int j=1;j<width;j++){
                ways[i][j] = ways[i-1][j] + ways[i][j-1];
            }
        }
        return ways[height-1][width-1];
    }

    public static int factorial(int n){
        if(n<=1) return 1;
        return n * factorial(n-1);
    }
    public static int numberOfWaysToTraverseGraphByMathsTrick(int width, int height){
        int totalFactorial = factorial(width+height-2);
        int rightFactorial = factorial(width-1);
        int downFactorial = factorial(height-1);
        return totalFactorial / (rightFactorial * downFactorial);
    }
}
