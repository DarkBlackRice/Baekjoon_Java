package silver.IOIOI_5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, M, pattLen, i = 0, j = 0, ans = 0;
	static boolean isI;
	static String arr, pattern;

	public static void main(String[] args) throws NumberFormatException, IOException {

//		0. 데이터 input받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = br.readLine();

//		1. 패턴 만들기
		StringBuilder sb = new StringBuilder();
		sb.append("IOI");
		for (int i = 1; i < N; i++) sb.append("OI");
		pattern = sb.toString();
		pattLen = 2 * N + 1;

//		2. 패턴분석
//		2-1. 시작점 찾기 --> i에 최초로 I가 시작하는 좌표가 담겼다.
		while(arr.charAt(i) != 'I') i++;
		while( ++i <= M-pattLen) {
//			시작 바로 다음에 I가 나오면 그냥 다시 돌아
			if (arr.charAt(i) == 'I') continue;
//			정상적인 시작
			else {
				
			}
			
		}
		
	}

}
