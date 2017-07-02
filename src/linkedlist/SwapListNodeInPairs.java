package linkedlist;
import java.util.*;
import java.io.*;
public class SwapListNodeInPairs
{
    public static ListNode swapPairs(ListNode a) {
        ListNode p = a;

        ListNode b = a, prev = null, d;

        while(p!=null && p.next!=null)
        {
            if(prev==null) b = p.next;
            //print(b);
            swap(prev, p, p.next);
            //print(b);
            prev =p;
            p = p.next;


        }
        //System.out.print("sdfklj ");
        //print(b);
        return b;
    }

    public static void swap(ListNode a, ListNode b, ListNode c)
    {
        //p(a); p(b); p(c);

        b.next = c.next;
        c.next = b;
        if(a!=null)
            a.next = c;
    }
}


