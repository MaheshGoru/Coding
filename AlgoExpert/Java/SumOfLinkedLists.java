/*

You're given two Linked Lists of potentially unequal length. Each Linked List
represents a non-negative integer, where each node in the Linked List is a
digit of that integer, and the first node in each Linked List always
represents the least significant digit of the integer. Write a function that
returns the head of a new Linked List that represents the sum of the integers
represented by the two input Linked Lists.

Each LinkedList node has an integer value  as well as
a next node pointing to the next node in the list or to
None / null if it's the tail of the list. The
value of each LinkedList node is always in the range
of 0 - 9.

Note: your function must create and return a new Linked List, and you're not
allowed to modify either of the input Linked Lists.
Sample Input:
linkedListOne  = 2 -> 4 -> 7 -> 1
linkedListTwo = 9 -> 4 -> 5
Sample Output:
1 -> 9 -> 2 -> 2
// linkedListOne represents 1742
// linkedListTwo represents 549
// 1742 + 549 = 2291
*/
class SumOfLinkedLists{
    static class LinkedList{
        int value;
        LinkedList next;
        public LinkedList(int value){
            this.value = value;
            this.next = null;
        }
    }

    public static void main(String args[]){
        LinkedList listOne = createList(new int[]{2,4,7,1});
        LinkedList listTwo = createList(new int[]{9,4,5});
        LinkedList resultList = sumOfLinkedLists(listOne, listTwo);
        while(resultList != null){
            System.out.print(resultList.value +" ");
            resultList = resultList.next;
        }
    }

    public static LinkedList createList(int[] array){
        LinkedList head = null;
        LinkedList curr = null;
        int i=0;
        while(i < array.length){
            LinkedList temp = new LinkedList(array[i]);
            if(curr == null){
                curr = temp;
                head = temp;
            }else{
                curr.next = temp;
                curr = curr.next;
            }
            i++;
        }
        return head;
    }

    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo){
        LinkedList curr = null;
        LinkedList head = null;
        int quotient = 0;
        while(linkedListOne != null || linkedListTwo != null || quotient != 0){
            int sum = quotient + (linkedListOne != null ? linkedListOne.value : 0) + (linkedListTwo != null ? linkedListTwo.value : 0);
            int reminder = sum % 10;
            quotient = sum / 10;
            linkedListOne = linkedListOne != null ? linkedListOne.next : null;
            linkedListTwo = linkedListTwo != null ? linkedListTwo.next : null;
            LinkedList temp = new LinkedList(reminder);
            if(curr == null){
                curr = temp;
                head = temp;
            }else{
                curr.next = temp;
                curr = curr.next;
            }
        }
        return head;
    }

}