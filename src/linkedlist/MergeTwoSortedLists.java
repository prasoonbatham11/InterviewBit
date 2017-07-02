package linkedlist;
import java.util.*;
import java.io.*;
public class MergeTwoSortedLists
{
    public static ListNode mergeTwoLists(ListNode a, ListNode b)
    {
        ListNode c = new ListNode(-1), y = c;

        ListNode n = a, m = b;
        while(n!=null && m!=null)
        {
            if(n.val<=m.val)
            {
                addAfter(c, n.val);
                c = c.next;
                n = n.next;
            }
            else
            {
                addAfter(c, m.val);
                c = c.next;
                m =m.next;
            }
        }

        while(m!=null) {
            addAfter(c, m.val); m = m.next; c = c.next;
        }
        while(n!=null) {
            addAfter(c, n.val); n = n.next; c = c.next;
        }

        return y.next;

    }
    public static void addAfter(ListNode x, int val)
    {
        if(x==null) return;
        ListNode nextofx = x.next;
        ListNode node = new ListNode(val);

        x.next = node;
        node.next = nextofx;
    }
}
