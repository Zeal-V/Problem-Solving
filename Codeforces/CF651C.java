import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution8 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> xMap = new HashMap<>();
		HashMap<Long, Integer> yMap = new HashMap<>();
		HashMap<String, Integer> pairMap = new HashMap<>();

		Pair[] pairs = new Pair[n];

		long count = 0;
		for (int i = 0; i < n; i++) {
			String[] sa = br.readLine().split(" ");
			pairs[i] = new Pair(Long.parseLong(sa[0]), Long.parseLong(sa[1]));
			xMap.put(pairs[i].l, xMap.getOrDefault(pairs[i].l, 0) + 1);
			yMap.put(pairs[i].r, yMap.getOrDefault(pairs[i].r, 0) + 1);
			pairMap.put(pairs[i].l + " " + pairs[i].r, pairMap.getOrDefault(pairs[i].l + " " + pairs[i].r, 0) + 1);
		}
		long ans = 0;
		for (int i = 0; i < n; i++) {
			if (xMap.get(pairs[i].l) > 1) {
				ans += xMap.get(pairs[i].l) - 1;
				xMap.put(pairs[i].l, xMap.get(pairs[i].l) - 1);
			}
			if (yMap.get(pairs[i].r) > 1) {
				ans += yMap.get(pairs[i].r) - 1;
				yMap.put(pairs[i].r, yMap.get(pairs[i].r) - 1);
			}
			if (pairMap.get(pairs[i].l + " " + pairs[i].r) > 1) {
				ans -= pairMap.get(pairs[i].l + " " + pairs[i].r) - 1;
				pairMap.put(pairs[i].l + " " + pairs[i].r, pairMap.get(pairs[i].l + " " + pairs[i].r) - 1);
			}
		}
		System.out.println(ans);

	}

	static class Pair {
		Long l, r;

		public Pair(long l, long r) {
			this.l = l;
			this.r = r;
		}
	}
}
