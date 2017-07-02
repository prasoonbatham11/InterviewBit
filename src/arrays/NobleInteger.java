package arrays;
import java.util.*;
import java.io.*;
public class NobleInteger
{
    public int solve(ArrayList<Integer> arrayList)
    {
        int n = arrayList.size();
        int i;
        int a[] = new int[n];
        for(i=0;i<n;i++) a[i] = arrayList.get(i);

        mergeSort(a, 0, n-1);

        for(i=0;i<n;i++)
        {
            int p = a[i];
            int upper = upperbound(a, n, p);

            int x = n - upper;
            if(p==x) return 1;
        }
        return -1;
    }
    public void mergeSort(int a[],int left,int right)
    {
        int mid=(left+right)/2;
        if(left<right)
        {
            mergeSort(a,left,mid);
            mergeSort(a,mid+1,right);
            merge(a,left,mid,right);
        }
    }
    public void merge(int a[],int left,int mid,int right)
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
    public int lowerBound(int a[], int n, int x)
    {
        int l = 0;
        int h = n;
        while(l<h)
        {
            int m = (l+h)/2;
            if(x<=a[m]) h = m;
            else l = m+1;
        }
        return l;
    }
    public int upperbound(int a[], int n, int x)
    {
        int l = 0;
        int h = n;
        while(l<h)
        {
            int m = (l+h)/2;
            if(x>=a[m]) l = m+1;
            else h = m;
        }
        return l;
    }
}

