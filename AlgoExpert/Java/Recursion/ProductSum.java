/*

Write a function that takes in a "special" array and returns its product sum.

A "special" array is a non-empty array that contains either integers or other
"special" arrays. The product sum of a "special" array is the sum of its
elements, where "special" arrays inside it are summed themselves and then
multiplied by their level of depth.

The depth of a "special" array is how far nested it is. For instance, the
depth of [] is 1; the depth of the inner array in
[[]] is 2; the depth of the innermost array in
[[[]]] is 3.
Therefore, the product sum of [x, y] is x + y; the
product sum of [x, [y, z]] is x + 2 * (y + z); the
product sum of [x, [y, [z]]] is x + 2 * (y + 3z).
Sample Input:
array = [5, 2, [7, -1], 3, [6, [-13, 8], 4]]
Sample Output:
12
*/
import java.util.*;
class ProductSum{
    public static void main(String args[]){
        List<Object> array = new ArrayList<>();
        array.add(5);
        array.add(2);
        List<Object> temp = new ArrayList<>();
        temp.add(7);
        temp.add(-1);
        array.add(temp);
        array.add(3);
        List<Object> temp1 = new ArrayList<>();
        temp1.add(6);
        List<Object> temp2 = new ArrayList<>();
        temp2.add(-13);
        temp2.add(8);
        temp1.add(temp2);
        temp1.add(4);
        array.add(temp1);
        int val = productSum(array);
        System.out.println(val);
    }
    public static int productSumHelper(List<Object> array, int depth){
        int sum = 0;
        for(int i=0;i<array.size();i++){
            Object el = array.get(i);
            if(el instanceof ArrayList){
                sum += productSumHelper((ArrayList<Object>)el, depth+1);
            }else {
                sum += (int)el;
            }
        }
        return sum * depth;
    }
    public static int productSum(List<Object> array){
        return productSumHelper(array, 1);
    }
}