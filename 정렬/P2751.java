import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class P2751 {
    public static void main(String[] args) throws IOException {
        /* 
         * 2751번: 수 정렬하기 2
         * 
         * [문제]
         * N개의 수가 주어졌을 때, 이를 오름차순으로 정렬하는 프로그램을 작성하시오.
         * 
         * [입력]
         * 첫째 줄에 수의 개수 N(1 ≤ N ≤ 1,000,000)이 주어진다. 
         * 둘째 줄부터 N개의 줄에는 수가 주어진다. 
         * 이 수는 절댓값이 1,000,000보다 작거나 같은 정수이다. 
         * 수는 중복되지 않는다.
         * 
         * [출력]
         * 첫째 줄부터 N개의 줄에 오름차순으로 정렬한 결과를 한 줄에 하나씩 출력한다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);

        // System.out.println() 반복 호출 속도 개선
        StringBuilder sb = new StringBuilder();
        for (int num : arr) {
            sb.append(num).append('\n');
        }
        System.out.print(sb);
    }
}