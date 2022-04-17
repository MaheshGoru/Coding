/*

The Fibonacci sequence is defined as follows: the first number of the sequence
is 0, the second number is 1, and the nth number is the sum of the (n - 1)th
and (n - 2)th numbers. Write a function that takes in an integer n and returns the nth Fibonacci number.

Important note: the Fibonacci sequence is often defined with its first two
numbers as F0 = 0 and F1 = 1. For the purpose of
this question, the first Fibonacci number is F0; therefore,
getNthFib(1) is equal to F0, getNthFib(2)
is equal to F1, etc..
Sample Input1:
n = 2
Sample Output1:
1 //0,1
Sample Input2:
n = 6
5 //0,1,1,2,3,5
*/
class NthFibonacci{
    public static void main(String args[]){
        int n=6;
        int val = getNthFib(n);
        System.out.println(val);
    }
//    public static int getNthFib(int n){
//        if(n == 1 || n == 2)
//            return n-1;
//        return getNthFib(n-1) + getNthFib(n-2);
//    }
    public static int getNthFib(int n){
        if(n==1 || n==2)
            return n-1;
        int first = 0;
        int second = 1;
        for(int i=3;i<=n;i++){
            int temp = first+second;
            first = second;
            second = temp;
        }
        return second;
    }
}