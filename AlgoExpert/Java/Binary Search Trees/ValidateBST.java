/*

Write a function that takes in a potentially invalid Binary Search Tree (BST)
and returns a boolean representing whether the BST is valid.

Each BST node has an integer value, a
left child node, and a right child node. A node is
said to be a valid BST node if and only if it satisfies the BST
property: its value is strictly greater than the values of every
node to its left; its value is less than or equal to the values
of every node to its right; and its children nodes are either valid
BST nodes themselves or None / null.

A BST is valid if and only if all of its nodes are valid
BST nodes.
Sample Input:
tree =   10
/     \
5      15
/   \   /   \
2     5 13   22
/           \
1            14
Sample Output:
true
*/
class ValidateBST{
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
        boolean isValid = validateBst(tree);
        System.out.println(isValid);
    }

    public static boolean validateBSTHelper(BST tree, int minValue, int maxValue){
        if(tree == null)
            return true;
        return minValue <= tree.value &&
                tree.value < maxValue &&
                validateBSTHelper(tree.left, minValue, tree.value) &&
                validateBSTHelper(tree.right, tree.value , maxValue);
    }
    public static boolean validateBst(BST tree){
        return validateBSTHelper(tree, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
}