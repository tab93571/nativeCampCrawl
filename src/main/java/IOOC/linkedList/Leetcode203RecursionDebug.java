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


public class Leetcode203RecursionDebug {

    public ListNode removeElements(ListNode head, int val,int depth){

        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove "+ val + " in " + head);

        if(head == null){
            System.out.print(depthString);
            System.out.println("Return: " + null);
            return null;
        }
       ListNode res = removeElements(head.next,val,depth+1);

        System.out.print(depthString);
        System.out.println("After remove " + val + ": " + res);

        ListNode ret;
        if(head.val == val){
            ret = res;
        }else{
            head.next = res;
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: " + ret);

        return ret;
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < depth ; i++){
            res.append("--");
        }
        return res.toString();
    }


    public static void main(String[] args) {
        int[] nums = {1,6,2,6};
        ListNode head = new ListNode(nums);
        System.out.println(head);
        ListNode res = (new Leetcode203RecursionDebug()).removeElements(head,6,0);
        System.out.println(res);
    }
}