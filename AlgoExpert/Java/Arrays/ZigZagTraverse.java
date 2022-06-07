/*

Write a function that takes in an n x m two-dimensional array (that can be
square-shaped when n == m) and returns a one-dimensional array of all the
array's elements in zigzag order.

Zigzag order starts at the top left corner of the two-dimensional array, goes
down by one element, and proceeds in a zigzag pattern all the way to the
bottom right corner.
Sample Input
array  = [
[1,  3,  4, 10],
[2,  5,  9, 11],
[6,  8, 12, 15],
[7, 13, 14, 16],
]
Sample Output
[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
*/
import java.util.*;
class ZigZagTraverse{
    public static void main(String[] args){
        List<List<Integer>> array = Arrays.asList(
                Arrays.asList(1,3,4,10),
                Arrays.asList(2,5,9,11),
                Arrays.asList(6,8,12,15),
                Arrays.asList(7,13,14,16));
        List<Integer> zigZagList = zigzagTraverse(array);
        for(int i=0;i<zigZagList.size();i++){
            System.out.print(zigZagList.get(i)+" ");
        }
        System.out.println();
    }

    public static List<Integer> zigzagTraverse(List<List<Integer>> array){
        List<Integer> res = new ArrayList<>();
        boolean goDown = true;
        int row = 0;
        int col = 0;
        while(row >= 0 && row < array.size() && col >= 0 && col < array.get(row).size()){
            res.add(array.get(row).get(col));
            if(goDown){
                if(col == 0 || row == array.size()-1){
                    goDown = false;
                    if(row == array.size()-1)
                        col++;
                    else
                        row++;
                }else{
                    row++;
                    col--;
                }
            }else{
              if(row == 0 || col == array.get(row).size()-1){
                  goDown = true;
                  if(col == array.get(row).size()-1)
                      row++;
                  else
                      col++;
              }else{
                  col++;
                  row--;
              }
            }
        }
        return res;
    }
}