public class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode ret = new ListNode(-1);
        ret.next = head;
        ListNode p1 = head.next, p2 = null;
        head.next = null;
        while(p1 != null){
            p2 = ret;
            while(p2.next != null && p2.next.val < p1.val){
                p2 = p2.next;
            }
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p1.next;
            p2.next.next = tmp;
        }
        return ret.next;
    }
}