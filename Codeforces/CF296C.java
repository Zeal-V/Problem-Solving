//https://codeforces.com/contest/296/problem/C

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CF296C {

    static int c = 0;
    public static void main (String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] sa1 = br.readLine().split(" ");
        int n = Integer.parseInt(sa1[0]);
        int m = Integer.parseInt(sa1[1]);
        int k = Integer.parseInt(sa1[2]);
        int[] l = new int[m];
        int[] r = new int[m];
        int[] d = new int[m];
        
        long[] a = new long[n];
        String[] sa2 = br.readLine().split(" ");
        for(int i=0;i<n;i++)
        {
        	a[i] = Integer.parseInt(sa2[i]);
        }
        for(int i= 0;i<m;i++)
        {
        	String[] sa = br.readLine().split(" ");
        	l[i] = Integer.parseInt(sa[0]);
        	r[i] = Integer.parseInt(sa[1]);
        	d[i] = Integer.parseInt(sa[2]);
        }
        
        long[] q = new long[m+1];
        for(int i=0;i<k;i++)
        {
        	String[] sa = br.readLine().split(" ");
        	int x = Integer.parseInt(sa[0]);
        	int y = Integer.parseInt(sa[1]);
        	q[x]++;
        	if(y+1<=m)
        	q[y+1]--;
        }
        for(int j=1;j<m+1;j++)
        {
        	q[j]+=q[j-1];
        }
//        System.out.println(Arrays.toString(q));
        long[] gold = new long[n];
        for(int i=0;i<m;i++)
        {
        	gold[l[i]-1] += (d[i]*q[i+1]);
        	if(r[i]<n)
        		gold[r[i]] -= (d[i]*q[i+1]);
        }
        for(int i=1;i<n;i++)
        	gold[i]+=gold[i-1];
        for(int i=0;i<n;i++)
        {
        	a[i]+=gold[i];
        }
        
        for(int i=0;i<n;i++)
        	System.out.print(a[i]+" ");
    }
    
}