/*

Write a function that takes in a Binary Tree and returns its max path sum.

A path is a collection of connected nodes in a tree, where no node is
connected to more than two other nodes; a path sum is the sum of the values of
the nodes in a particular path.
Each BinaryTree node has an integer value, a
left child node, and a right child node. Children
nodes can either be BinaryTree nodes themselves or
None / null.
Sample Input
tree  = 1
/     \
2       3
/   \   /   \
4     5 6     7
Sample Output
18
// 5 + 2 + 1 + 3 + 7
*/
class MaxPathSumInBinaryTree{
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

    public static BinaryTree createBinaryTree(){
        BinaryTree first = new BinaryTree(1);
        BinaryTree second = new BinaryTree(2);
        BinaryTree third = new BinaryTree(3);
        BinaryTree fourth = new BinaryTree(4);
        BinaryTree fifth = new BinaryTree(5);
        BinaryTree sixth = new BinaryTree(6);
        BinaryTree seventh = new BinaryTree(7);
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;
        return first;
    }

    public static void main(String args[]){
        BinaryTree tree = createBinaryTree();
        int maxPathSumValue = maxPathSum(tree);
        System.out.println(maxPathSumValue);
    }

    static class TreeInfo{
        int maxSumAsBranch;
        int maxSum;
        public TreeInfo(int maxSumAsBranch, int maxSum){
            this.maxSumAsBranch = maxSumAsBranch;
            this.maxSum = maxSum;
        }
    }

    public static TreeInfo maxPathSumHelper(BinaryTree tree){
        if(tree == null) return new TreeInfo(0, Integer.MIN_VALUE);
        TreeInfo leftInfo = maxPathSumHelper(tree.left);
        TreeInfo rightInfo = maxPathSumHelper(tree.right);
        int maxSumAsBranch = Math.max(leftInfo.maxSumAsBranch, rightInfo.maxSumAsBranch);
        int maxSum = Math.max(tree.value, Math.max(maxSumAsBranch + tree.value,
                Math.max(leftInfo.maxSumAsBranch + rightInfo.maxSumAsBranch + tree.value,
                Math.max(leftInfo.maxSum, rightInfo.maxSum))));
        return new TreeInfo(maxSumAsBranch + tree.value, maxSum);
    }

    public static int maxPathSum(BinaryTree tree){
        return maxPathSumHelper(tree).maxSum;
    }
}