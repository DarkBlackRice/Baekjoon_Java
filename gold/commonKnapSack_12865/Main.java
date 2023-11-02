package gold.commonKnapSack_12865;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static int N, K, w;
	static int dp[], comp[], weight[];
	static boolean flag;

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		weight = new int[N];
		
		for (int i = 0; i < N; i++) {
		
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			weight[i] = w;
			
		}
		
		Arrays.sort(weight);
		dp = new int[K+1];
		
		
		for (int i = 0; i <= K; i++) {
			flag=false;
			comp = new int[N];
			Arrays.fill(comp, Integer.MAX_VALUE);
			for (int j = 0; j < N; j++) {
				w = weight[j];
				if (i<w) break;
				flag = true;
				comp[j] = dp[i-w] + 1;
			}
			if(flag) {
				dp[i] = Integer.MAX_VALUE;
				for (int j = 0; j < N; j++) {
					if(dp[i] > comp[j]) dp[i] = comp[j];
				}
			}
		}
		
		System.out.println(Arrays.toString(dp));

	}

}
