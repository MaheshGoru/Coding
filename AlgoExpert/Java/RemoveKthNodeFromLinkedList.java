/*

Write a function that takes in the head of a Singly Linked List and an integer k  and removes the kth node from the end of the list.

The removal should be done in place, meaning that the original data structure
should be mutated (no new structure should be created).
Furthermore, the input head of the linked list should remain the head of the
linked list after the removal is done, even if the head is the node that's
supposed to be removed. In other words, if the head is the node that's
supposed to be removed, your function should simply mutate its
value and next pointer.
Note that your function doesn't need to return anything.
You can assume that the input Linked List will always have at least two nodes
and, more specifically, at least k nodes.

Each LinkedList node has an integer value as well as
a next node pointing to the next node in the list or to
None / null if it's the tail of the list.
Sample Input:
linkedlist  = 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
k = 4
Sample Output:
0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 7 -> 8 -> 9
*/
class RemoveKthNodeFromLinkedList{
    static class LinkedList{
        int value;
        LinkedList next;
        public LinkedList(int value){
            this.value = value;
            this.next = null;
        }
    }
    public static LinkedList createList(){
        LinkedList head = new LinkedList(0);
        LinkedList secondNode = new LinkedList(1);
        LinkedList thirdNode = new LinkedList(2);
        LinkedList fourth = new LinkedList(3);
        LinkedList fifth = new LinkedList(4);
        LinkedList sixth = new LinkedList(5);
        LinkedList seven = new LinkedList(6);
        LinkedList eight = new LinkedList(7);
        LinkedList nine = new LinkedList(8);
        LinkedList ten = new LinkedList(9);
        nine.next = ten;
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
        LinkedList linkedlist = createList();
        removeKthNodeFromEnd(linkedlist, 4);
        while(linkedlist != null) {
            System.out.print(linkedlist.value + " ");
            linkedlist = linkedlist.next;
        }
    }

    public static void removeKthNodeFromEnd(LinkedList linkedlist, int k){
        LinkedList first = linkedlist;
        LinkedList second = linkedlist;
        int count = 0;
        while(count < k){
            count++;
            second = second.next;
        }
        if(second == null)
        {
            first.value = first.next.value;
            first.next = first.next.next;
            return;
        }
        while(second.next != null){
            second = second.next;
            first = first.next;
        }
        first.next = first.next.next;
    }
}