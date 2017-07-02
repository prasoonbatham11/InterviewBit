package stacksandqueues;
import java.util.*;
import java.io.*;
public class MinStack
{
    static ArrayList<Integer> stack;
    static ArrayList<Integer> min;
    static int top;

    //Uncomment below to override constructor
    /*Solution()
    {
        stack = new ArrayList<>();
        min = new ArrayList<>();
        top = -1;
    }*/

    public void push(int x) {
        stack.add(x);
        if(isEmpty()) min.add(x);
        else {
            if(min.get(top)>x) min.add(x);
            else min.add(min.get(top));
        }
        top++;
    }

    public void pop() {
        if(isEmpty()) return;
        stack.remove(top);
        min.remove(top);
        top--;
    }

    public int top() {
        if(isEmpty()) return -1;
        return stack.get(top);
    }
    public int getMin() {
        if(isEmpty()) return -1;
        return min.get(top);
    }
    public boolean isEmpty()
    {
        return top==-1;
    }
}
