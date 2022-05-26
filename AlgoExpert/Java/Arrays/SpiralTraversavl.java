//
//Write a function that takes in an n x m two-dimensional array (that can be
//square-shaped when n == m) and returns a one-dimensional array of all the
//array's elements in spiral order.
//
//Spiral order starts at the top left corner of the two-dimensional array, goes
//to the right, and proceeds in a spiral pattern all the way until every element
//has been visited.
//Sample Input:
//array  = [
//            [1,   2,  3, 4],
//            [12, 13, 14, 5],
//            [11, 16, 15, 6],
//            [10,  9,  8, 7],
//        ]
//Sample Output:
//[1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16]
import java.util.*;
class SpiralTraversal{
    public static void main(String args[]){
        int[][] array = new int[][]{{1,2,3,4},{12,13,14,15},{11,16,15,6},{10,9,8,7}};
        List<Integer> list = spiralTraverse(array);
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
    }
    public static List<Integer> spiralTraverse(int[][] array){
        List<Integer> result = new ArrayList<Integer>();
        int topRow = 0;
        int bottomRow = array.length-1;
        int leftColumn = 0;
        int rightColumn = array[0].length-1;
        while(topRow <= bottomRow && leftColumn <= rightColumn){
            for(int i=leftColumn;i<=rightColumn;i++){
                result.add(array[topRow][i]);
            }
            for(int i=topRow+1;i<=bottomRow;i++){
                result.add(array[i][rightColumn]);
            }
            for(int i=rightColumn-1;i>=leftColumn;i--){
                if(topRow == bottomRow) break;
                result.add(array[bottomRow][i]);
            }
            for(int i=bottomRow-1;i>topRow;i--){
                if(leftColumn == rightColumn) break;
                result.add(array[i][leftColumn]);
            }
            topRow++;
            rightColumn--;
            bottomRow--;
            leftColumn++;
        }
        return result;
    }
}