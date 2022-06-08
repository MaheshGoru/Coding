/*

You're given an array of integers where each integer represents a jump of its
value in the array. For instance, the integer 2  represents a jump
of two indices forward in the array; the integer -3 represents a
jump of three indices backward in the array.

If a jump spills past the array's bounds, it wraps over to the other side. For
instance, a jump of -1 at index 0 brings us to the last index in
the array. Similarly, a jump of 1 at the last index in the array brings us to
index 0.

Write a function that returns a boolean representing whether the jumps in the
array form a single cycle. A single cycle occurs if, starting at any index in
the array and following the jumps, every element in the array is visited
exactly once before landing back on the starting index.
Sample Input
array = [2, 3, 1, -4, -4, 2]
Sample Output
true
*/
import java.util.*;
class SingleCycleCheck{
    public static void main(String args[]){
        int[] array = {2, 3, 1, -4, -4, 2};
        boolean res = hasSingleCycle(array);
        System.out.println(res);
    }

    // O(n) Time | O(n) space
    public static boolean hasSingleCycle1(int[] array){
        boolean[] visited = new boolean[array.length];
        Arrays.fill(visited, false);
        int idx = 0;
        while(!visited[idx]){
            visited[idx] = true;
            int nextIdx = (idx+array[idx]) % array.length;
            idx = nextIdx >= 0 ? nextIdx : nextIdx + array.length;
        }
        for(int i=0;i<array.length;i++){
            if(!visited[i])
                return false;
        }
        return idx == 0;
    }
    // O(n) Time | O(1) Space
    public static boolean hasSingleCycle(int[] array){
        int count = 0;
        int idx = 0;
        while(count < array.length){
            if(count > 0 && idx == 0) return false;
            int nextIdx = (idx+array[idx]) % array.length;
            idx = nextIdx >= 0 ? nextIdx : nextIdx + array.length;
            count++;
        }
        return idx == 0;
    }
}