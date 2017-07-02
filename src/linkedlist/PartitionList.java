package linkedlist;
import java.util.*;
import java.io.*;
public class PartitionList
{
    public ListNode partition(ListNode a, int b) {
        ListNode x = a;
        ListNode y = new ListNode(0), z = new ListNode(0), g = y, h = z;
        while(x!=null)
        {
            if(x.val<b)
            {
                y.next = new ListNode(x.val);
                y = y.next;
            }
            else {
                z.next = new ListNode(x.val);
                z = z.next;
            }
            x = x.next;
        }
        y.next = h.next;
        return g.next;
    }
}
