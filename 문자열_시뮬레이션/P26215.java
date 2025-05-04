import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class P26215 {
    public static void main(String[] args) throws IOException {
        /* 
         * 26125번: 눈 치우기
         * 
         * [문제]
         * 지난 밤 겨울 숲에는 눈이 많이 내렸다. 
         * 당신은 숲의 주민들을 위해 눈이 오지 않는 동안 모든 집 앞의 눈을 치우고자 한다.
         * 당신은 1분에 한 번씩 두 집을 선택해서 두 집 앞의 눈을 각각 1만큼 치우거나, 
         * 한 집을 선택해서 그 집 앞의 눈을 1만큼 치울 수 있다.
         * 모든 집 앞의 눈을 전부 치울 때까지 걸리는 최소 시간은 얼마일까?
         * 
         * [입력]
         * 첫 줄에 집의 수를 의미하는 정수 N(1 <= N <= 100)이 주어진다.
         * 다음 줄에는 각각의 집 앞에 쌓여 있는 눈의 양을 나타내는 정수 a(1 <= a <= 2000)이 주어진다.
         * 
         * [출력]
         * 모든 집 앞의 눈을 치우는 데 최소 몇 분이 걸리는지를 출력한다. 
         * 24시간(1440분)이 넘게 걸릴 경우 -1을 출력한다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        /* 
        * StringTokenizer: 문자열을 토큰(단어, 숫자 등의 조각) 단위로 처리할 때 사용
        * - split()은 정규식을 기반으로 문자열을 배열로 반환하므로 상대적으로 느림
        * - 반복문 또는 대용량 입력이 많은 경우 StringTokenizer가 더 적합
        * - 기본 구분자: 공백(" ")
        */
        StringTokenizer st = new StringTokenizer(br.readLine());
        int sum = 0;
        int max = 0;

        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            sum += a; // 전체 눈의 양 합계
            max = Math.max(max, a); // 가장 많이 쌓인 집의 눈의 양
        }

        // 최소 시간 = 가장 많이 쌓인 눈의 양 vs 전체 눈의 양 / 2
        int min = Math.max(max, (sum + 1) / 2);
        System.out.println(min <= 1440 ? min : -1);
    }
}