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
    ListNode merge(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode();
        ListNode curr = dummy;
        ListNode curr1 = head1, curr2 = head2;
        while(curr1 != null && curr2 != null) {
            if(curr1.val < curr2.val) {
                curr.next = curr1;
                curr1 = curr1.next;
            }else {
                curr.next = curr2;
                curr2 = curr2.next;
            }
            curr = curr.next;
        }
        if(curr1 != null) {
            curr.next = curr1;
        }
        if(curr2 != null) {
            curr.next = curr2;
        }
        return dummy.next;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        int interval = 1;
        while(interval < n) {
            for(int i = 0; i < n-interval; i += 2*interval) {
                lists[i] = merge(lists[i],lists[i+interval]);
            }
            interval *= 2;
        }
        return (n > 0)? lists[0] : null;
    }
}
