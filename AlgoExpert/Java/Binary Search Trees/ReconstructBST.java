/*

The pre-order traversal of a Binary Tree is a traversal technique that starts
at the tree's root node and visits nodes in the following order:
1.Current node
2.Left subtree
3.Right subtree

Given a non-empty array of integers representing the pre-order traversal of a
Binary Search Tree (BST), write a function that creates the relevant BST and
returns its root node.

The input array will contain the values of BST nodes in the order in which
these nodes would be visited with a pre-order traversal.
Each BST node has an integer value, a
left child node, and a right child node. A node is
said to be a valid BST node if and only if it satisfies the BST
property: its value is strictly greater than the values of every
node to its left; its value is less than or equal to the values
of every node to its right; and its children nodes are either valid
BST nodes themselves or None / null.
Sample Input
preOrderTraversalValues = [10, 4, 2, 1, 5, 17, 19, 18]
Sample Output
10
/    \
4      17
/   \      \
2     5     19
/           /
1           18
*/
import java.util.*;
class ReconstructBST{
    static class BST{
        public int value;
        public BST left = null;
        public BST right = null;
        public BST(int value){
            this.value = value;
        }
    }

    public static void inorderTraversal(BST node){
        if(node != null){
            inorderTraversal(node.left);
            System.out.print(node.value+" ");
            inorderTraversal(node.right);
        }
    }
    public static void main(String[] args){
        List<Integer> preOrderTraversalValues = Arrays.asList(10, 4, 2, 1, 5, 17, 19, 18);
        BST node = reconstructBst(preOrderTraversalValues);
        inorderTraversal(node);
    }

    // O(n^2) Time | O(n^2) Space
    public static BST reconstructBst1(List<Integer> preOrderTraversalValues){
        if(preOrderTraversalValues.size() == 0)
            return null;
        BST node = new BST(preOrderTraversalValues.get(0));
        List<Integer> leftValues = new ArrayList<Integer>();
        List<Integer> rightValues = new ArrayList<Integer>();
        for(int i=1;i<preOrderTraversalValues.size();i++){
            if(node.value > preOrderTraversalValues.get(i))
                leftValues.add(preOrderTraversalValues.get(i));
            else
                rightValues.add(preOrderTraversalValues.get(i));
        }
        node.left = reconstructBst(leftValues);
        node.right = reconstructBst(rightValues);
        return node;
    }

    // O(n^2) Time | O(n) Space
    public static BST reconstructBst2(List<Integer> preOrderTraversalValues){
        if(preOrderTraversalValues.size() == 0)
            return null;
        BST node = new BST(preOrderTraversalValues.get(0));
        int rightIdx = preOrderTraversalValues.size();
        for(int i=1;i<preOrderTraversalValues.size();i++){
            if(preOrderTraversalValues.get(i) >= node.value){
                rightIdx = i;
                break;
            }
        }
        node.left = reconstructBst(preOrderTraversalValues.subList(1, rightIdx));
        node.right = reconstructBst(preOrderTraversalValues.subList(rightIdx, preOrderTraversalValues.size()));
        return node;
    }

    // O(n) Time | O(n) Space
    public static BST reconstructBst(List<Integer> preOrderTraversalValues){
        return reconstructBstHelper(Integer.MIN_VALUE, Integer.MAX_VALUE, new TreeInfo(0), preOrderTraversalValues);
    }

    static class TreeInfo{
        int rootIdx;
        public TreeInfo(int rootIdx){
            this.rootIdx = rootIdx;
        }
    }

    public static BST reconstructBstHelper(int minValue, int maxValue, TreeInfo treeInfo, List<Integer> preOrderTraversalValues){
        if(treeInfo.rootIdx == preOrderTraversalValues.size())
            return null;
        int currentValue = preOrderTraversalValues.get(treeInfo.rootIdx);
        if(currentValue < minValue || currentValue >= maxValue)
            return null;
        BST node = new BST(currentValue);
        treeInfo.rootIdx += 1;
        node.left = reconstructBstHelper(minValue, currentValue, treeInfo, preOrderTraversalValues);
        node.right = reconstructBstHelper(currentValue, maxValue, treeInfo, preOrderTraversalValues);
        return node;
    }
}