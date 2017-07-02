package linkedlist;
import java.util.*;
import java.io.*;
public class AddTwoNumbersAsLists
{
    public static ListNode addTwoNumbers(ListNode a, ListNode b) {
        ListNode x = a, y = b, z = new ListNode(0), h = z;
        int carry = 0;
        while(x!=null && y!=null)
        {
            int val = x.val+y.val+carry;
            ListNode newnode = new ListNode(val%10);
            carry = val/10;
            z.next = newnode;
            x = x.next;
            y = y.next;
            z = z.next;
        }
        while(x!=null)
        {
            int val = x.val+carry;
            ListNode newnode = new ListNode(val%10);
            carry=val/10;
            z.next = newnode;
            z = z.next;
            x = x.next;
        }
        while(y!=null)
        {
            int val = y.val+carry;
            ListNode newnode = new ListNode(val%10);
            carry=val/10;
            z.next = newnode;
            z = z.next;
            y = y.next;
        }
        while(carry>0)
        {
            int val = carry%10;
            ListNode newnode = new ListNode(val);
            carry=carry/10;
            z.next = newnode;
            z = z.next;
        }

        return h.next;

    }
}
