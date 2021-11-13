/*
 	BOJ 2439 �� ��� - 2
	
	����
	ù° �ٿ��� �� 1��, ��° �ٿ��� �� 2��, N��° �ٿ��� �� N���� ��� ����
	������, �������� �������� ������ ��(���� ����)�� ����Ͻÿ�.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String args[]) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());


		for(int i = 1; i <= N; i++) {
			for (int k = N; k > i; k--) {
				sb.append(" ");
			}
			for (int j = 1; j <= i; j++) {
				sb.append("*");
			}
			sb.append("\n");
		}

		System.out.println(sb);


		br.close();
	}
}