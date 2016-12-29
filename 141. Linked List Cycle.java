public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode p1 = head, p2 = head.next.next;
        while(p2 != null && p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
            if(p2 != null)p2 = p2.next;
        }
        return p2 == null?false:true;
    }
}