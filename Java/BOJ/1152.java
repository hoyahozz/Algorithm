/*
 	BOJ 1152�� �ܾ��� ����
 		
	����	
	���� ��ҹ��ڿ� �������� �̷���� ���ڿ��� �־�����. 
	�� ���ڿ����� �� ���� �ܾ ������? �̸� ���ϴ� ���α׷��� �ۼ��Ͻÿ�. 
	��, �� �ܾ ���� �� �����ϸ� ������ Ƚ����ŭ ��� ����� �Ѵ�.
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
		
		String S = br.readLine();
		st = new StringTokenizer(S, " ");
		sb.append(st.countTokens());
		System.out.println(sb);
		
	}
}