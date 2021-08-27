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
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        
        //first find the whole length
        if(head == null) {
            return null;
        }
        
        if(head.next == null) {
            return head;
        }
        
        int length = 1;
        ListNode dummy = head;
        
        while(head.next != null) {
            length++;
            head = head.next;
        }
        
        
        int moves = length - k % length - 1;
        head.next = dummy;
        
        for(int i = 0; i < moves; i++) {
            dummy = dummy.next;
        }
        
        ListNode res = dummy.next;
        dummy.next = null;
        
        
        return res;
    }
}