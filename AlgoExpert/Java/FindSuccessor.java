/*

Write a function that takes in a Binary Tree (where nodes have an additional
pointer to their parent node) as well as a node contained in that tree and
returns the given node's successor.

A node's successor is the next node to be visited (immediately after the given
node) when traversing its tree using the in-order tree-traversal technique. A
node has no successor if it's the last node to be visited in the in-order
traversal.

If a node has no successor, your function should return None /
null.
Each BinaryTree node has an integer value, a
left child node, and a right child node. Children
nodes can either be BinaryTree nodes themselves or
None / null.
Sample Input
tree =
1
/   \
2     3
/   \
4     5
/
6
node = 5
Sample Output
1
// This tree's in-order traversal order is:
// 6 -> 4 -> 2 -> 5 -> 1 -> 3
// 1 comes immediately after 5.
*/
class FindSuccessor{
    static class BinaryTree{
        int value;
        BinaryTree left;
        BinaryTree right;
        BinaryTree parent;
        public BinaryTree(int value){
            this.value = value;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }


    public static BinaryTree createTree(){
        BinaryTree first = new BinaryTree(1);
        BinaryTree second = new BinaryTree(2);
        BinaryTree third = new BinaryTree(3);
        BinaryTree fourth = new BinaryTree(4);
        BinaryTree fifth = new BinaryTree(5);
        BinaryTree sixth = new BinaryTree(6);

        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        fourth.left = sixth;
        first.parent = null;
        second.parent = first;
        third.parent = first;
        fourth.parent = second;
        fifth.parent = second;
        sixth.parent = fourth;
        return first;
    }
    public static BinaryTree getNodeWithValue(BinaryTree tree, int value){
        if(tree == null) return null;
        if(tree.value == value) return tree;
        BinaryTree leftRes = getNodeWithValue(tree.left, value);
        if(leftRes != null) return leftRes;
        return getNodeWithValue(tree.right, value);
    }
    public static void main(String args[]){
        BinaryTree tree = createTree();
        BinaryTree node = getNodeWithValue(tree, 5);
        BinaryTree successor = findSuccessor(tree, node);
        if(successor != null) System.out.println(successor.value); else System.out.println("Null");
    }

    public static BinaryTree findSuccessor(BinaryTree tree, BinaryTree  node){
        if(node == null) return null;
        if(node.right != null){
            BinaryTree temp = node.right;
            while(temp.left != null)
                temp = temp.left;
            return temp;
        }
        BinaryTree currentNode = node;
        while(currentNode.parent != null && currentNode.parent.right == currentNode){
            currentNode = currentNode.parent;
        }
        return currentNode.parent;
    }
}