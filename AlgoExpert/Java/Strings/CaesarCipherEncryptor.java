/*
Given a non-empty string of lowercase letters and a non-negative integer
representing a key, write a function that returns a new string obtained by
shifting every letter in the input string by k positions in the alphabet,
where k is the key.

Note that letters should "wrap" around the alphabet; in other words, the
letter z shifted by one returns the letter a.
Sample Input:
string = "xyz"
key = 2
Sample Output:
zab
*/
class CaesarCipherEncryptor{
    public static void main(String args[]){
        String s = "xyz";
        int key = 2;
        String encryptedString = caesarCypherEncryptor(s, key);
        System.out.println(encryptedString);
    }
    public static String caesarCypherEncryptor(String s, int key){
        key = key % 26;
        StringBuffer res = new StringBuffer();
        for(int i=0;i<s.length();i++){
            int temp = s.charAt(i) + key;
            int value = temp > 122 ? 96 + (temp % 122) : temp;
            res.append((char)value);
        }
        return res.toString();
    }
}