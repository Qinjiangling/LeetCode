/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode p1 = head, p2 = head;
        ListNode ret = head;
        //n step first
        while(p1 != null && n > 0){
            p1 = p1.next;
            n--;
        }
        //n node
        if(p1 == null && n == 0){
            ret = ret.next;
            return ret;
        }
        //size < n
        if(p1 == null){
            return null;
        }
        while(p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        //delete
        p2.next = p2.next.next;
        
        return ret;
        
    }
}