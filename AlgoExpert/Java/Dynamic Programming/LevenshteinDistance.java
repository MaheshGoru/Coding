/*

Write a function that takes in two strings and returns the minimum number of
edit operations that need to be performed on the first string to obtain the
second string.

There are three edit operations: insertion of a character, deletion of a
character, and substitution of a character for another.
Sample Input
str1 = "abc"
str2 = "yabd"
Sample Output
2 // insert "y"; substitute "c" for "d"
*/
import java.util.*;
class LevenshteinDistance{
    public static void main(String args[]){
        String str1 = "abc";
        String str2 = "yabd";
        int distanceByRecursion = levenshteinDistanceByRecursion(str1, str2);
        System.out.println(distanceByRecursion);
        int distanceByDP = levenshteinDistanceByDP(str1, str2);
        System.out.println(distanceByDP);
    }

    public static int levenshteinDistanceHelper(String str1, String str2, int idx1, int idx2){
        if(idx1 == 0) return idx2;
        if(idx2 == 0) return idx1;
        if(str1.charAt(idx1-1) == str2.charAt(idx2-1)) return levenshteinDistanceHelper(str1, str2, idx1-1, idx2-1);
        return Math.min(Math.min(levenshteinDistanceHelper(str1, str2, idx1-1, idx2),
                levenshteinDistanceHelper(str1, str2, idx1, idx2-1)),
        levenshteinDistanceHelper(str1, str2, idx1-1, idx2-1))+1;
    }

    public static int levenshteinDistanceByRecursion(String str1, String str2){
        return levenshteinDistanceHelper(str1, str2, str1.length(), str2.length());
    }

    public static int levenshteinDistanceByDP(String str1,String str2){
        int distances[][] = new int[str1.length()+1][str2.length()+1];
        for(int i=0;i<=str1.length();i++)
            distances[i][0] = i;
        for(int i=0;i<=str2.length();i++)
            distances[0][i] = i;

        for(int i=1;i<=str1.length();i++){
            for(int j=1;j<=str2.length();j++){
                if(str1.charAt(i-1) == str2.charAt(j-1))
                    distances[i][j] = distances[i-1][j-1];
                else
                    distances[i][j] = Math.min(Math.min(distances[i-1][j], distances[i][j-1]), distances[i-1][j-1])+1;
            }
        }
        return distances[str1.length()][str2.length()];
    }
}