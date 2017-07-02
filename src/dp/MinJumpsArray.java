package dp;
import java.util.*;
import java.io.*;
public class MinJumpsArray {
    public static int jump(ArrayList<Integer> a) {


        int n = a.size();

        if (n <= 1) return 0;
        if (a.get(0) == 0) return -1;
        //int dp[] = new int[n];
        int i, j;
        int jump = 1;
        int steps = a.get(0);
        int maxReach = a.get(0);

        for (i = 1; i < n; i++) {
            if (i == n - 1) return jump;

            steps--;
            maxReach = Math.max(maxReach, i + a.get(i));

            if (steps == 0) {
                jump++;
                if (i >= maxReach) return -1;
                steps = maxReach - i;
            }
        }
        return -1;
    }
}