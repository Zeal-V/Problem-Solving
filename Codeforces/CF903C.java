import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Solution8 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		HashMap<Long, Integer> map = new HashMap<>();
		String[] sa = br.readLine().split(" ");
		int max = 0;
		for (int i = 0; i < n; i++) 
		{
			long no = Long.parseLong(sa[i]);
			map.put(no, map.getOrDefault(no, 0)+1);
			max = Integer.max(max,map.get(no));
		}
		
		System.out.println(max);

	}

}
//Bruteforce :
//	2 2 4
//	first 2 will fit in 4;
//	total parcels : 4[2] , 2
//	
//	1 2 3 3 4 4 4 5 6
//	Parcel 		Left parcel
//	1->2
//	2->3
//	3->4			3
//	----			3,4
//	----			3,4,4
//	4->5			3,4,4
//	5->6			3,4,4
//	
//	2nd round of arranging parcels that are left
//	
//	3->4			4
//	
//	Total parcels = 3
//					6[5[4[3[2[1]]]]] , 4[3] ,4