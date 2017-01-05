public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next == null)return head;
        ListNode ret = new ListNode(0);
        ListNode p = head, p1 = null, h1 = null, p2 = null, h2 = null;
        while(p != null){
            if(p.val < x){
                if(h1 == null){
                    h1 = p;
                    p1 = p;
                }else{
                    p1.next = p;
                    p1 =p;
                }
            }else{
                if(h2 == null){
                    h2 = p;
                    p2 = p;
                }else{
                    p2.next = p;
                    p2 = p;
                }
            }
            p = p.next;
        }
        if(p2 != null){
            p2.next = null;
        }
        ret.next = (h1==null?h2:h1);
        if(h1 != null){
            p1.next = h2;
        }
        return ret.next;
    }
}