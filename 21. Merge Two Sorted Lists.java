/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(0);
        ListNode p = ret;
        while(l1 != null && l2 != null){
            if(l1.val < l2.val){
                p.next = l1;
                p = l1;
                l1 = l1.next;
            }else{
                p.next = l2;
                p = l2;
                l2 = l2.next;
            }
        }
        if(l1 != null){
            p.next = l1;
        }
        if(l2 != null){
            p.next = l2;
        }
        
        return ret.next;
    }
}