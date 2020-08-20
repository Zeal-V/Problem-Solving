// https://www.spoj.com/problems/STPAR/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.Stack;

class CF implements Runnable {

	long mod = (long) 1e9 + 7;

	void solve(InputReader in, PrintWriter w) {
		while (true) {
			int n = in.nextInt();
			if (n == 0)
				break;
			int[] a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = in.nextInt();
			}
			Stack<Integer> stk1 = new Stack<Integer>();
			Stack<Integer> stk2 = new Stack<Integer>();
			int no = 1;
			boolean ans = true;
			for(int i=0;i<n;)
			{
				while(!stk1.empty() && stk1.peek()==no)
				{
					no++;
					stk1.pop();
				}
				if(a[i] != no)
				{
					stk1.push(a[i]);
				}
				else
				{
					no++;
				}
				i++;
			}
//			System.out.println(stk1+" "+no);
			while(!stk1.empty() && stk1.peek()==no)
			{
				no++;
				stk1.pop();
			}
//			System.out.println(no);
			if (no == n+1) {
				w.println("yes");
			} else
				w.println("no");
		}
	}

	// ************* Code ends here ***************

	void init() throws Exception {
		// Scanner in;
		InputReader in;
		PrintWriter w;
		boolean online = false;

		String common_in_fileName = "\\Samplein";
		String common_out_fileName = "\\in";
		int test_files = 0;

		for (int file_no = 0; file_no <= test_files; file_no++) {

			String x = "" + file_no;
			if (x.length() == 1)
				x = "0" + x;

			String in_fileName = common_in_fileName;// + "" + x;
			String out_fileName = common_out_fileName + "" + x;

			if (online) {
				// in = new Scanner(new File(in_fileName + ".txt"));
				in = new InputReader(new FileInputStream(new File(in_fileName + ".txt")));
				w = new PrintWriter(new FileWriter(out_fileName + ".txt"));
			} else {
				// in = new Scanner(System.in);
				in = new InputReader(System.in);
				w = new PrintWriter(System.out);
			}

			solve(in, w);
			w.close();
		}
	}

	public void run() {
		try {
			init();
		} catch (Exception e) {
			System.out.println(e);
			e.printStackTrace();
		}
	}

	static class InputReader {

		private InputStream stream;
		private byte[] buf = new byte[1024];
		private int curChar;
		private int numChars;
		private SpaceCharFilter filter;

		public InputReader(InputStream stream) {
			this.stream = stream;
		}

		public int read() {
			if (numChars == -1) {
				throw new InputMismatchException();
			}

			if (curChar >= numChars) {
				curChar = 0;
				try {
					numChars = stream.read(buf);
				} catch (IOException e) {
					throw new InputMismatchException();
				}

				if (numChars <= 0) {
					return -1;
				}
			}
			return buf[curChar++];
		}

		public String nextLine() {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = "";
			try {
				str = br.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return str;
		}

		public int nextInt() {
			int c = read();

			while (isSpaceChar(c)) {
				c = read();
			}

			int sgn = 1;

			if (c == '-') {
				sgn = -1;
				c = read();
			}

			int res = 0;
			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));

			return res * sgn;
		}

		public long nextLong() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			long res = 0;

			do {
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			} while (!isSpaceChar(c));
			return res * sgn;
		}

		public double nextDouble() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			int sgn = 1;
			if (c == '-') {
				sgn = -1;
				c = read();
			}
			double res = 0;
			while (!isSpaceChar(c) && c != '.') {
				if (c == 'e' || c == 'E') {
					return res * Math.pow(10, nextInt());
				}
				if (c < '0' || c > '9') {
					throw new InputMismatchException();
				}
				res *= 10;
				res += c - '0';
				c = read();
			}
			if (c == '.') {
				c = read();
				double m = 1;
				while (!isSpaceChar(c)) {
					if (c == 'e' || c == 'E') {
						return res * Math.pow(10, nextInt());
					}
					if (c < '0' || c > '9') {
						throw new InputMismatchException();
					}
					m /= 10;
					res += (c - '0') * m;
					c = read();
				}
			}
			return res * sgn;
		}

		public String readString() {
			int c = read();
			while (isSpaceChar(c)) {
				c = read();
			}
			StringBuilder res = new StringBuilder();
			do {
				res.appendCodePoint(c);
				c = read();
			} while (!isSpaceChar(c));

			return res.toString();
		}

		public boolean isSpaceChar(int c) {
			if (filter != null) {
				return filter.isSpaceChar(c);
			}
			return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
		}

		public String next() {
			return readString();
		}

		public interface SpaceCharFilter {

			public boolean isSpaceChar(int ch);
		}
	};

	public static void main(String args[]) throws Exception {
		new Thread(null, new CF(), "Sol", 1 << 28).start();
	}
}