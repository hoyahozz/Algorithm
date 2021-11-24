/*
 	BOJ 10809번 알파벳 찾기
 		
	문제	
	알파벳 소문자로만 이루어진 단어 S가 주어진다. 
	각각의 알파벳에 대해서, 단어에 포함되어 있는 경우에는 처음 등장하는 위치를, 포함되어 있지 않은 경우에는 -1을 출력하는 프로그램을 작성하시오.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] q = br.readLine().toCharArray(); // 문자열 받아서  char 배열화
		
		for (int i = 'a'; i <= 'z'; i++) { // 아스키 코드로 범위 지정
			int result = -1; // 기본값 -1
			for (int j = 0; j < q.length; j++) {
				if(i == (int)q[j]) { // 문자열 비교시 같으면 결과값 지정
					result = j;
					break;
				}
			}
			sb.append(result).append(" ");
			
		}
		System.out.println(sb);
	}
}