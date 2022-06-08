/*

You're given a Node class that has a name and an
array of optional children nodes. When put together, nodes form
an acyclic tree-like structure.

Implement the depthFirstSearch method on the
Node class, which takes in an empty array, traverses the tree
using the Depth-first Search approach (specifically navigating the tree from
left to right), stores all of the nodes' names in the input array, and returns
it.

If you're unfamiliar with Depth-first Search, we recommend watching the
Conceptual Overview section of this question's video explanation before
starting to code.
Sample Input
graph = A
/  |  \
B   C   D
/ \     / \
E   F   G   H
/ \   \
I   J   K
Sample Output
["A", "B", "E", "F", "I", "J", "C", "D", "G", "K", "H"]
*/
import java.util.*;
class DepthFirstSearch{
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public void depthFirstSearchHelper(Node node, List<String> array){
            if(node == null)
                return;
            array.add(node.name);
            for(int i=0;i<node.children.size();i++){
                depthFirstSearchHelper(node.children.get(i), array);
            }
        }
        public List<String> depthFirstSearch(List<String> array) {
            // Write your code here.
            depthFirstSearchHelper(this, array);
            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    public static void main(String args[]){
        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node i = new Node("I");
        Node j = new Node("J");
        Node k = new Node("K");
        a.children.add(b);
        a.children.add(c);
        a.children.add(d);
        b.children.add(e);
        b.children.add(f);
        d.children.add(g);
        d.children.add(h);
        f.children.add(i);
        f.children.add(j);
        g.children.add(k);
        List<String> list = new ArrayList<String>();
        a.depthFirstSearch(list);
        for(int l=0;l<list.size();l++){
            System.out.println(list.get(l));
        }
    }
}