/*

Write a function that takes in a string of lowercase English-alphabet letters
and returns the index of the string's first non-repeating character.

The first non-repeating character is the first character in a string that
occurs only once.
If the input string doesn't have any non-repeating characters, your function
should return -1.
Sample Input:
string  = "abcdcaf"
Sample Output:
1
*/
class FirstNonRepeatingCharacter{
    public static void main(String args[]){
        String s = "abcdcaf";
        int nonRepeatingCharacterIndex = firstNonRepeatingCharacter(s);
        System.out.println(nonRepeatingCharacterIndex);
    }
    public static int firstNonRepeatingCharacter(String s){
        int[] map = new int[26];
        for(int i=0;i<26;i++){
            map[i] = 0;
        }
        for(int i=0;i<s.length();i++){
            map[s.charAt(i)-97] += 1;
        }
        for(int i=0;i<s.length();i++){
            if(map[s.charAt(i)-97] == 1)
                return i;
        }
        return -1;
    }
}