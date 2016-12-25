/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 import java.util.Queue;
 import java.util.PriorityQueue;
 import java.util.Comparator;
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists == null || lists.length == 0){
            return null;
        }
        int k = lists.length;
        if(k == 1){
            return lists[0];
        }
        ListNode ret = new ListNode(0);
        ListNode p = ret;
        Queue<ListNode> queue = new PriorityQueue<ListNode>(k,new Comparator<ListNode>(){
            public int compare(ListNode o1, ListNode o2){
                return o1.val - o2.val;
            }
        });
        for(int i = 0; i < k; i++){
            if(lists[i] != null){
                queue.add(lists[i]);
            }
        }
        while(queue.size() > 0){
            ListNode tmp = queue.poll();
            p.next = tmp;
            p = tmp;
            if(tmp.next != null){
                queue.add(tmp.next);
            }
        }
        
        return ret.next;
    }
}