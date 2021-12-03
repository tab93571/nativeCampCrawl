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


public class Leetcode203Recursion {

    public ListNode removeElements(ListNode head, int val){
        if(head == null){
            return null;
        }
       head.next = removeElements(head.next,val);
        return head.val == val ? head.next : head;
    }


//    public ListNode removeElements(ListNode head, int val){
//        if(head == null){
//            return null;
//        }
//        ListNode res = removeElements(head.next,val);
//        if(head.val == val){
//            return res;
//        }else{
//            head.next = res;
//            return head;
//        }
//    }

    public static void main(String[] args) {
        int[] nums = {1,6,2,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode res = (new Leetcode203Recursion()).removeElements(head,6);
        System.out.println(res);
    }
}