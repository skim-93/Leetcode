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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        //find the middle Node
        while(slow!=null && fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        ListNode rev = slow.next;
        ListNode curr = slow.next;
        ListNode prev = null;
        
        while(rev != null) {
            curr = rev.next;
            rev.next = prev;
            prev = rev;
            rev = curr;
        }
        
        ListNode start = head;
        slow = prev;
        
        while(slow != null) {
            if(start.val != slow.val) {
                return false;
            }
            
            slow = slow.next;
            start = start.next;
            
        }
        return true;
    }
    
}