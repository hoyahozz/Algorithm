/*
 	BOJ 11720번 숫자의 합
 		
	문제	
	N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하는 프로그램을 작성하시오.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		

		String[] arr = br.readLine().split("");
		
		
		int sum = 0;
		
		for (int i =0; i < arr.length; i++) {
			int number = Integer.parseInt(arr[i]);
			sum += number;
		}
		
		sb.append(sum);
		
		
		System.out.println(sb);
	}
}