/*

Given a string representation of the first n digits of Pi and a list of
positive integers (all in string format), write a function that returns the
smallest number of spaces that can be added to the n digits of Pi such that
all resulting numbers are found in the list of integers.

Note that a single number can appear multiple times in the resulting numbers.
For example, if Pi is "3141" and the numbers are
["1", "3", "4"], the number "1" is allowed to appear
twice in the list of resulting numbers after three spaces are added:
"3 | 1 | 4 | 1".

If no number of spaces to be added exists such that all resulting numbers are
found in the list of integers, the function should return
-1.
Sample Input
pi = "3141592653589793238462643383279",
numbers = ["314159265358979323846", "26433", "8", "3279", "314159265", "35897932384626433832", "79"]
Sample Output
2 // "314159265 | 35897932384626433832 | 79"
*/
import java.util.*;
class NumbersInPI{
    public static void main(String args[]){
        String pi = "3141592653589793238462643383279";
        String[] numbers = {"314159265358979323846", "26433", "8", "3279", "314159265", "35897932384626433832", "79"};
        int minSpacesByRecursion = numbersInPiByRecursion(pi, numbers);
        System.out.println(minSpacesByRecursion);
        int minSpacesByDP = numbersInPiByDP(pi, numbers);
        System.out.println(minSpacesByDP);
    }

    public static int numbersInPiByRecursion(String pi, String[] numbers){
        Set<String> numbersSet = new HashSet<>();
        for(int i=0;i<numbers.length;i++){
            numbersSet.add(numbers[i]);
        }
        int minSpaces = numbersInPiHelper(pi, numbersSet, 0);
        return minSpaces == pi.length() ? -1 : minSpaces;
    }

    public static int numbersInPiHelper(String pi, Set<String> numbersInSet, int index){
        if(index == pi.length()) return -1;
        int spaces = pi.length();
        for(int i=index;i<pi.length();i++){
            String subString = pi.substring(index, i+1);
            if(numbersInSet.contains(subString)){
                spaces = Math.min(spaces, 1+numbersInPiHelper(pi, numbersInSet, i+1));
            }
        }
        return spaces;
    }

    public static int numbersInPiByDP(String pi, String[] numbers){
        Set<String> numbersSet = new HashSet<>();
        for(int i=0;i<numbers.length;i++){
            numbersSet.add(numbers[i]);
        }
        Map<Integer, Integer> cache = new HashMap<>();
        for(int i=0;i<pi.length()-1;i++){
            getMinSpaces(pi, numbersSet, cache, i);
        }
        return cache.get(0) == pi.length() ? -1 : cache.get(0);
    }

    public static int getMinSpaces(String pi, Set<String> numbers, Map<Integer, Integer> cache, int idx){
        if(idx == pi.length()) return -1;
        int minSpaces = pi.length();
        if(cache.containsKey(idx)) return cache.get(idx);
        for(int i=idx;i<pi.length();i++){
            String subString = pi.substring(idx, i+1);
            if(numbers.contains(subString)){
                minSpaces = Math.min(minSpaces, 1+getMinSpaces(pi, numbers, cache, i+1));
            }
        }
        cache.put(idx, minSpaces);
        return cache.get(idx);
    }
}