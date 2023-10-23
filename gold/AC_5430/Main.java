package gold.AC_5430;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	static int T, n, tmp;
	static boolean rev;
	static ArrayDeque<Integer> deque;
	static String func, data;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for (int i = 0; i< T; i++) {
			
			func = br.readLine();
			n = Integer.parseInt(br.readLine());
			data = br.readLine();
			if (n != 0) {
				for (int j = 1; j < 2*n; j += 2) {
					deque.offer((int)data.charAt(j));
				}
			}			
		}
		
		solution();
		
	}
	
	private static void solution() {

		StringBuilder sb = new StringBuilder();
		
//		�־��� �Լ��� ���̸�ŭ �ݺ��� ����
		for (int i=0; i<func.length(); i++) {
//			���� R�� ���Դٸ� ��� : false�� ������, true�� ������
			if(func.charAt(i) == 'R') rev ^= true;
			
//			���� D�� ���Դٸ�
			else {
//				deque.isEmpty() ���¿����� �� ��Ʈ������ �����Ͽ� �����޼��� �ְ� �ݺ�����
				if (deque.isEmpty()) {
					System.out.println("error\n");
					return;
				}
//				�ƴ� ���, ������ �����⿡ ���� �����͸� �̾��ֱ⸸ �Ѵ� (�����ϰų� ���� �ʴ´�)
				if (rev) deque.pollLast();
				else deque.pollFirst();
			}
			
		}	
		
//		�ݺ����� �� ������ ����� ���
//		�켱 ��� ����� ���� �� �ڷ� ���ȣ �ֱ�
		sb.append('[');
		
//		���� rev�� true��� ���������� ���ڿ� ����, �ݴ��� ������ ���ڿ� ����
		if (rev) {
			while(!deque.isEmpty()) {
				sb.append(deque.pollLast().toString());
				sb.append(',');
			}
		}else {
			while(!deque.isEmpty()) {
				sb.append(deque.pollFirst().toString());
				sb.append(',');
			}
		}
		
		sb.append(']');
		
		System.out.println(sb);
		return;
	}

}
