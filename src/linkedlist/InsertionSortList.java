package linkedlist;
import java.util.*;
import java.io.*;
public class InsertionSortList
{
    public static ListNode insertionSortList(ListNode a)
    {

        ListNode c = new ListNode(Integer.MIN_VALUE);
        c.next = new ListNode(a.val);
        ListNode cur = a.next;

        while(cur!=null)
        {
            ListNode prev = c, b = c.next;

            while(b!=null)
            {
                if(b.val<=cur.val)
                {
                    prev = b;
                    b = b.next;
                }
                else
                {
                    break;
                }
            }
            addAfter(prev, cur.val);
            cur = cur.next;
        }

        return c.next;


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

