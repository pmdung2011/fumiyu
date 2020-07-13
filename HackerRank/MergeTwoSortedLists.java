package HackerRank;

import java.util.List;

class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            return new ListNode(l1.val, mergeTwoLists(l1.next, l2));
        }
        else{
            return new ListNode(l2.val, mergeTwoLists(l1,l2.next));
        }

    }
}
