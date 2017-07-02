package greedy;
import java.util.*;
import java.io.*;
public class MajorityElement
{
    public static int majorityElement(final List<Integer> a) {
        int i;
        int n= a.size();
        int b[] = new int[n];
        for(i=0;i<n;i++) b[i] = a.get(i);

        mergeSort(b, 0, n-1);

        int max = n/2;
        int c = 1;
        for(i=1;i<n;i++)
        {
            if(b[i]!=b[i-1])
            {
                if(c>max) return b[i-1];
                c=1;
            }
            else c++;
        }
        return b[n/2];

    }
    public static void mergeSort(int a[],int left,int right)
    {
        int mid=(left+right)/2;
        if(left<right)
        {
            mergeSort(a,left,mid);
            mergeSort(a,mid+1,right);
            merge(a,left,mid,right);
        }
    }
    public static void merge(int a[],int left,int mid,int right)
    {
        int t[]=new int[right-left+1];
        int pos=0,lpos=left,rpos=mid+1;
        while(lpos<=mid&&rpos<=right)
        {
            if(a[lpos]<a[rpos])
                t[pos++]=a[lpos++];
            else
                t[pos++]=a[rpos++];
        }
        while(lpos<=mid) t[pos++]=a[lpos++];
        while(rpos<=right) t[pos++]=a[rpos++];
        while(--pos>=0) a[pos+left]=t[pos];
    }
}



