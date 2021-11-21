/*
 	BOJ 11720�� ������ ��
 		
	����	
	N���� ���ڰ� ���� ���� �����ִ�. �� ���ڸ� ��� ���ؼ� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
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