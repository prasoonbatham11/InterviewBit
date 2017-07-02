package arrays;
import java.util.*;
import java.io.*;
public class AddOneToNumber
{
    public  ArrayList<Integer> plusOne(ArrayList<Integer> n)
    {
        int len = n.size();
        int i;

        int a[] = new int[2*len];

        int k = 2*len-1;
        int carry = 1;

        for(i=len-1;i>=0;i--)
        {
            int x = n.get(i)+carry;
            carry = x/10;
            a[k--] = x%10;
        }

        while(carry>0)
        {
            a[k--] = carry%10;
            carry/=10;
        }

        ArrayList<Integer> ans = new ArrayList<>();

        for(i=0;i<a.length;i++)
        {
            if(a[i]>0) break;
        }

        while(i<a.length)
        {
            ans.add(a[i]);
            i++;
        }

        return ans;
    }
}
