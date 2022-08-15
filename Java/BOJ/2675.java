/*
 	BOJ 2675번 문자열 반복
 		
	문제	
	문자열 S를 입력받은 후에, 
	각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
	 즉, 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다. S에는 QR Code "alphanumeric" 문자만 들어있다.
	
	QR Code "alphanumeric" 문자는 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: 이다.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine()); // 테스트 수 기입
		
		for(int count = 0; count < T; count++) { // 테스트 수만큼 반복문
	
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			
			if(st.hasMoreTokens()) { // 숫자 입력 후 다음 문자가 있을 때만 행동
				String[] S = st.nextToken().split(""); // 문자열 쪼개기
				
				for(int i = 0; i < S.length; i++) {
					for(int j = 0; j < n; j++) { // 반복할 수만큼
						sb.append(S[i]); // 해당 배열의 문자를 반복
					}
				}
				
			}
			
			sb.append("\n");
		}

		System.out.println(sb);
		
	}
}