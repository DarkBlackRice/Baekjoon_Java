package platinum.seriesAndQuery1_13537;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {

    static int N, M, result;
    static int[] arr;
    static Integer temp;
    static TreeMap<Integer, Integer>[] segTree;
    static Map.Entry<Integer, Integer> entry;

    public static void init(int node, int start, int end){
        segTree[node] = new TreeMap<>();
        for (int i = start; i <= end; i++) {
            temp = segTree[node].get(arr[i]);
            if(temp == null){
                temp = 0;
            }
            segTree[node].put(arr[i], temp + 1);
        }
        int num = end - start + 1;
        for ( int key : segTree[node].keySet()) {
            temp = segTree[node].get(key);
            segTree[node].put(key, num);
            num -= temp;
        }

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;

        init(
                node*2,
                start,
                mid
        );

        init(
                node*2+1,
                mid+1,
                end
        );
    }

    public static void numOfLargerNums(int node, int start, int end, int qStart, int qEnd, int value) {

//      완전 미포함
        if(end < qStart || qEnd < start) return;
//      완전 포함
        if (qStart <= start && end <= qEnd) {
            entry = segTree[node].higherEntry(value);
            if(entry != null){
                result += entry.getValue();
            }
            return;
        }
//      그 외
        int mid = (start + end) / 2;

        numOfLargerNums(
                node*2,
                start,
                mid,
                qStart,
                qEnd,
                value
        );

        numOfLargerNums(
                node*2+1,
                mid+1,
                end,
                qStart,
                qEnd,
                value
        );

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N+1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        segTree = new TreeMap[4*N];
        init(1, 1, N);

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int qStart = Integer.parseInt(st.nextToken());
            int qEnd = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            result = 0;
            numOfLargerNums(1, 1, N, qStart, qEnd, value);
            sb.append(result).append('\n');
        }

        System.out.println(sb);
    }
}
