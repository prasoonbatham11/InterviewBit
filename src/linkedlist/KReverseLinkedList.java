package linkedlist;
import java.util.*;
import java.io.*;
public class KReverseLinkedList
{
    public static ListNode reverseList(ListNode a, int k)
    {
        int count = 0;
        if(a==null) return a;
        ListNode prev = null, cur = a, next = a.next;
        ListNode pp = null, nn = null;
        ListNode b = a, xx = a;

        while(cur!=null)
        {
            count = 0;
            while(count<k)
            {
                cur.next = prev;
                prev = cur;
                cur = next;
                next = next!=null?next.next:null;
                count++;
            }
            nn = cur;
            if(pp==null) b = prev;
            xx.next = nn;

            if(pp!=null) pp.next = prev;
            pp = xx;
            prev = null;
            xx = nn;
        }

        return b;
    }
}
