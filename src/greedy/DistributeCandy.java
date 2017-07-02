package greedy;
import java.util.*;
import java.io.*;
public class DistributeCandy
{
    public static int candy(ArrayList<Integer> ratings) {
        int n = ratings.size();
        int candy[] = new int[n];
        Arrays.fill(candy, 1);

        int i;
        for(i=1;i<n;i++)
        {
            if(ratings.get(i)>ratings.get(i-1))
            {
                candy[i] = candy[i-1]+1;
            }
        }
        for(i=n-2;i>=0;i--)
        {
            if(ratings.get(i)>ratings.get(i+1) && candy[i]<=candy[i+1]) {
                candy[i] = candy[i+1]+1;
            }
        }

        int sum = 0;
        for(i=0;i<n;i++) sum+= candy[i];
        return sum;
    }
}