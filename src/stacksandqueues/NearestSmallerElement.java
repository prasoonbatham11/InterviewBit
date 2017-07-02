package stacksandqueues;
import java.util.*;
import java.io.*;
public class NearestSmallerElement
{
    public static ArrayList<Integer> prevSmaller(ArrayList<Integer> arr)
    {
        int i;
        int n = arr.size();
        LinkedList<Integer> stack = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for(i=0;i<n;i++)
        {
            while(!stack.isEmpty() && stack.peek()>=arr.get(i)) stack.pop();

            if(stack.isEmpty()) ans.add(-1);
            else {
                ans.add(stack.peek());
            }
            stack.push(arr.get(i));
        }

        return ans;
    }
}
