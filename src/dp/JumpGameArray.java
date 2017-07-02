package dp;
import java.util.*;
import java.io.*;
public class JumpGameArray
{
    public int canJump(ArrayList<Integer> a) {
        int n = a.size();
        boolean vis[] = new boolean[n];
        Arrays.fill(vis, false);
        vis[0] = true;

        int i, j,k;
        for(i=0;i<n;i++)
        {
            j = i+a.get(i)<n?i+a.get(i):n-1;
            if(!vis[i]) continue;
            for(k=i+1;k<=j;k++)
            {
                vis[k] = true;
            }
        }

        return vis[n-1]?1:0;
    }
}


