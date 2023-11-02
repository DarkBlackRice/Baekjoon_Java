package gold.commonKnapSack_12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	
	static class Item implements Comparable<Item>{
		int weight, value;

		public Item(int weight, int value) {
			super();
			this.weight = weight;
			this.value = value;
		}

		@Override
		public int compareTo(Item o) {
			return Integer.compare(this.weight, o.weight);
		}
		
		
	}
	
	static int N, K;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < N; i++) {
			
			st = new StringTokenizer(br.readLine());
			
			
		}

	}

}
