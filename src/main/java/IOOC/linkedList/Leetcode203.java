package IOOC.linkedList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


public class Leetcode203 {
    public ListNode removeElements(ListNode head, int val) {
        while(head != null && head.val == val){
            head = head.next;
        }

        if(head == null){
            return null;
        }

        ListNode prev = head;

        while(prev.next != null){
            if(prev.next.val == val){

                prev.next = prev.next.next;
            }else{
                prev = prev.next;
            }
        }
        return head;

    }
}