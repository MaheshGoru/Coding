/*

You're given three inputs, all of which are instances of an
AncestralTree class that have an ancestor property
pointing to their youngest ancestor. The first input is the top ancestor in an
ancestral tree (i.e., the only instance that has no ancestor--its
ancestor property points to None /
null), and the other two inputs are descendants in the ancestral
tree.

Write a function that returns the youngest common ancestor to the two
descendants.

Note that a descendant is considered its own ancestor. So in the simple
ancestral tree below, the youngest common ancestor to nodes A and B is node A.
// The youngest common ancestor to nodes A and B is node A.

A
/
B
Sample Input
// The nodes are from the ancestral tree below.
topAncestor = node A
descendantOne = node E
descendantTwo = node I
A
/     \
B       C
/   \   /   \
D     E F     G
/   \
H     I
Sample Output
node B
*/
import java.util.*;
class YoungestCommonAncestor{

    public static AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        // Write your code here.
        int heightOne = getHeight(descendantOne, topAncestor);
        int heightTwo = getHeight(descendantTwo, topAncestor);
        int diff = 0;
        AncestralTree maxHeightNode = null;
        AncestralTree otherNode = null;
        if(heightOne > heightTwo){
            diff = heightOne - heightTwo;
            maxHeightNode = descendantOne;
            otherNode = descendantTwo;
        }else{
            diff = heightTwo - heightOne;
            maxHeightNode = descendantTwo;
            otherNode = descendantOne;
        }
        int count = 0;
        while(count < diff){
            count++;
            maxHeightNode = maxHeightNode.ancestor;
        }

        while(maxHeightNode != otherNode){
            maxHeightNode = maxHeightNode.ancestor;
            otherNode = otherNode.ancestor;
        }
        return maxHeightNode; // Replace this line
    }

    public static int getHeight(AncestralTree currentNode, AncestralTree targetNode){
        int count = 0;
        while(currentNode != targetNode){
            currentNode = currentNode.ancestor;
            count++;
        }
        return count;
    }

    static class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        // This method is for testing only.
        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

    public static void main(String args[]){
        AncestralTree a = new AncestralTree('A');
        AncestralTree b = new AncestralTree('B');
        AncestralTree c = new AncestralTree('C');
        AncestralTree d = new AncestralTree('D');
        AncestralTree e = new AncestralTree('E');
        AncestralTree f = new AncestralTree('F');
        AncestralTree g = new AncestralTree('G');
        AncestralTree h = new AncestralTree('H');
        AncestralTree i = new AncestralTree('I');
        i.ancestor = d;
        h.ancestor = d;
        d.ancestor = b;
        e.ancestor = b;
        f.ancestor = c;
        g.ancestor = c;
        b.ancestor = a;
        c.ancestor = a;
        AncestralTree youngAncestor = getYoungestCommonAncestor(a,e,i);
        System.out.println(youngAncestor.name);
    }
}