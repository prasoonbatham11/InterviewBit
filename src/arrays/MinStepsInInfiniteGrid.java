package arrays;
import java.util.*;
import java.io.*;
public class MinStepsInInfiniteGrid
{
    public int coverPoints(ArrayList<Integer> x, ArrayList<Integer> y)
    {
        int i;
        int n = x.size();

        int sum = 0;

        for(i=1;i<n;i++)
        {
            int prevx = x.get(i-1), prevy = y.get(i-1);
            int curx = x.get(i), cury = y.get(i);
            int diff = Math.abs(prevx-prevy);

            int xx = curx;
            int d2 = Math.abs(prevx-xx);

            int yy = prevy + d2;
            int min = Math.abs(yy-cury)+d2;

            yy = prevy-d2;
            int min2 = Math.abs(yy-cury)+d2;

            yy = cury;
            d2 = Math.abs(prevy - yy);

            xx = prevx+d2;
            int min3 = Math.abs(xx-curx)+d2;

            xx = prevx-d2;
            int min4 = Math.abs(xx-curx)+d2;

            sum += Math.min(Math.min(min, min2), Math.min(min3, min4));




        }
        return sum;
    }
}