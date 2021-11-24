/*
 	BOJ 10809�� ���ĺ� ã��
 		
	����	
	���ĺ� �ҹ��ڷθ� �̷���� �ܾ� S�� �־�����. 
	������ ���ĺ��� ���ؼ�, �ܾ ���ԵǾ� �ִ� ��쿡�� ó�� �����ϴ� ��ġ��, ���ԵǾ� ���� ���� ��쿡�� -1�� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		char[] q = br.readLine().toCharArray(); // ���ڿ� �޾Ƽ�  char �迭ȭ
		
		for (int i = 'a'; i <= 'z'; i++) { // �ƽ�Ű �ڵ�� ���� ����
			int result = -1; // �⺻�� -1
			for (int j = 0; j < q.length; j++) {
				if(i == (int)q[j]) { // ���ڿ� �񱳽� ������ ����� ����
					result = j;
					break;
				}
			}
			sb.append(result).append(" ");
			
		}
		System.out.println(sb);
	}
}