/*

You're given two positive integers representing the height of a staircase and
the maximum number of steps that you can advance up the staircase at a time.
Write a function that returns the number of ways in which you can climb the
staircase.

For example, if you were given a staircase of height = 3 and
maxSteps = 2 you could climb the staircase in 3 ways. You could
take 1 step, 1 step, then 1 step, you could also take
1 step, then 2 steps, and you could take 2 steps, then 1 step.
Note that maxSteps <= height will always be true.
Sample Input
height = 4
maxSteps = 2
Sample Output
5
*/
class StaircaseTraversal{
    public static int staircaseTraversal(int height, int maxHeight){
        if(height == 0)
            return 1;
        if(height < 0)
            return 0;
        int numberOfWays = 0;
        for(int i=1;i<=maxHeight;i++){
            numberOfWays += staircaseTraversal(height-i, maxHeight);
        }
        return numberOfWays;
    }
    public static void main(String args[]){
        int numberOfWays = staircaseTraversal(4, 2);
        System.out.println(numberOfWays);
    }
}