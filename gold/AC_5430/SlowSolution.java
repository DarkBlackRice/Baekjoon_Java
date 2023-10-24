package gold.AC_5430;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class SlowSolution {

    static int T, n, tmp;
    static boolean rev;
    static ArrayDeque<Integer> deque;
    static String func, data;

    public static void main(String[] args) throws NumberFormatException, IOException {
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sr;
        T = Integer.parseInt(br.readLine());
        
        for (int i = 0; i< T; i++) {
            
            rev = false;
            deque = new ArrayDeque<Integer>();
            
            func = br.readLine();
            n = Integer.parseInt(br.readLine());
            data = br.readLine();
            
            if (n != 0) {
                data = data.substring(1,data.length()-1);
                sr = new StringTokenizer(data,",");
                while(sr.countTokens()>0) {
                    deque.offer(Integer.parseInt(sr.nextToken()));
                }
            }        
            
//            System.out.println(Arrays.toString(deque.toArray()));
            solution();
            
        }
        
        
        
    }
    
    private static void solution() {

        StringBuilder sb = new StringBuilder();
        
//        �־��� �Լ��� ���̸�ŭ �ݺ��� ����
        for (int i=0; i<func.length(); i++) {
//            ���� R�� ���Դٸ� ��� : false�� ������, true�� ������
            if(func.charAt(i) == 'R') rev ^= true;
            
//            ���� D�� ���Դٸ�
            else {
//                deque.isEmpty() ���¿����� �� ��Ʈ������ �����Ͽ� �����޼��� �ְ� �ݺ�����
                if (deque.isEmpty()) {
                    System.out.println("error");
                    return;
                }
//                �ƴ� ���, ������ �����⿡ ���� �����͸� �̾��ֱ⸸ �Ѵ� (�����ϰų� ���� �ʴ´�)
                if (rev) deque.pollLast();
                else deque.pollFirst();
            }
            
        }    
        
//        �ݺ����� �� ������ ����� ���
//        �켱 ��� ����� ���� �� �ڷ� ���ȣ �ֱ�
        sb.append('[');
        
//        ���� rev�� true��� ���������� ���ڿ� ����, �ݴ��� ������ ���ڿ� ����
        if (rev) {
            while(!deque.isEmpty()) {
                sb.append(deque.pollLast());
                sb.append(',');
            }
        }else {
            while(!deque.isEmpty()) {
                sb.append(deque.pollFirst());
                sb.append(',');
            }
        }
        if (sb.length()>1) sb.deleteCharAt(sb.length()-1);
        sb.append(']');
        
        System.out.println(sb);
        return;
    }

}
