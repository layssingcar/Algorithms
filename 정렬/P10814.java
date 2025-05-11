import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.Comparator;

public class P10814 {
    // Member 클래스: 회원의 나이, 이름을 묶은 사용자 정의 자료형
    public static class Member {
        int age;
        String name;
        
        // 생성자: Member 객체 생성 시 age, name 초기화
        public Member(int age, String name) {
            this.age = age;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        /* 
         * 10814번: 나이순 정렬
         * 
         * [문제]
         * 온라인 저지에 가입한 사람들의 나이와 이름이 가입한 순서대로 주어진다. 
         * 이때, 회원들을 나이가 증가하는 순으로, 나이가 같으면 먼저 가입한 사람이 앞에 오는 순서로 정렬하는 프로그램을 작성하시오.
         * 
         * [입력]
         * 첫째 줄에 온라인 저지 회원의 수 N이 주어진다. (1 ≤ N ≤ 100,000)
         * 둘째 줄부터 N개의 줄에는 각 회원의 나이와 이름이 공백으로 구분되어 주어진다. 
         * 나이는 1보다 크거나 같으며, 200보다 작거나 같은 정수이고, 이름은 알파벳 대소문자로 이루어져 있고, 길이가 100보다 작거나 같은 문자열이다. 
         * 입력은 가입한 순서로 주어진다.
         * 
         * [출력]
         * 첫째 줄부터 총 N개의 줄에 걸쳐 온라인 저지 회원을 나이 순, 나이가 같으면 가입한 순으로 한 줄에 한 명씩 나이와 이름을 공백으로 구분해 출력한다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Member> members = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            members.add(new Member(age, name));
        }

        /* 
         * 안정 정렬: 값이 같은 요소들끼리 기존의 입력 순서가 유지되는 정렬 방식
         * - 안정 정렬: 버블 정렬, 삽입 정렬, 병합 정렬, 기수 정렬
         * - 불안정 정렬: 선택 정렬, 퀵 정렬
         * 
         * Collections.sort(): 삽입 정렬 + 병합 정렬 (팀 정렬)
         * - 첫 번째 인자: 정렬 리스트
         * - 두 번째 인자: 정렬 기준
         * 
         * Comparator.comparingInt(): 정수 값 기반 정렬 기준 정의 메서드
         */
        Collections.sort(members, Comparator.comparingInt(m -> m.age));

        StringBuilder sb = new StringBuilder();
        for (Member m : members) {
            sb.append(m.age).append(" ").append(m.name).append("\n");
        }
        System.out.print(sb);
    }
}