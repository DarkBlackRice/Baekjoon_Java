package gold.AC_5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int T, n, m, tmp;
	static boolean rev;
	static ArrayDeque<Integer> deque;
	static String func, data;

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer sr;
		
		T = Integer.parseInt(br.readLine());

		for (int i = 0; i < T; i++) {

			rev = false;
			deque = new ArrayDeque<Integer>();

			func = br.readLine();
			n = Integer.parseInt(br.readLine());
			sr = new StringTokenizer(br.readLine(), "[],");
			for (int j = 0; j<n; j++) {
				deque.offer(Integer.parseInt(sr.nextToken()));
			}

//			System.out.println(Arrays.toString(deque.toArray()));
			solution();

		}

	}

	private static void solution() {

		StringBuilder sb = new StringBuilder();

//		�־��� �Լ��� ���̸�ŭ �ݺ��� ����
		m = func.length();
		for (int i = 0; i < m ; i++) {
//			���� R�� ���Դٸ� ��� : false�� ������, true�� ������
			if (func.charAt(i) == 'R')
				rev ^= true;

//			���� D�� ���Դٸ�
			else {
//				deque.isEmpty() ���¿����� �� ��Ʈ������ �����Ͽ� �����޼��� �ְ� �ݺ�����
				if (deque.isEmpty()) {
					System.out.println("error");
					return;
				}
//				�ƴ� ���, ������ �����⿡ ���� �����͸� �̾��ֱ⸸ �Ѵ� (�����ϰų� ���� �ʴ´�)
				if (rev)
					deque.pollLast();
				else
					deque.pollFirst();
			}

		}

//		�ݺ����� �� ������ ����� ���
//		�켱 ��� ����� ���� �� �ڷ� ���ȣ �ֱ�
		sb.append('[');
//		deque�� ũ�Ⱑ 0���� ū��쿡�� �Ʒ��� ��������.
		if(deque.size()>0) {
			
//			���� rev�� true��� ���������� ���ڿ� ����, �ݴ��� ������ ���ڿ� ����
			if (rev) {
				sb.append(deque.pollLast());
				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollLast());
				}
			} else {
				sb.append(deque.pollFirst());
				while (!deque.isEmpty()) {
					sb.append(',').append(deque.pollFirst());
				}
			}
		}

		sb.append(']');

		System.out.println(sb.toString());
		return;
	}

}
