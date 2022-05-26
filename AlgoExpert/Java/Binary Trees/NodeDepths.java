/*

The distance between a node in a Binary Tree and the tree's root is called the
node's depth.
Write a function that takes in a Binary Tree and returns the sum of its nodes'
depths.

Each BinaryTree node has an integer value, a
left child node, and a right child node. Children
nodes can either be BinaryTree nodes themselves or
None / null.
Sample Input
tree =    1
/     \
2       3
/   \   /   \
4     5 6     7
/   \
8     9
Sample Output
16
// The depth of the node with value 2 is 1.
// The depth of the node with value 3 is 1.
// The depth of the node with value 4 is 2.
// The depth of the node with value 5 is 2.
// Etc..
// Summing all of these depths yields 16.
*/
class NodeDepths{
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
        System.out.println(nodeDepths(root));
    }
    public static int nodeDepths(BinaryTree root){
        return nodeDepthsHelper(root, 0);
    }
    public static int nodeDepthsHelper(BinaryTree root, int depth){
        if(root == null) return 0;
        return depth+ nodeDepthsHelper(root.left, depth+1) + nodeDepthsHelper(root.right, depth+1);
    }
}