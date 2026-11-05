/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;

        List<ListNode> arr = new ArrayList<>();

        while(head != null){
            ListNode temp = head;
            head = head.next;
            arr.add(temp);
        }

        for(int i=0; i<arr.size();i+=2){
            if(i+1<=arr.size()-1){
                Collections.swap(arr, i, i+1);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;

        for(ListNode node : arr){
            tail.next = node;
            tail = tail.next;  
        }

        tail.next = null;
        return dummy.next;
    }
}