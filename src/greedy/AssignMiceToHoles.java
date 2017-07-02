package greedy;
import java.util.*;
import java.io.*;
public class AssignMiceToHoles
{
    public static int mice(ArrayList<Integer> A, ArrayList<Integer> B) {

        int n = A.size();
        int a[] = new int[n];
        int b[] = new int[n];

        int i;
        for(i=0;i<n;i++) a[i] = A.get(i);
        for(i=0;i<n;i++) b[i] = B.get(i);

        mergeSort(a, 0, n-1);
        mergeSort(b, 0, n-1);

        int max = 0;
        for(i=0;i<n;i++)
        {
            int cur = Math.abs(a[i]-b[i]);
            max = max>cur?max:cur;
        }

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

