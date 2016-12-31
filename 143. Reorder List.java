public class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        int size = 0;
        ListNode p = head;
        while(p != null){
            size++;
            p = p.next;
        }
        Stack<ListNode> s = new Stack<ListNode>();
        int flag = (size + 1)/2, i = 0;
        for(p = head; p != null; p = p.next,i++){
            if(i >= flag){
                s.push(p);
            }
        }
        ListNode tmp = null, tail = null;
        p = head;
        while(!s.empty()){
            if(tail != null){
                tail.next = p;
            }
            tmp = p.next;
            ListNode t  = s.pop();
            p.next = t;
            tail = t;
            tail.next = null;
            p = tmp;
        }
        if(size % 2 == 1){
            tail.next = p;
            p.next = null;
        }
    }
}