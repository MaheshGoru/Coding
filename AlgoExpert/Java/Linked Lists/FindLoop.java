/*

Write a function that takes in the head of a Singly Linked List that contains
a loop (in other words, the list's tail node points to some node in the list
instead of None / null). The function should return
the node (the actual node--not just its value) from which the loop originates
in constant space.
Each LinkedList node has an integer value as well as
a next node pointing to the next node in the list or to
None / null if it's the tail of the list.
Sample Input
head = 0 -> 1 -> 2 -> 3 -> 4 -> 5 -> 6 // the head node with value 0
                            ^         v
                            9 <- 8 <- 7
Sample Output
4 -> 5 -> 6 // the node with value 4
^         v
9 <- 8 <- 7
*/
class FindLoop{
    static class LinkedList{
        int value;
        LinkedList next;
        public LinkedList(int value){
            this.value = value;
            this.next = null;
        }
    }
    public static void main(String args[]){
        LinkedList zero = new LinkedList(0);
        LinkedList one = new LinkedList(1);
        LinkedList two = new LinkedList(2);
        LinkedList three = new LinkedList(3);
        LinkedList four = new LinkedList(4);
        LinkedList five = new LinkedList(5);
        LinkedList six = new LinkedList(6);
        LinkedList seven = new LinkedList(7);
        LinkedList eight = new LinkedList(8);
        LinkedList nine = new LinkedList(9);
        zero.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = seven;
        seven.next = eight;
        eight.next = nine;
        nine.next = four;
        LinkedList res = findLoop(zero);
        System.out.println(res.value);
    }

    public static LinkedList findLoop(LinkedList head){
        LinkedList slow = head;
        LinkedList fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                break;
        }
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}