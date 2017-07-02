package linkedlist;
import java.util.*;
import java.io.*;
public class ReverseLinkList2
{
    public static ListNode reverseBetween(ListNode a, int m, int n) {
        ListNode prev = null, cur = a, next = a.next;

        ListNode p = a, x = null, y = null;
        int count = 0;

        while(count<=n+1)
        {

            count++;
            if(count==m-1) {
                x = cur;
                cur = cur.next;
                next = next.next;
            }
            else if(count>=m && count<=n)
            {
                cur.next = prev;
                prev = cur;
                cur = next;
                if(cur!=null)
                    next = cur.next;
            }
            else if(count==n+1)
            {
                y = cur;
                //cur = cur.next;

                if(x==null)
                {
                    //System.out.println(a.val+" "+prev.val);
                    a.next = y;
                    return prev;
                }
                x.next.next = y;
                x.next = prev;
                break;
            }
            else {
                cur = cur.next;
                next = next.next;
            }
        }

        return a;


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
}

