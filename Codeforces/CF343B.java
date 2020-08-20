//https://codeforces.com/contest/343/problem/B
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution9 {
	public static void main (String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stk = new Stack<>();
		String s = br.readLine();
		for(int i=0;i<s.length();i++)
		{
			if(stk.empty() || stk.peek()!=s.charAt(i))
			{
				stk.push(s.charAt(i));
			}
			else
			{
				stk.pop();
			}
		}
		if(stk.empty())
		    System.out.println("Yes");
		else
			System.out.println("No");
	}
}
