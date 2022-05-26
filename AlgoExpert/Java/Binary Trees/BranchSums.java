/*

Write a function that takes in a Binary Tree and returns a list of its branch
sums ordered from leftmost branch sum to rightmost branch sum.

A branch sum is the sum of all values in a Binary Tree branch. A Binary Tree
branch is a path of nodes in a tree that starts at the root node and ends at
any leaf node.

Each BinaryTree node has an integer value, a
left child node, and a right child node. Children
nodes can either be BinaryTree nodes themselves or
None / null.
Sample Input
tree =     1
/     \
2       3
/   \    /  \
4     5  6    7
/   \  /
8    9 10
Sample Output
[15, 16, 18, 10, 11]
// 15 == 1 + 2 + 4 + 8
// 16 == 1 + 2 + 4 + 9
// 18 == 1 + 2 + 5 + 10
// 10 == 1 + 3 + 6
// 11 == 1 + 3 + 7
*/
import java.util.*;
class BranchSums{
    static class BinaryTree{
        int value;
        BinaryTree left;
        BinaryTree right;
        public BinaryTree(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    public static BinaryTree createTree(){
        BinaryTree first = new BinaryTree(1);
        BinaryTree second = new BinaryTree(2);
        BinaryTree third = new BinaryTree(3);
        BinaryTree fourth = new BinaryTree(4);
        BinaryTree fifth = new BinaryTree(5);
        BinaryTree sixth = new BinaryTree(6);
        BinaryTree seventh = new BinaryTree(7);
        BinaryTree eight = new BinaryTree(8);
        BinaryTree nine = new BinaryTree(9);
        BinaryTree tenth = new BinaryTree(10);
        fifth.left = tenth;
        fourth.right = nine;
        fourth.left = eight;
        third.left = sixth;
        third.right = seventh;
        second.left = fourth;
        second.right = fifth;
        first.left = second;
        first.right = third;
        return first;
    }

    public static void main(String args[]){
        BinaryTree root = createTree();
        List<Integer> array = branchSums(root);
        for(int i=0;i<array.size();i++){
            System.out.print(array.get(i)+" ");
        }
    }

    public static List<Integer> branchSums(BinaryTree root){
        List<Integer> array = new ArrayList<>();
        branchSumsHelper(root, 0, array);
        return array;
    }

    public static void branchSumsHelper(BinaryTree root, int sum, List<Integer> array){
        if(root == null) return;
        int currentValue = sum + root.value;
        if(root.left == null && root.right == null)
            array.add(currentValue);
        branchSumsHelper(root.left, currentValue, array);
        branchSumsHelper(root.right, currentValue, array);
    }
}