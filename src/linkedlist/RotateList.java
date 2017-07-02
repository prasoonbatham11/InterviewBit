package linkedlist;
import java.util.*;
import java.io.*;
public class RotateList
{
    public static ListNode rotateRight(ListNode a, int b)
    {
        int len = length(a);
        b = b%len;
        if(b==0) return a;
        ListNode c = a, d = a, f = a;
        int i;
        for(i=0;i<b;i++) c = c.next;


        while(c!=null) {
            f = f.next;
            c = c.next;
        }
        c = f;
        f = a;
        while(f.next!=c) {
            f = f.next;
        }
        c = f;

        while(d.next!=null) d = d.next;

        d.next = a;
        ListNode e = c.next;
        c.next = null; return e;

    }
    public static int length(ListNode a)
    {
        ListNode n = a;
        int count = 0;
        while (n!=null)
        {
            count++;
            n = n.next;
        }
        return count;
    }
}
