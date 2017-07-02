package math;
import java.util.*;
import java.io.*;
public class FizzBuzz
{
    public ArrayList<String> fizzBuzz(int n) {

        int i;
        ArrayList<String> ans = new ArrayList<>();
        String fizz = "Fizz", buzz = "Buzz", fizzbuzz = "FizzBuzz";
        for(i=1;i<=n;i++)
        {
            if(i%3==0 && i%5==0) ans.add(fizzbuzz);
            else if(i%3==0) ans.add(fizz);
            else if(i%5==0) ans.add(buzz);
            else ans.add(i+"");
        }
        return ans;
    }
}

