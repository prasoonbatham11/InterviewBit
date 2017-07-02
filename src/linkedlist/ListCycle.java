package linkedlist;
import java.util.*;
import java.io.*;
public class ListCycle
{
    public static ListNode detectCycle(ListNode a) {
        ListNode b = a;
        ListNode x = iscycle(b);
        if(x==null) return x;

	    /*HashSet<ListNode> set = new HashSet<>();
	    ListNode c = a;
	    while(true)
        {
            if(set.contains(c)) return c;
            set.add(c);
            c = c.next;
        }*/

        int count = 1;
        ListNode y = x.next;
        while(y!=x)
        {
            y = y.next;
            count++;
        }

        x = a;
        int i;
        for(i=0;i<count;i++) x = x.next;

        y = a;
        while(y!=x)
        {
            y = y.next; x = x.next;
        }
        return y;

    }
    public static ListNode iscycle(ListNode a)
    {
        ListNode b = a.next, c = a.next.next;
        while(b!=null && c!=null && c.next!=null)
        {

            if(b==c) return b;
            b = b.next; c = c.next.next;
        }
        return null;
    }
}
