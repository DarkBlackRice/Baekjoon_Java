package silver.IOIOI_5525;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int N, M, pattLen, i = 0, j = 0, ans = 0;
	static boolean isI;
	static String arr, pattern;

	public static void main(String[] args) throws NumberFormatException, IOException {

//		0. ������ input�ޱ�
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		arr = br.readLine();

//		1. ���� �����
		StringBuilder sb = new StringBuilder();
		sb.append("IOI");
		for (int i = 1; i < N; i++) sb.append("OI");
		pattern = sb.toString();
		pattLen = 2 * N + 1;

//		2. ���Ϻм�
//		2-1. ������ ã�� --> i�� ���ʷ� I�� �����ϴ� ��ǥ�� ����.
		while(arr.charAt(i) != 'I') i++;
		while( ++i <= M-pattLen) {
//			���� �ٷ� ������ I�� ������ �׳� �ٽ� ����
			if (arr.charAt(i) == 'I') continue;
//			�������� ����
			else {
				
			}
			
		}
		
	}

}
