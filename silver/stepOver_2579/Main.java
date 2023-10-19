package silver.stepOver_2579;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int arr[], N, ans, sum = 0;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+3];

		for (int i = 3; i < N + 3; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			sum = sum + arr[i];
		}
		ans = sum;

//		System.out.println((Arrays.toString(arr)));

		dfs(N+3, 0);
		System.out.println(sum - ans);
	}

//	가지 않은 계단의 점수를 구하기 (거꾸로 생각하기)
//	step: 이번 단계, score: 이전 단계까지의 점수
	private static void dfs(int step, int score) {
		if (step==N+3 ||arr[step] == 0 && ans > score) {
			ans = score;
			return; 
		}
		if (ans < score)
			return;

		dfs(step - 3, score + arr[step - 3]);
		dfs(step - 2, score + arr[step - 2]);
	}

}
