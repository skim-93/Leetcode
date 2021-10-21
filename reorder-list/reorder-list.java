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
    public void reorderList(ListNode head) {
        ListNode mid = getMidPointer(head);
        ListNode last = reverse(mid);
        merge(head, last);
    }
    
    private void merge(ListNode a, ListNode b) {        
        while (b != null && a != null) {
            ListNode temp1 = a.next;
            a.next = b;
            
            ListNode temp2 = b.next;
            b.next = temp1;
            
            a = temp1;
            b = temp2;
        }
        if (a != null) a.next = null;
    }
    
    private ListNode reverse(ListNode head) {
        
        ListNode cur = head;
        ListNode prev = null;
        
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            
            prev = cur;
            cur = next;
        }
        return prev;
    }
    
    private ListNode getMidPointer(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}