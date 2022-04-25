/*

Write a function that takes in a Binary Tree and inverts it. In other words,
the function should swap every left node in the tree for its corresponding
right node.
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
1
/     \
3       2
/   \   /   \
7     6 5     4
/   \
9     8
*/
class InvertBinaryTree{
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
        invertBinaryTree(root);
        inOrderTraversal(root);
    }

    public static void inOrderTraversal(BinaryTree root){
        if(root == null) return;
        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }

    public static void invertBinaryTree(BinaryTree root){
        if(root == null) return;
        BinaryTree temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }
}