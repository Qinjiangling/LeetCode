/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return null;
        }
        ListNode ret = l1, p = l1;
        int cin = 0;
        while(l1 != null && l2 != null){
            p = l1;
            int sum = l1.val + l2.val + cin;
            cin = sum/10;
            sum = sum % 10;
            l1.val = sum;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1 != null){
            p = l1;
            int sum = l1.val + cin;
            cin = sum/10;
            sum = sum % 10;
            l1.val = sum;
            l1 = l1.next;
        }
        //
        if(l2 != null){
            p.next = l2;
        }
        while(l2 != null){
            p = l2;
            int sum = l2.val + cin;
            cin = sum/10;
            sum = sum % 10;
            l2.val = sum;
            l2 = l2.next;
        }
        //最高位有进位
        if(cin != 0){
            ListNode tmp = new ListNode(cin);
            p.next = tmp;
        }
        
        return ret;
    }
}