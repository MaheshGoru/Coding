/*

You're given three nodes that are contained in the same Binary Search Tree:
nodeOne, nodeTwo, and nodeThree. Write
a function that returns a boolean representing whether one of
nodeOne or nodeThree is an ancestor of
nodeTwo and the other node is a descendant of
nodeTwo. For example, if your function determines that
nodeOne is an ancestor of nodeTwo, then it needs to
see if nodeThree is a descendant of nodeTwo. If your
function determines that nodeThree is an ancestor, then it needs
to see if nodeOne is a descendant.


A descendant of a node N is defined as a node contained in
the tree rooted at N. A node N is an ancestor of
another node M if M is a descendant of
N.

It isn't guaranteed that nodeOne or nodeThree will
be ancestors or descendants of nodeTwo, but it is guaranteed that
all three nodes will be unique and will never be None /
null. In other words, you'll be given valid input nodes.

Each BST node has an integer value, a
left child node, and a right child node. A node is
said to be a valid BST node if and only if it satisfies the BST
property: its value is strictly greater than the values of every
node to its left; its value is less than or equal to the values
of every node to its right; and its children nodes are either valid
BST nodes themselves or None / null.
Sample Input
tree =    5
/     \
2       7
/   \   /   \
1     4 6     8
/     /
0     3
nodeOne = 5
nodeTwo = 2
nodeThree = 3
Sample Output
true
*/
class ValidateThreeNodes{
    static class BST{
        public int value;
        public BST left;
        public BST right;
        public BST(int value){
            this.value = value;
        }
    }
    public static void main(String args[]){
        BST root = new BST(5);
        BST one = new BST(2);
        BST two = new BST(7);
        BST three = new BST(1);
        BST four = new BST(4);
        BST five = new BST(6);
        BST six = new BST(8);
        BST seven = new BST(0);
        BST eight = new BST(3);
        root.left = one;
        root.right = two;
        one.left = three;
        one.right = four;
        two.left = five;
        two.right = six;
        three.left = seven;
        four.left = eight;
        boolean validateThreeNodes = validateThreeNodes(root, one, eight);
        System.out.println(validateThreeNodes);
    }

    public static boolean validateThreeNodes(BST nodeOne, BST nodeTwo, BST nodeThree){
        boolean firstVal = canReachNodeTwoFromNodeOne(nodeOne, nodeTwo) && canReachNodeTwoFromNodeOne(nodeTwo, nodeThree);
        boolean secondVal = canReachNodeTwoFromNodeOne(nodeTwo, nodeOne) && canReachNodeTwoFromNodeOne(nodeThree, nodeTwo);
        return firstVal || secondVal;
    }

    public static boolean canReachNodeTwoFromNodeOne(BST nodeOne, BST nodeTwo){
        boolean isReached = false;
        BST temp = nodeOne;
        while(temp != null){
            if(temp.value == nodeTwo.value){
                isReached = true;
                break;
            }
            if(temp.value > nodeTwo.value)
                temp = temp.left;
            else
                temp = temp.right;
        }
        return isReached;
    }
}