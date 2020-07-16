//https://codeforces.com/contest/424/problem/C
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CF424C {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String[] sa = br.readLine().split(" ");
		long[] preXor = new long[n];
		long[] a = new long[n];

		for (int i = 0; i < n; i++) {
			a[i] = Long.parseLong(sa[i]);
		}
		for (int i = 1; i < n; i++)
			preXor[i] ^= preXor[i - 1] ^ i;

		int ans = 0, x = 0;
		for (int i = 0; i < n; i++) {
			ans ^= a[i];
			x = n % (i + 1);
			if ((n / (i + 1)) % 2 == 0)
				ans ^= preXor[x];
			else
				ans ^= preXor[i] ^ preXor[x];
		}
		System.out.println(ans);
	}
}
