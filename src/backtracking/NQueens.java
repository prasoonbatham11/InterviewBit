package backtracking;
import java.util.*;
import java.io.*;
public class NQueens
{
    static ArrayList<ArrayList<String>> ans;
    static char board[][];
    static int n;
    public static ArrayList<ArrayList<String>> solveNQueens(int a)
    {
        n = a;
        board = new char[n][n];
        int i,j;
        for(i=0;i<n;i++) for(j=0;j<n;j++) board[i][j] = '.';

        ans = new ArrayList<>();

        nqueens(0);
        return ans;

    }

    public static void nqueens(int i)
    {
        if(i==n) addtoans();

        int j;
        for(j=0;j<n;j++)
        {
            if(isSafe(i,j))
            {
                board[i][j] = 'Q';
                nqueens(i+1);
                board[i][j] = '.';
            }
        }
    }
    public static void addtoans()
    {
        ArrayList<String> temp = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int i,j;
        for(i=0;i<n;i++)
        {
            sb = new StringBuilder();
            for(j=0;j<n;j++)
            {
                sb.append(board[i][j]);
            }
            temp.add(sb.toString());
        }
        ans.add(temp);
    }
    public static boolean isSafe(int i, int j)
    {
        int x, y;
        for(x=0;x<n;x++) if(board[x][j]=='Q') return false;
        for(y=0;y<n;y++) if(board[i][y]=='Q') return false;

        x = i; y = j;
        while(x>=0 && x<n && y>=0 && y<n)
        {
            if(board[x][y]=='Q') return false;
            x--; y--;
        }
        x = i; y = j;
        while(x>=0 && x<n && y>=0 && y<n)
        {
            if(board[x][y]=='Q') return false;
            x--; y++;
        }
        x = i; y = j;
        while(x>=0 && x<n && y>=0 && y<n)
        {
            if(board[x][y]=='Q') return false;
            x++; y--;
        }
        x = i; y = j;
        while(x>=0 && x<n && y>=0 && y<n)
        {
            if(board[x][y]=='Q') return false;
            x++; y++;
        }

        return true;
    }
}
