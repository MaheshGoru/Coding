/*

You're given the root node of a Binary Tree, a target value of a
node that's contained in the tree, and a positive integer k.
Write a function that returns the values of all the nodes that are exactly
distance k from the node with target value.

The distance between two nodes is defined as the number of edges that must be
traversed to go from one node to the other. For example, the distance between
a node and its immediate left or right child is 1. The same holds
in reverse: the distance between a node and its parent is 1. In a
tree of three nodes where the root node has a left and right child, the left
and right children are distance 2 from each other.

Sample Input
tree = 1
/   \
2     3
/   \     \
4     5     6
/   \
7     8
k = 2
Sample output
[2, 7, 8] // These values could be ordered differently.
*/
import java.util.*;
class FindNodesDistancesK{
    static class BinaryTree{
        public int value;
        public BinaryTree left;
        public BinaryTree right;
        public BinaryTree(int value){
            this.value = value;
        }
    }

    public static void main(String args[]) {
        BinaryTree one = new BinaryTree(1);
        BinaryTree two = new BinaryTree(2);
        BinaryTree three = new BinaryTree(3);
        BinaryTree four = new BinaryTree(4);
        BinaryTree five = new BinaryTree(5);
        BinaryTree six = new BinaryTree(6);
        BinaryTree seven = new BinaryTree(7);
        BinaryTree eight = new BinaryTree(8);
        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.right = six;
        six.left = seven;
        six.right = eight;
        ArrayList<Integer> list = findNodesDistanceK(one, 3, 2);
        for(int i=0;i<list.size();i++){
            System.out.println(list.get(i));
        }
    }

    public static void updateParentNodes(BinaryTree root, BinaryTree parentNode, Map<BinaryTree,BinaryTree> parentNodes){
        if(root != null){
            parentNodes.put(root, parentNode);
            updateParentNodes(root.left, root, parentNodes);
            updateParentNodes(root.right, root, parentNodes);
        }
    }
    public static ArrayList<Integer> findNodesDistanceK(BinaryTree root, int target, int k){
        Map<BinaryTree, BinaryTree> parentNodes = new HashMap<>();
        updateParentNodes(root, null, parentNodes);
        BinaryTree node = findNode(root, target);
        Set<BinaryTree> visited = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        while(k >= 0){
            insertNodes(node, 0, k, result, visited);
            k--;
            node = parentNodes.get(node);
        }
        return result;
    }

    public static void insertNodes(BinaryTree node, int currentHeight, int maxHeight, ArrayList<Integer> result, Set<BinaryTree> visited){
        if(node == null)
            return;
        if(visited.contains(node))
            return;
        if(currentHeight == maxHeight){
            result.add(node.value);
        }
        if(currentHeight < maxHeight){
            visited.add(node);
            insertNodes(node.left, currentHeight+1, maxHeight, result, visited);
            insertNodes(node.right, currentHeight+1, maxHeight, result, visited);
        }
    }

    public static BinaryTree findNode(BinaryTree root, int target){
        if(root == null)
            return null;
        if(root.value == target)
            return root;
        BinaryTree left = findNode(root.left, target);
        if(left == null)
            return findNode(root.right, target);
        else
            return left;
    }
}