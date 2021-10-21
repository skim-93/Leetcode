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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        
        PriorityQueue<Integer> pq = new PriorityQueue();
        while(l1 != null) {
            pq.offer(l1.val);
            l1 = l1.next;
        }
        
        while(l2 != null) {
            pq.offer(l2.val);
            l2 = l2.next;
        }
        
        ListNode ans = new ListNode((int) pq.poll());
        ListNode holder = ans;
        
        while(!pq.isEmpty()) {
            ans.next = new ListNode((int) pq.poll());
            ans = ans.next;
        }
        
        return holder;
        
    }
}