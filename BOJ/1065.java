/*
 	BOJ 1065 �Ѽ�
 		
	����	
	� ���� ���� X�� �� �ڸ��� ���������� �̷�ٸ�, �� ���� �Ѽ���� �Ѵ�. 
	���������� ���ӵ� �� ���� ���� ���̰� ������ ������ ���Ѵ�. 
	N�� �־����� ��, 1���� ũ�ų� ����, N���� �۰ų� ���� �Ѽ��� ������ ����ϴ� ���α׷��� �ۼ��Ͻÿ�. 
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