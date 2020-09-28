// https://www.spoj.com/problems/SUBMERGE/

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Solution14 {
	static int timeStamp;
	static boolean[] vis;
	static boolean[] isAp;
	static int[] disc,low;
	static int cnt = 0;
	public static void main(String[] args) throws NumberFormatException, IOException  {

		Scan sc = new Scan();
		Print print = new Print();
		while(true)
		{
			int n = sc.scanInt();
			int m = sc.scanInt();
			if(n==0 && m==0)
				break;
			
			timeStamp = 0;
			vis = new boolean[n+1];
			isAp = new boolean[n+1];
			low = new int[n+1];
			disc = new int[n+1];
			cnt = 0;
			
			ArrayList<Integer>[] adj = new ArrayList[n+1];
			for(int i=0;i<=n;i++)
				adj[i] = new ArrayList<>();
			
			for(int i=0;i<m;i++)
			{
				int x = sc.scanInt();
				int y = sc.scanInt();
				adj[x].add(y);
				adj[y].add(x);
			}
			
			dfs(adj,1,-1);
			cnt = 0;
			for(int i=0;i<=n;i++)
			{
				cnt+=isAp[i]?1:0;
			}
			print.print(cnt+"\n");
		}
		print.close();		
	}
	private static void dfs(ArrayList<Integer>[] adj, int node, int par) {
		 
		vis[node] = true;
		timeStamp++;
		disc[node] = timeStamp;
		low[node] = disc[node];
		
		int children = 0;
		
		for(int i=0;i<adj[node].size();i++)
		{
			if(!vis[adj[node].get(i)])
			{
				dfs(adj,adj[node].get(i),node);
				children ++;
				if(par!=-1 && low[adj[node].get(i)] == disc[node])
				{
					isAp[node] = true;
					cnt++;
				}
				low[node] = Math.min(low[adj[node].get(i)],low[node]);
			}
			else
			{
				low[node] = Math.min(disc[adj[node].get(i)],low[node]);
			}
			if(par==-1 && children>1)
			{
				isAp[node] = true;
				cnt++;
			}
		}
		
	}
}
class Pair
{
	  int val;
	  String s;
	  Pair(int a,String i)
	  {
		  this.val = a;
		  this.s = i;
	  }
}

//        ************* Code ends here ***************
class Scan
{
	private byte[] buf=new byte[1024];
	private int index;
	private InputStream in;
	private int total;
	public Scan()
	{
		in=System.in;
	}
	public int scan()throws IOException
	{
		if(total<0)
		throw new InputMismatchException();
		if(index>=total)
		{
			index=0;
			total=in.read(buf);
			if(total<=0)
			return -1;
		}
		return buf[index++];
	}
	public int scanInt()throws IOException
	{
		int integer=0;
		int n=scan();
		while(isWhiteSpace(n))
		n=scan();
		int neg=1;	
		if(n=='-')
		{
			neg=-1;
			n=scan();
		}
		while(!isWhiteSpace(n))
		{
			if(n>='0'&&n<='9')
			{
				integer*=10;
				integer+=n-'0';
				n=scan();
			}
			else throw new InputMismatchException();
		}
		return neg*integer;
	}
	public double scanDouble()throws IOException
	{
		double doub=0;
		int n=scan();
		while(isWhiteSpace(n))
		n=scan();
		int neg=1;
		if(n=='-')
		{
			neg=-1;
			n=scan();
		}
		while(!isWhiteSpace(n)&&n!='.')
		{
			if(n>='0'&&n<='9')
			{
				doub*=10;
				doub+=n-'0';
				n=scan();
			}
			else throw new InputMismatchException();
		}
		if(n=='.')
		{
			n=scan();
			double temp=1;
			while(!isWhiteSpace(n))
			{
				if(n>='0'&&n<='9')
				{
					temp/=10;
					doub+=(n-'0')*temp;
					n=scan();
				}
				else throw new InputMismatchException();
			}
		}
		return doub*neg;
	}
	public String scanString()throws IOException
	{
		StringBuilder sb=new StringBuilder();
		int n=scan();
		while(isWhiteSpace(n))
		n=scan();
		while(!isWhiteSpace(n))
		{
			sb.append((char)n);
			n=scan();
		}
		return sb.toString();
	}
	private boolean isWhiteSpace(int n)
	{
		if(n==' '||n=='\n'||n=='\r'||n=='\t'||n==-1)
		return true;
		return false;
	}
}

class Print
{
	private final BufferedWriter bw;
	public Print()
	{
		bw=new BufferedWriter(new OutputStreamWriter(System.out));
	}
	public void print(String str)throws IOException
	{
		bw.append(str);
	}
	public void printLine(String str)throws IOException
	{
		print(str);
		bw.append("");
	}
	public void close()throws IOException
	{
		bw.close();
	}
}

