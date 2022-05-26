/*

Write a function that takes in a non-empty string and that returns a boolean
representing whether the string is a palindrome.

A palindrome is defined as a string that's written the same forward and
backward. Note that single-character strings are palindromes.
Sample Input:
string  = "abcdcba"
Sample Output:
true
*/
class PalindromCheck{
    public static void main(String args[]){
        String s = "abcdcba";
        boolean isPalindromeString =  isPalindrome(s);
        System.out.println(isPalindromeString);
    }
    public static boolean isPalindrome(String s){
        int leftIdx = 0;
        int rightIdx = s.length() - 1;
        while(leftIdx < rightIdx){
            if(s.charAt(leftIdx) != s.charAt(rightIdx)) return false;
            leftIdx++;
            rightIdx--;
        }
        return true;
    }
}