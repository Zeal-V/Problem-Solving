//https://codeforces.com/contest/660/problem/A
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CF660A {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		long[] a = new long[n];
		String[] sa1 = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(sa1[i]);
		}
		List<Long> list = new ArrayList<Long>();
		int j = 1;
		list.add(a[0]);

		while (j < n) {
			long gcd = gcd(a[j - 1], a[j]);
			if (gcd == 1) {
				list.add(a[j]);
				j++;
			} else {
				list.add((long) 1);
				list.add(a[j]);
				j++;
			}
		}
		System.out.println(list.size() - n);
		for (int i = 0; i < list.size(); i++)
			System.out.print(list.get(i) + " ");
	}

	static long gcd(long a, long b) {
		long min = Long.min(a, b);
		long max = Long.max(a, b);

		if (max % min == 0)
			return min;
		else
			return gcd(max % min, min);
	}
}