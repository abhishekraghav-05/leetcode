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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode oddNode = head;
        ListNode evenHead = head.next;
        ListNode evenNode = head.next;
        while(evenNode != null && evenNode.next != null) {
            oddNode.next = evenNode.next;
            oddNode = oddNode.next;

            evenNode.next = oddNode.next;
            evenNode = evenNode.next;
        }
        
        oddNode.next = evenHead;

        return head;
    }
}