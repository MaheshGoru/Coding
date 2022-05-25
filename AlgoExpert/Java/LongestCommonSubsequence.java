/*

Write a function that takes in two strings and returns their longest common
subsequence.

A subsequence of a string is a set of characters that aren't necessarily
adjacent in the string but that are in the same order as they appear in the
string. For instance, the characters ["a", "c", "d"] form a
subsequence of the string "abcd", and so do the characters
["b", "d"]. Note that a single character in a string and the
string itself are both valid subsequences of the string.

You can assume that there will only be one longest common subsequence.
Sample Input
str1 = "ZXVVYZW"
str2 = "XKYKZPW"
Sample Output
["X", "Y", "Z", "W"]
*/
import java.util.*;
class LongestCommonSubsequence{
    public static void main(String args[]){
        String str1 = "ZXVVYZW";
        String str2 = "XKYKZPW";
        List<Character> lcs = longestCommonSubsequence(str1, str2);
        System.out.println(lcs);
    }
    public static List<Character> longestCommonSubsequence(String str1, String str2){
        int[][] lcs = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<=str1.length();i++){
            lcs[i][0] = 0;
        }
        for(int i=0;i<=str2.length();i++){
            lcs[0][i] = 0;
        }
        for(int i=1;i<= str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1) == str2.charAt(j-1)){
                    lcs[i][j] = lcs[i-1][j-1]+1;
                }else{
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }
        List<Character> res = new ArrayList<Character>();
        int row = str1.length();
        int col = str2.length();
        while(row != 0 && col != 0){
            if(lcs[row][col] == lcs[row-1][col]){
                row--;
            }else if(lcs[row][col-1] == lcs[row][col]){
                col--;
            }else{
                res.add(0,str1.charAt(row-1));
                row--;
                col--;
            }
        }
        return res;
    }
}