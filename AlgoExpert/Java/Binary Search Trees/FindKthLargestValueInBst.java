/*

Write a function that takes in a Binary Search Tree (BST) and a positive
integer k and returns the kth largest integer contained in the
BST.
You can assume that there will only be integer values in the BST and that
k is less than or equal to the number of nodes in the tree.
Also, for the purpose of this question, duplicate integers will be treated as
distinct values. In other words, the second largest value in a BST containing
values {5, 7, 7} will be 7—not 5.
Each BST node has an integer value, a
left child node, and a right child node. A node is
said to be a valid BST node if and only if it satisfies the BST
property: its value is strictly greater than the values of every
node to its left; its value is less than or equal to the values
of every node to its right; and its children nodes are either valid
BST nodes themselves or None / null.
Sample Input
tree =   15
/     \
5      20
/   \   /   \
2     5 17   22
/   \
1     3
k = 3
Sample Output
17
*/
import java.util.*;
class FindKthLargestValueInBst{
    static class BST{
        int value;
        BST left;
        BST right;
        public BST(int value){
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    public static void main(String args[]){
        BST tree = createTree();
        int largest = findKthLargestValueInBst(tree, 3);
        System.out.println(largest);
    }
    public static int findKthLargestValueInBst(BST tree, int k){
        List<Integer> array = Arrays.asList(0,0);
        findKthLargestValueInBstHelper(tree, k, array);
        return array.get(1);
    }
    public static void findKthLargestValueInBstHelper(BST tree, int k, List<Integer> array){
        if(tree == null || array.get(0) > k) return;
        findKthLargestValueInBstHelper(tree.right, k, array);
        if(array.get(0) < k){
            array.set(0, array.get(0)+1);
            array.set(1, tree.value);
            findKthLargestValueInBstHelper(tree.left, k, array);
        }
    }
    public static BST createTree(){
        BST node1 = new BST(10);
        BST node2 = new BST(5);
        BST node3 = new BST(15);
        BST node4 = new BST(2);
        BST node5 = new BST(5);
        BST node6 = new BST(13);
        BST node7 = new BST(22);
        BST node8 = new BST(1);
        BST node9 = new BST(14);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node4.left = node8;
        node6.right = node9;
        return node1;
    }
}