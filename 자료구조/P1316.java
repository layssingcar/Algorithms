import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P1316 {
    public static void main(String[] args) throws IOException {
        /* 
		 * 1316번: 그룹 단어 체커
		 * 
		 * [문제]
		 * 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다. 
         * 예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만, aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
         * 단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
		 * 
		 * [입력]
		 * 첫째 줄에 단어의 개수 N이 들어온다. 
         * N은 100보다 작거나 같은 자연수이다. 
         * 둘째 줄부터 N개의 줄에 단어가 들어온다. 
         * 단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
		 * 
		 * [출력]
		 * 첫째 줄에 그룹 단어의 개수를 출력한다.
		 */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int cnt = 0;
 
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            int length = str.length();
            boolean[] visited = new boolean[26]; // 알파벳 등장 여부 저장 배열
            boolean flag = true; // 그룹 단어 여부 플래그
            char prev = 0; // 이전 문자
 
            for (int j = 0; j < length; j++) {
                char c = str.charAt(j); // 현재 문자
                if (c != prev) {
                    if (visited[c - 'a']) {
                        flag = false;
                        break;
                    }
                    visited[c - 'a'] = true; // 처음 등장한 문자 true
                }
                prev = c;
            }
            if (flag) cnt++;
        }
        System.out.println(cnt);
    }
}