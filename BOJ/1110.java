/*
 	BOJ 1110�� ���ϱ� ����Ŭ
	
	����
	0���� ũ�ų� ����, 99���� �۰ų� ���� ������ �־��� �� ������ ���� ������ �� �� �ִ�. 
	���� �־��� ���� 10���� �۴ٸ� �տ� 0�� �ٿ� �� �ڸ� ���� �����, �� �ڸ��� ���ڸ� ���Ѵ�. 
	�� ����, �־��� ���� ���� ������ �ڸ� ���� �տ��� ���� ���� ���� ������ �ڸ� ���� �̾� ���̸� ���ο� ���� ���� �� �ִ�. ���� ���� ����.
	
	26���� �����Ѵ�. 2+6 = 8�̴�. 
	���ο� ���� 68�̴�. 6+8 = 14�̴�. ���ο� ���� 84�̴�. 8+4 = 12�̴�. ���ο� ���� 42�̴�. 4+2 = 6�̴�. ���ο� ���� 26�̴�.
	
	���� ���� 4������ ���� ���� ���ƿ� �� �ִ�. ���� 26�� ����Ŭ�� ���̴� 4�̴�.
	N�� �־����� ��, N�� ����Ŭ�� ���̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
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

//		st = new StringTokenizer(br.readLine(), "");
		
		int result = Integer.parseInt(br.readLine());
		int copy = result;
		int N = 0;
		
		while(true) {
			
			int left = result % 10 * 10; // ���� �ڸ��� ���ϱ�
			int right = ((result / 10) + (result % 10)) % 10; // ���� �ڸ��� ���ϱ�
			result = left + right;
			N++;
			
			if(result == copy) {
				break;
			}
		}
		
		sb.append(N);
		
		System.out.println(sb);
		
	}
}

