//链表 归并排序
public class Solution {
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        int len = 0;
        for(ListNode p = head; p != null; p = p.next){
            len++;
        }
        return mergeSort(head, len);
    }
    
    public ListNode mergeSort(ListNode head, int len){
        if(len == 1){
            head.next = null;
            return head;
        }
        ListNode p1 = head;
        int k = len/2;
        for(; k > 0; k--){
            p1 = p1.next;
        }
        ListNode node1 = mergeSort(head, len/2);
        ListNode node2 = mergeSort(p1, (len+1)/2);
        ListNode ret = merge(node1, node2);
        return ret;
    }
    
    //sorted list merge
    public ListNode merge(ListNode h1, ListNode h2){
        ListNode ret = new ListNode(0);
        ListNode p = ret;
        while(h1 != null && h2 != null){
            if(h1.val < h2.val){
                p.next = h1;
                p = h1;
                h1 = h1.next;
            }else{
                p.next = h2;
                p = h2;
                h2 = h2.next;
            }
        }
        if(h1 != null){
            p.next = h1;
        }
        if(h2 != null){
            p.next = h2;
        }
        return ret.next;
    }
}