/*

You're given the root node of a Binary Tree. Write a function that returns
true if this Binary Tree is height balanced and
false if it isn't.

A Binary Tree is height balanced if for each node in the tree, the difference
between the height of its left subtree and the height of its right subtree is
at most 1.
Each BinaryTree node has an integer value, a
left child node, and a right child node. Children
nodes can either be BinaryTree nodes themselves or
None / null.

Sample Input
tree = 1
/   \
2     3
/   \     \
4     5     6
/   \
7     8
Sample Output
true
*/
class HeightBalancedTree{
    static class BinaryTree{
        int value;
        BinaryTree left;
        BinaryTree right;
        public BinaryTree(int value){
            this.value = value;
            this.left = left;
            this.right = right;
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
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.right = sixth;
        fifth.left = seventh;
        fifth.right = eighth;
        return first;

    }

    public static void main(String args[]){
        BinaryTree tree = createTree();
        boolean isBalanced = heightBalancedBinaryTree(tree);
        System.out.println(isBalanced);
    }

    static class TreeInfo{
        int height;
        boolean isBalanced;
        TreeInfo(int height, boolean isBalanced){
            this.height = height;
            this.isBalanced = isBalanced;
        }
    }

    public static TreeInfo heightBalancedBinaryTreeHelper(BinaryTree tree){
        if(tree == null) return new TreeInfo(0, true);
        TreeInfo leftInfo = heightBalancedBinaryTreeHelper(tree.left);
        TreeInfo rightInfo = heightBalancedBinaryTreeHelper(tree.right);
        int height = Math.max(leftInfo.height, rightInfo.height) + 1;
        boolean isBalanced = leftInfo.isBalanced && rightInfo.isBalanced
                && Math.abs(leftInfo.height - rightInfo.height) <= 1;
        return new TreeInfo(height, isBalanced);
    }
    public static boolean heightBalancedBinaryTree(BinaryTree tree){
        return heightBalancedBinaryTreeHelper(tree).isBalanced;
    }
}