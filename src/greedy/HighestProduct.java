package greedy;
import java.util.*;
import java.io.*;
public class HighestProduct
{
    public static int maxp3(ArrayList<Integer> a)
    {
        int n = a.size();
        int b[] = new int[n];
        int i;
        for(i=0;i<n;i++) b[i] = a.get(i);

        mergeSort(b, 0, n-1);

        int max = b[0]*b[1]*b[n-1];
        max = Math.max(max, b[n-1]*b[n-2]*b[n-3]);

        return max;

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