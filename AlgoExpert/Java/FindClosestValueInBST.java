/*

Write a function that takes in a Binary Search Tree (BST) and a target integer
value and returns the closest value to that target value contained in the BST.
You can assume that there will only be one closest value.
Each BST node has an integer value, a
left child node, and a right child node. A node is
said to be a valid BST node if and only if it satisfies the BST
property: its value is strictly greater than the values of every
node to its left; its value is less than or equal to the values
of every node to its right; and its children nodes are either valid
BST nodes themselves or None / null.
Sample Input:
tree =   10
/     \
5      15
/   \   /   \
2     5 13   22
/           \
1            14
target = 12
Sample Output:
13
*/
class FindClosestValueInBST{
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
        int closestValue = findClosestValueInBst(tree, 12);
        System.out.println(closestValue);
    }

    public static int findClosestValueInBst(BST tree, int target){
        int closest = tree.value;
        while(tree != null){
            if(Math.abs(tree.value - target) < Math.abs(target - closest)){
                closest = tree.value;
            }
            if(tree.value > target)
                tree = tree.left;
            else if(tree.value < target)
                tree = tree.right;
            else
                break;
        }
        return closest;
    }
}