package greedy;
import java.util.*;
import java.io.*;
public class Seats
{
    public static int MOD = 10000003;

    public static int seats(String str)
    {
        int i;
        int n = str.length();
        int start = -1, end = -2;
        int b[] = new int[n];
        int c[] = new int[n];
        int k = 0;

        i = 0;
        int max = Integer.MIN_VALUE;
        while(i<n)
        {
            //System.out.println("s "+i+" "+str.charAt(i));
            if(str.charAt(i)=='x')
            {
                b[k] = i;
                while(i<n && str.charAt(i)=='x') i++;
                c[k++] = i-1;

                max = Math.max(c[k-1]-b[k-1]+1, max);
            }

            else i++;
        }

        if(k==0) return 0;
        int med = median(b, k);

        //System.out.println(med);

        //System.out.println(start+" "+end);
        int min = Integer.MAX_VALUE;
        if(k%2==0)
        {

            start = b[med]; end = c[med];
            //System.out.println(start+" "+end);
            min = solve(str, start, end);
            //System.out.println(min);
            start = b[med+1]; end = c[med+1];
            //System.out.println(start+" "+end);
            //System.out.println(solve(str, start, end));
            int x = solve(str, start, end);
            boolean flag = false;
            if(min<x)
            {
                min = x;
                flag = true;
            }
            //if(flag && max==c[med+1]-b[med]+1) return min;
            //else if(!flag && max==c[med]-b[med]+1) return min;
            //System.out.println(min);

        }
        else {
            min = solve(str, b[med], c[med]);
            //if(max == c[med]-b[med]+1) return min;
        }

        int count = 0;

        for(i=0;i<n;i++) if(str.charAt(i)=='x') count++;

        int mid = 0;
        for(i=0;i<n;i++) {
            if(str.charAt(i) == 'x'){
                mid++;
                if(mid == (count/2)+1){
                    mid = i;
                    break;
                }
            }
        }

        //System.out.println(mid);

        start = mid; end = mid;
        while(start>=0 && str.charAt(start)=='x') start--;
        start++;
        while(end<n && str.charAt(end)=='x') end++;
        end--;

        //System.out.println(start+" "+end);

        min = solve(str, start, end);
        return min;



        /*for(i=0;i<k;i++)
        {
            //System.out.println(b[i]+" "+c[i]+" "+solve(str, b[i], c[i]));
            if(max==c[i]-b[i]+1);
            min = Math.min(min, solve(str, b[i], c[i]));

        }

        return min;*/


    }
    public static int solve(String str, int start, int end)
    {
        //System.out.println(start+ " "+end );
        int n = str.length();
        int count = 0;
        int i = start-1;
        start--;
        while(i>=0 && i<n)
        {
            //System.out.println("start "+i+" " + start);
            if(str.charAt(i)=='x')
            {
                count = (count+(((start)%MOD-(i)%MOD)+MOD)%MOD)%MOD;
                start--;
            }
            i--;
        }
        i = end+1;
        end++;
        while(i<n && i>=0)
        {

            //System.out.println("end "+i+" " + end);
            //System.out.println(i+" "+"fdfd");
            if(str.charAt(i)=='x')
            {
                count = (count+(((i)%MOD-(end)%MOD)+MOD)%MOD)%MOD;
                end++;
            }
            i++;
        }

        return count;
    }
    public static int median(int a[], int n)
    {
        //System.out.println(n);
        if(n%2==0)
        {
            return n/2-1;
        }
        else return n/2;
    }
}
