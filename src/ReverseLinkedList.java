/**
 * @author Cagri Toraman
 * cagritoraman@gmail.com
 */

public class ReverseLinkedList {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode t, a=null;
        while(head != null) { //repeat my three-element-window approach till the end.
            t = head.next;
            head.next = a;
            if (t == null) {
                return head;
            } else {
                a = t.next;
                t.next = head;
                if (a == null) {
                    return t;
                } else {
                    head = a.next;
                    a.next = t;
                }
            }
        }
        return a;
    }

    public static void add(ListNode node, int i, int size){
        if(i<=size) {
            node.next = new ListNode(i);
            add(node.next, i + 1, size);
        }
    }

    public static void print(ListNode head){
        ListNode temp = head;
        StringBuffer buffer = new StringBuffer();
        while(temp!=null) {
            buffer.append(temp.val+",");
            temp = temp.next;
        }
        buffer.deleteCharAt(buffer.length()-1);
        System.out.println(buffer.toString());
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        add(head, 2, 5);
        print(head);
        ListNode reversed = reverseList(head);
        print(reversed);
        //Runtime: 0 ms, faster than 100.00% of Java online submissions for Reverse Linked List.
        //Memory Usage: 38.4 MB, less than 92.50% of Java online submissions for Reverse Linked List.
    }
}
