package linkedlist;
import java.util.*;
import java.io.*;
public class RemoveNthNodeFromListEnd
{
    public static ListNode removeNthFromEnd(ListNode a, int n)
    {
        ListNode x = a;
        int len = length(x);

        if(n>=len) return a.next;

        ListNode ref = a, main = a;
        int i=0;
        for(i=0;i<n;i++) ref = ref.next;

        while(ref!=null) {
            ref = ref.next;
            main = main.next;
        }

        ref = a;
        while(ref.next!=main) ref = ref.next;

        delete(ref);

        return a;
    }

    public static void delete(ListNode x)
    {
        ListNode y = x.next;
        if(y==null) return;

        x.next = y.next;
        y.next = null;
    }

    public static int length(ListNode a)
    {
        int count = 0;
        ListNode b = a;
        while(b!=null) {count++;b = b.next;}
        return count;
    }
}
