package linkedlist;
import java.util.*;
import java.io.*;
public class RemoveDuplicatesFromSortedList2
{
    public static ListNode deleteDuplicates(ListNode a)
    {
        if(a==null) return a;
        ListNode prev = a, cur = a.next, prevprev = null, b = a;
        boolean is = false;
        while(cur!=null)
        {
            //System.out.println((prevprev!=null?prevprev.val:0)+" "+
            //      (prev!=null?prev.val:0)+" "+
            //    (cur!=null?cur.val:0));
            if(cur.val==prev.val)
            {
                delete(prev);
                cur = prev.next;
                is = true;
            }
            else if(is)
            {
                if(prevprev==null)
                {
                    b = prev.next;
                    cur = cur.next;
                    prev.next = null;
                    prev = b;
                }
                else {
                    delete(prevprev);
                    prev = prevprev.next;
                    cur = prev!=null?prev.next:null;
                }
                is = false;
            }
            else {
                prevprev = prev;
                prev = prev.next;
                cur = cur.next;
            }
        }
        if(is)
        {
            if(prevprev==null)
            {
                b = prev.next;
                cur = prev!=null?prev.next:null;
            }
            else {
                delete(prevprev);
                prev = prevprev.next;
                cur = prev!=null?prev.next:null;
            }
            is = false;
        }
        return b;
    }

    public static  void delete(ListNode x)
    {
        ListNode y = x.next;
        if(y==null) return;

        x.next = y.next;
        y.next = null;
    }
}
