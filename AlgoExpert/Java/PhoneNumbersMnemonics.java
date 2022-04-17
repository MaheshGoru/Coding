/*
If you open the keypad of your mobile phone, it'll likely look like this:
----- ----- -----
|     |     |     |
|  1  |  2  |  3  |
|     | abc | def |
----- ----- -----
|     |     |     |
|  4  |  5  |  6  |
| ghi | jkl | mno |
----- ----- -----
|     |     |     |
|  7  |  8  |  9  |
| pqrs| tuv | wxyz|
----- ----- -----
|     |
|  0  |
|     |
-----

Almost every digit is associated with some letters in the alphabet; this
allows certain phone numbers to spell out actual words. For example, the phone
number 8464747328 can be written as timisgreat;
similarly, the phone number 2686463 can be written as
antoine or as ant6463.

It's important to note that a phone number doesn't represent a single sequence
of letters, but rather multiple combinations of letters. For instance, the
digit 2 can represent three different letters (a, b, and c).
A mnemonic is defined as a pattern of letters, ideas, or associations that
assist in remembering something. Companies oftentimes use a mnemonic for their
phone number to make it easier to remember.
Given a stringified phone number of any non-zero length, write a function that
returns all mnemonics for this phone number, in any order.

For this problem, a valid mnemonic may only contain letters and the digits
0 and 1. In other words, if a digit is able to be
represented by a letter, then it must be. Digits 0 and
1 are the only two digits that don't have letter representations
on the keypad.
Note that you should rely on the keypad illustrated above for digit-letter
associations.
Sample Input
phoneNumber = "1905"
Sample Output
[
"1w0j",
"1w0k",
"1w0l",
"1x0j",
"1x0k",
"1x0l",
"1y0j",
"1y0k",
"1y0l",
"1z0j",
"1z0k",
"1z0l",
]
// The mnemonics could be ordered differently.
*/
import java.util.*;
class PhoneNumbersMnemonics{
    public static void phoneNumberMnemonicsHelper(String phoneNumber, char[] currentMnemonic, ArrayList<String> mnemonics, Map<Character, List<Character>> map, int index){
        if(index == phoneNumber.length()){
            mnemonics.add(new String(currentMnemonic));
            return;
        }
        List<Character> values = map.get(phoneNumber.charAt(index));
        for(Character elem: values){
            currentMnemonic[index] = elem;
            phoneNumberMnemonicsHelper(phoneNumber, currentMnemonic, mnemonics, map, index+1);
        }
    }
    public static ArrayList<String> phoneNumberMnemonics(String phoneNumber){
        ArrayList<String> mnemonics = new ArrayList<String>();
        Map<Character, List<Character>> map = new HashMap<>();
        map.put('1', Arrays.asList('1'));
        map.put('2', Arrays.asList('a','b','c'));
        map.put('3', Arrays.asList('d','e','f'));
        map.put('4', Arrays.asList('g','h','i'));
        map.put('5', Arrays.asList('j','k','l'));
        map.put('6', Arrays.asList('m','n','o'));
        map.put('7', Arrays.asList('p','q','r','s'));
        map.put('8', Arrays.asList('t','u','v'));
        map.put('9', Arrays.asList('w','x','y','z'));
        map.put('0', Arrays.asList('0'));
        char[] currentMnemonic = new char[phoneNumber.length()];
        phoneNumberMnemonicsHelper(phoneNumber, currentMnemonic, mnemonics, map, 0);
        return mnemonics;
    }
    public static void main(String args[]){
        String phoneNumber = "1905";
        ArrayList<String> mnemonics = phoneNumberMnemonics(phoneNumber);
        for(String mnemonic: mnemonics){
            System.out.println(mnemonic);
        }
    }
}