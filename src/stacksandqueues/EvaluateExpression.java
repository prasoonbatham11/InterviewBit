package stacksandqueues;
import java.util.*;
import java.io.*;
public class EvaluateExpression
{
    public static int evalRPN(ArrayList<String> A)
    {
        LinkedList<String> stack = new LinkedList<>();

        Iterator<String> i = A.listIterator();

        while(i.hasNext())
        {
            String x = i.next();
            int a, b;
            switch (x)
            {
                case "+":
                    b = Integer.parseInt(stack.pop());
                    a = Integer.parseInt(stack.pop());
                    stack.push((a+b)+"");
                    break;
                case "-":
                    b = Integer.parseInt(stack.pop());
                    a = Integer.parseInt(stack.pop());
                    stack.push((a-b)+"");
                    break;
                case "*":
                    b = Integer.parseInt(stack.pop());
                    a = Integer.parseInt(stack.pop());
                    stack.push((a*b)+"");
                    break;
                case "/":
                    b = Integer.parseInt(stack.pop());
                    a = Integer.parseInt(stack.pop());
                    stack.push((a/b)+"");
                    break;
                default:stack.push(x);
            }
        }

        return Integer.parseInt(stack.pop());
    }
}
