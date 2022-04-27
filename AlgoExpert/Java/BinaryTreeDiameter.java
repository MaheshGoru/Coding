/*

Write a function that takes in a Binary Tree and returns its diameter. The
diameter of a binary tree is defined as the length of its longest path, even
if that path doesn't pass through the root of the tree.

A path is a collection of connected nodes in a tree, where no node is
connected to more than two other nodes. The length of a path is the number of
edges between the path's first node and its last node.

Each BinaryTree node has an integer value, a
left child node, and a right child node. Children
nodes can either be BinaryTree nodes themselves or
None / null.
Sample Input
tree =        1
/   \
3     2
/   \
7     4
/       \
8         5
/           \
9             6
Sample Output
6
// 9 -> 8 -> 7 -> 3 -> 4 -> 5 -> 6
// There are 6 edges between the
// first node and the last node
// of this tree's longest path.
*/
class BinaryTreeDiameter{
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
        BinaryTree eighth = new BinaryTree(8);
        BinaryTree ninth = new BinaryTree(9);
        first.left = third;
        first.right = second;
        third.left = seventh;
        third.right = fourth;
        seventh.left = eighth;
        eighth.left = ninth;
        fourth.right = fifth;
        fifth.right = sixth;
        return first;
    }
    public static void main(String args[]){
        BinaryTree tree = createTree();
        int diameter = binaryTreeDiameter(tree);
        System.out.println(diameter);
    }

    static class TreeInfo{
        int maxHeight;
        int diameter;
        public TreeInfo(int maxHeight, int diameter){
            this.maxHeight = maxHeight;
            this.diameter = diameter;
        }
    }
    public static TreeInfo binaryTreeDiameterHelper(BinaryTree tree){
        if(tree == null) return new TreeInfo(0,0);
        TreeInfo leftInfo = binaryTreeDiameterHelper(tree.left);
        TreeInfo rightInfo = binaryTreeDiameterHelper(tree.right);
        int maxHeight = Math.max(leftInfo.maxHeight, rightInfo.maxHeight);
        int diameter = Math.max(leftInfo.maxHeight+rightInfo.maxHeight, Math.max(leftInfo.diameter, rightInfo.diameter));
        return new TreeInfo(maxHeight+1, diameter);
    }

    public static int binaryTreeDiameter(BinaryTree tree){
        return binaryTreeDiameterHelper(tree).diameter;
    }
}