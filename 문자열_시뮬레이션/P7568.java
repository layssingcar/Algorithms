import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class P7568 {
    public static void main(String[] args) throws IOException {
        /* 
		 * 7568번: 덩치
		 * 
		 * [문제]
         * 우리는 사람의 덩치를 키와 몸무게, 이 두 개의 값으로 표현하여 그 등수를 매겨보려고 한다. 
         * 어떤 사람의 몸무게가 x kg이고 키가 y cm라면 이 사람의 덩치는 (x, y)로 표시된다. 
         * 두 사람 A 와 B의 덩치가 각각 (x, y), (p, q)라고 할 때 x > p 그리고 y > q 이라면 우리는 A의 덩치가 B의 덩치보다 "더 크다"고 말한다. 
         * 예를 들어 어떤 A, B 두 사람의 덩치가 각각 (56, 177), (45, 165) 라고 한다면 A의 덩치가 B보다 큰 셈이 된다. 
         * 그런데 서로 다른 덩치끼리 크기를 정할 수 없는 경우도 있다. 
         * 예를 들어 두 사람 C와 D의 덩치가 각각 (45, 181), (55, 173)이라면 몸무게는 D가 C보다 더 무겁고, 키는 C가 더 크므로, "덩치"로만 볼 때 C와 D는 누구도 상대방보다 더 크다고 말할 수 없다.
         * 
         * N명의 집단에서 각 사람의 덩치 등수는 자신보다 더 "큰 덩치"의 사람의 수로 정해진다. 
         * 만일 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다. 
         * 이렇게 등수를 결정하면 같은 덩치 등수를 가진 사람은 여러 명도 가능하다.
         * 
		 * [입력]
		 * 첫 줄에는 전체 사람의 수 N이 주어진다. 
         * 그리고 이어지는 N개의 줄에는 각 사람의 몸무게와 키를 나타내는 양의 정수 x와 y가 하나의 공백을 두고 각각 나타난다.
		 * 
		 * [출력]
		 * 여러분은 입력에 나열된 사람의 덩치 등수를 구해서 그 순서대로 첫 줄에 출력해야 한다. 
         * 단, 각 덩치 등수는 공백문자로 분리되어야 한다.
		 */

        /* 
         * 브루트포스 알고리즘(완전 탐색)
         * : 가능한 모든 경우의 수를 전부 탐색해서 답을 찾는 방식
         *   예) 비밀번호가 3자리 숫자 -> 000부터 999까지 전부 시도
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] infos = new int[n][2];
        StringBuilder sb = new StringBuilder();

        // 전체 사람 몸무게, 키 입력 받아 저장
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            infos[i][0] = Integer.parseInt(input[0]);
            infos[i][1] = Integer.parseInt(input[1]);
        }

        for (int i = 0; i < n; i++) {
            int rank = 1;
            for (int j = 0; j < n; j++) {
                // 몸무게, 키가 비교 대상보다 더 큰 사람의 수만큼 1 증가
                if (infos[j][0] > infos[i][0] && infos[j][1] > infos[i][1]) {
                    rank++;
                }
            }
            sb.append(rank).append(" ");
        }

        System.out.println(sb.toString().trim());
    }
}