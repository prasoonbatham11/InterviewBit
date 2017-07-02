package linkedlist;
import java.util.*;
import java.io.*;
public class PalindromeList
{
    public static int lPalin(ListNode a)
    {
        if(a.next==null) return 1;
        if(a==null) return 1;
        ListNode x = a;
        ListNode m = reverse(x);

        while(x!=null && m!=null)
        {
            if(x.val!=m.val) return 0;
            x = x.next; m = m.next;
        }

        return 1;


    }

    public static ListNode reverse(ListNode a)
    {
        ListNode x = a;
        ListNode z = a;

        //print(a);

        ListNode y = middle(x);

        //print(y);

        int mid = y.val;

        while(x.next!=y) x = x.next;

        //System.out.println(x.val);

        ListNode prev = null;
        ListNode cur = y;
        ListNode next = cur.next;
        while(cur!=null)
        {
            /*System.out.println(
                    (prev!=null?prev.val:0)+" "+
                            (cur!=null?cur.val:0)+ " "+
                            (next!=null? next.val:0)
            );*/
            cur.next = prev;
            prev = cur;
            cur = next;
            if(cur!=null)
                next = cur.next;
        }

        //System.out.println(y.val);

        x.next = prev;
        //print(a);

        if(isOdd(z)) addAfter(x, mid);

        //print(a);

        //System.out.println(" fsa"+prev.val);

        return prev;
    }
    public static void print(ListNode a)
    {
        ListNode b = a;
        while(b!=null) {
            System.out.print(b.val+" ");
            b = b.next;
        }
        System.out.println();
    }
    public static void addAfter(ListNode x, int val)
    {
        if(x==null) return;
        ListNode nextofx = x.next;
        ListNode node = new ListNode(val);

        x.next = node;
        node.next = nextofx;
    }
    public static boolean isOdd(ListNode a)
    {
        ListNode ptr = a;
        while(true)
        {
            ptr = ptr.next.next;
            if(ptr==null) return false;
            else if(ptr.next==null) return true;
        }
    }
    public static ListNode middle(ListNode a)
    {
        ListNode n = a, m = a;

        while(m!=null && m.next!=null)
        {
            n = n.next;
            m = m.next.next;
        }
        return n;

    }
}
