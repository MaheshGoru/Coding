/*

You're given the head of a Singly Linked List whose nodes are in sorted order
with respect to their values. Write a function that returns a modified version
of the Linked List that doesn't contain any nodes with duplicate values. The
Linked List should be modified in place (i.e., you shouldn't create a brand
new list), and the modified Linked List should still have its nodes sorted
with respect to their values.

Each LinkedList node has an integer value as well as
a next node pointing to the next node in the list or to
None / null if it's the tail of the list.
Sample Input:
linkedlist  = 1 -> 1 -> 3 -> 4 -> 4 -> 4 -> 5 -> 6 -> 6
Sample Output:
1 -> 3 -> 4 -> 5 -> 6

*/
class RemoveDuplicatesFromLinkedList{
    static class LinkedList{
        public int value;
        public LinkedList next;
        public LinkedList(int value){
            this.value = value;
            this.next = null;
        }
    }
    public static LinkedList createList(){
        LinkedList head = new LinkedList(1);
        LinkedList secondNode = new LinkedList(1);
        LinkedList thirdNode = new LinkedList(3);
        LinkedList fourth = new LinkedList(4);
        LinkedList fifth = new LinkedList(4);
        LinkedList sixth = new LinkedList(4);
        LinkedList seven = new LinkedList(5);
        LinkedList eight = new LinkedList(6);
        LinkedList nine = new LinkedList(6);
        eight.next = nine;
        seven.next = eight;
        sixth.next = seven;
        fifth.next = sixth;
        fourth.next = fifth;
        thirdNode.next = fourth;
        secondNode.next = thirdNode;
        head.next = secondNode;
        return head;
    }
    public static void main(String args[]){
        LinkedList head = createList();
        LinkedList afterRemoveHead = removeDuplicatesFromLinkedList(head);
        while(afterRemoveHead != null){
            System.out.print(afterRemoveHead.value +" ");
            afterRemoveHead = afterRemoveHead.next;
        }
    }

    public static LinkedList removeDuplicatesFromLinkedList(LinkedList linkedList){
        LinkedList currentNode = linkedList;
        while(currentNode != null){
            LinkedList nextDistinctNode = currentNode.next;
            while(nextDistinctNode != null && currentNode.value == nextDistinctNode.value){
                nextDistinctNode = nextDistinctNode.next;
            }
            currentNode.next = nextDistinctNode;
            currentNode = nextDistinctNode;
        }
        return linkedList;
    }
}
