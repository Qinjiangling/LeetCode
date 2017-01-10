public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null)return null;
        if(head.next == null)return new TreeNode(head.val);
        ListNode p1 = head, p2 = head.next, pre = null;
        while(p2 != null && p2.next != null){
            pre = p1;
            p1 = p1.next;
            p2 = p2.next.next;
        }
        TreeNode root = new TreeNode(p1.val);
        //exist left tree
        if(pre != null){
            pre.next = null;
            root.left = sortedListToBST(head);
        }
        root.right = sortedListToBST(p1.next);
        return root;
    }
}