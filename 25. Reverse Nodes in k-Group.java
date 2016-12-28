public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 0 || k == 1){
            return head;
        }
        int len = 0;
        ListNode pHead = head;
        while(pHead != null){
            len++;
            pHead = pHead.next;
        }
        if(k > len){
            return head;
        }
        ListNode ret = new ListNode(0);
        ret.next = head;
        ListNode p1 = head, p2 = head;
        ListNode tmp = null, tTail = null;
        do{
            int count = k - 1;
            while(p2 != null && count > 0){
                p2 = p2.next;
                count--;
            }
            //tail
            if(p2 == null){
                break;
            }
            //reverse
            tmp = p2.next;
            p2.next = null;
            reverse(p1);
            //first group
            if(p1 == head){
                ret.next = p2;
            }
            //tmp tail
            if(tTail != null){
                tTail.next = p2;
            }
            tTail = p1;
            p1 = tmp;
            p2 = tmp;
        }while(p1 != null);
        
        if(tTail != null && p1 != null){
            tTail.next = p1;
        }
        return ret.next;
    }
    
    //recursive
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode tmp = reverse(head.next);
        tmp.next = head;
        head.next = null;
        return head;
    }
}