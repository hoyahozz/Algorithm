/*
 	BOJ 1065 한수
 		
	문제	
	어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 
	등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. 
	N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오. 
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int count = 99;
		ArrayList<Integer> array = new ArrayList<Integer>();

		if(N < 100) {
			sb.append(N);
		} else {
			
			for(int i = 100; i <= N; i++) {
				int hun = i / 100;
				int ten = (i/10) % 10;
				int one = i % 10;
				
				if((hun - ten) == (ten - one)) {
					count++;
				}
			}
			
			sb.append(count);
			
		}

		System.out.println(sb);
	}
}