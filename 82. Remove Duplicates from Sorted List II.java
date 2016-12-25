/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.Set;
import java.util.HashSet;

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode ret = new ListNode(0);
        ListNode p1 = head, p2 = head.next, cur = ret;
        Set<Integer> sets = new HashSet<Integer>();
        while(p2 != null){
            if(p1.val == p2.val){
                sets.add(p1.val);
            }
            p1 = p2;
            p2 = p2.next;
        }
        p1 = head;
        while(p1 != null){
            if(!sets.contains(p1.val)){
                cur.next = p1;
                cur = p1;
                p1 = p1.next;
                cur.next = null;
            }else{
                p1 = p1.next;
            }
        }
        
        return ret.next;
    }
}