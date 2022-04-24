/*

Write three functions that take in a Binary Search Tree (BST) and an empty
array, traverse the BST, add its nodes' values to the input array, and return
that array. The three functions should traverse the BST using the in-order,
pre-order, and post-order tree-traversal techniques, respectively.

If you're unfamiliar with tree-traversal techniques, we recommend watching the
Conceptual Overview section of this question's video explanation before
starting to code.
Each BST node has an integer value, a
left child node, and a right child node. A node is
said to be a valid BST node if and only if it satisfies the BST
property: its value is strictly greater than the values of every
node to its left; its value is less than or equal to the values
of every node to its right; and its children nodes are either valid
BST nodes themselves or None / null.
Sample Input
tree =   10
/     \
5      15
/   \       \
2     5       22
/
1
array = []
Sample Output
inOrderTraverse: [1, 2, 5, 5, 10, 15, 22]
preOrderTraverse: [10, 5, 2, 1, 5, 15, 22]
postOrderTraverse: [1, 2, 5, 5, 22, 15, 10]
*/
import java.util.*;
class BSTTraversal{
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
    public static void main(String args[]){
        BST tree = createTree();
        List<Integer> array = new ArrayList<>();
        array = inOrderTraverse(tree, array);
        System.out.print("Inorder Traverse : ");
        for(int i=0;i<array.size();i++)
            System.out.print(array.get(i)+" ");
        System.out.println();
        array = new ArrayList<>();
        array = preOrderTraverse(tree, array);
        System.out.print("Preorder Traverse : ");
        for(int i=0;i<array.size();i++)
            System.out.print(array.get(i)+" ");
        System.out.println();
        array = new ArrayList<>();
        array = postOrderTraverse(tree, array);
        System.out.print("Postorder Traverse : ");
        for(int i=0;i<array.size();i++)
            System.out.print(array.get(i)+" ");
        System.out.println();
    }
    public static List<Integer> inOrderTraverse(BST tree, List<Integer> array){
        if(tree != null) {
            inOrderTraverse(tree.left, array);
            array.add(tree.value);
            inOrderTraverse(tree.right, array);
        }
        return array;
    }
    public static List<Integer> preOrderTraverse(BST tree, List<Integer> array){
        if(tree != null) {
            array.add(tree.value);
            preOrderTraverse(tree.left, array);
            preOrderTraverse(tree.right, array);
        }
        return array;
    }
    public static List<Integer> postOrderTraverse(BST tree, List<Integer> array){
        if(tree != null) {
            postOrderTraverse(tree.left, array);
            postOrderTraverse(tree.right, array);
            array.add(tree.value);
        }
        return array;
    }
}