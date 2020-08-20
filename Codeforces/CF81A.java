// https://codeforces.com/contest/81/problem/A
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		Stack<Character> stk = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (stk.empty()) {
				stk.push(s.charAt(i));
			} else {
				if (stk.peek() != s.charAt(i))
					stk.push(s.charAt(i));
				else
					stk.pop();
			}
		}
		StringBuilder sb = new StringBuilder();
		while (!stk.empty())
			sb.append(stk.pop());

		System.out.println(sb.reverse().toString());
	}
}
