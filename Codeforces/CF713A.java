// https://codeforces.com/problemset/problem/713/A
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution8 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> map = new HashMap<Long, Integer>();
		while (t-- > 0) {
			String[] sa = br.readLine().split(" ");
			
			if (sa[0].equals("+")) {
				
				String s = sa[1];
				String no = toBinary(s);
				long key = Long.parseLong(no, 2);
				map.put(key, map.getOrDefault(key, 0) + 1);
				
			} else if (sa[0].equals("-")) {
				
				String s = sa[1];
				String no = toBinary(s);
				long key = Long.parseLong(no, 2);
				map.put(key, map.get(key) - 1);
				
			} else {
				
				long key = Long.parseLong(sa[1], 2);
				if(map.containsKey(key))
					System.out.println(map.get(key));
				else
					System.out.println(0);
			}
		}
	}

	public static String toBinary(String s) {
		String no = "";
		for (int i = 0; i < s.length(); i++) {
			no += (s.charAt(i) % 2 == 0 ? 0 : 1);
		}
		return no;
	}
}
