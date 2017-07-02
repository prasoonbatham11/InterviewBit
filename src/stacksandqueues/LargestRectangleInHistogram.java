package stacksandqueues;
import java.util.*;
import java.io.*;
public class LargestRectangleInHistogram
{
    public static int largestRectangleArea(ArrayList<Integer> a)
    {
        LinkedList<Integer> stack = new LinkedList<>();
        int i;

        int n = a.size();

        int left[] = new int[n], right[] = new int[n];

        for(i=0;i<n;i++)
        {
            left[i] = right[i] = i;
        }

        for(i=0;i<n;i++)
        {
            while(!stack.isEmpty() && stack.peek()>=a.get(i)) {
                stack.pop();
                int idx = stack.pop();
                left[i] = idx;
            }

            if(stack.isEmpty()) left[i] = 0;

            stack.push(left[i]); stack.push(a.get(i));
        }



        stack.clear();

        for(i=n-1;i>=0;i--)
        {
            while (!stack.isEmpty() && stack.peek()>=a.get(i)) {
                stack.pop();
                int idx = stack.pop();
                right[i] = idx;
            }
            stack.push(right[i]);stack.push(a.get(i));
        }

        int max = 0;

        for(i=0;i<n;i++)
        {
            int l = a.get(i)*(right[i]-left[i]+1);
            max = max>l?max:l;
        }

        //System.out.println(Arrays.toString(left)+"\n"+Arrays.toString(right));

        return max;
    }
}
