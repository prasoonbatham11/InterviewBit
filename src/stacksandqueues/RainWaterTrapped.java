package stacksandqueues;
import java.util.*;
import java.io.*;
public class RainWaterTrapped
{
    public static int trap(final List<Integer> a)
    {
        LinkedList<Integer> stack = new LinkedList<>();
        int n = a.size();
        int i;
        int[] left = new int[n], right = new int[n];

        for(i=0;i<n;i++) left[i] = right[i] = a.get(i);

        for(i=0;i<n;i++)
        {
            while (!stack.isEmpty())
            {
                if(stack.peek()>=a.get(i))
                {
                    int x = stack.pop();
                    left[i] = stack.pop();
                    stack.push(left[i]);stack.push(x);
                    break;
                }
                else {stack.pop();stack.pop();}

            }

            stack.push(left[i]);stack.push(a.get(i));
        }

        stack.clear();
        for(i=n-1;i>=0;i--)
        {
            while (!stack.isEmpty())
            {
                if(stack.peek()>=a.get(i))
                {
                    int x = stack.pop();
                    right[i] = stack.pop();
                    stack.push(right[i]);stack.push(x);
                    break;
                }
                else {stack.pop();stack.pop();}

            }

            stack.push(right[i]);stack.push(a.get(i));
        }

        int trapped = 0;
        for(i=0;i<n;i++)
        {
            int min = Math.min(left[i], right[i]);
            //System.out.println(min+" "+a.get(i));
            trapped+=min-a.get(i);
        }

        //System.out.println(Arrays.toString(left)+"\n"+Arrays.toString(right));
        return trapped;


    }
}
