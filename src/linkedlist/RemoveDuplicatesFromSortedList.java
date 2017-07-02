package linkedlist;
import java.util.*;
import java.io.*;
public class RemoveDuplicatesFromSortedList
{
    public static ListNode deleteDuplicates(ListNode a)
    {
        if(a==null) return a;
        ListNode node = a.next;
        ListNode prev = a;
        //ListNode next = null;

        while(node!=null)
        {
            //next = node.next;
            if(node.val == prev.val)
            {
                delete(prev);
                node = prev.next;
            }
            else
            {
                node = node.next;
                prev = prev.next;
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

    public static  void delete(ListNode x)
    {
        ListNode y = x.next;
        if(y==null) return;

        x.next = y.next;
        y.next = null;
    }
}
