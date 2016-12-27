public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0){
            return head;
        }
        int len = 1;
        ListNode pTail = head, p = head;
        ListNode ret = new ListNode(0);
        while(pTail.next != null){
            len++;
            pTail = pTail.next;
        }
        k = k % len;
        if(k == 0){
            return head;
        }
        int i = len - k - 1;
        while(i > 0){
            p = p.next;
            i--;
        }
        ret.next = p.next;
        p.next = null;
        pTail.next = head;
        
        return ret.next;
    }
}