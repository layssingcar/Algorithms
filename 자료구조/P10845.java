import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;

public class P10845 {
	public static void main(String[] args) throws IOException {
		/* 
		 * 10845번: 큐
		 * 
		 * [문제]
		 * 정수를 저장하는 큐를 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.
		 * 
		 * 명령은 총 여섯 가지이다.
		 * - push X: 정수 X를 큐에 넣는 연산이다.
		 * - pop: 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다.
		 * 		  만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		 * - size: 큐에 들어있는 정수의 개수를 출력한다.
		 * - empty: 큐가 비어있으면 1, 아니면 0을 출력한다.
		 * - front: 큐의 가장 앞에 있는 정수를 출력한다.
		 * 			만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		 * - back: 큐의 가장 뒤에 있는 정수를 출력한다.
		 * 		   만약 큐에 들어있는 정수가 없는 경우에는 -1을 출력한다.
		 * 
		 * [입력]
		 * 첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다.
		 * 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다.
		 * 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다.
		 * 문제에 나와있지 않은 명령이 주어지는 경우는 없다.
		 * 
		 * [출력]
		 * 출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
		 */

		Deque<Integer> queue = new ArrayDeque<>();

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		for (int i = 0; i < n; i++) {
			String input = br.readLine();

			if (input.startsWith("push")) {
				String[] arr = input.split(" ");
				/* 
				 * offer(): 맨 뒤에 데이터 추가
				 * 
				 * addLast()와의 차이점
				 * - offer(): 추가 실패 시 false 반환
				 * - addLast(): 추가 실패 시 예외 발생
				 */
				queue.offer(Integer.parseInt(arr[1]));
			} else {
				switch (input) {
					case "pop":
						if (!queue.isEmpty()) {
							/* 
							* poll(): 맨 앞에 있는 데이터를 꺼내 반환하고 queue에서 제거
							* 
							* remove()와의 차이점
							* - poll(): 제거 실패 시 null 반환
							* - remove(): 제거 실패 시 예외 발생
							*/
							System.out.println(queue.poll());
						} else {
							System.out.println(-1);
						}
						break;
					case "size":
						System.out.println(queue.size());
						break;
					case "empty":
						System.out.println(queue.isEmpty() ? 1 : 0);
						break;
					case "front":
						if (!queue.isEmpty()) {
							// peekFirst(): 현재 queue의 맨 앞 데이터 확인
							System.out.println(queue.peekFirst());
						} else {
							System.out.println(-1);
						}
						break;
					case "back":
						if (!queue.isEmpty()) {
							// peekLast(): 현재 queue의 맨 뒤 데이터 확인
							System.out.println(queue.peekLast());
						} else {
							System.out.println(-1);
						}
						break;
				}
			}
		}
	}
}