/*
 	BOJ 2675�� ���ڿ� �ݺ�
 		
	����	
	���ڿ� S�� �Է¹��� �Ŀ�, 
	�� ���ڸ� R�� �ݺ��� �� ���ڿ� P�� ���� �� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
	 ��, ù ��° ���ڸ� R�� �ݺ��ϰ�, �� ��° ���ڸ� R�� �ݺ��ϴ� ������ P�� ����� �ȴ�. S���� QR Code "alphanumeric" ���ڸ� ����ִ�.
	
	QR Code "alphanumeric" ���ڴ� 0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ\$%*+-./: �̴�.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int T = Integer.parseInt(br.readLine()); // �׽�Ʈ �� ����
		
		for(int count = 0; count < T; count++) { // �׽�Ʈ ����ŭ �ݺ���
	
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			
			if(st.hasMoreTokens()) { // ���� �Է� �� ���� ���ڰ� ���� ���� �ൿ
				String[] S = st.nextToken().split(""); // ���ڿ� �ɰ���
				
				for(int i = 0; i < S.length; i++) {
					for(int j = 0; j < n; j++) { // �ݺ��� ����ŭ
						sb.append(S[i]); // �ش� �迭�� ���ڸ� �ݺ�
					}
				}
				
			}
			
			sb.append("\n");
		}

		System.out.println(sb);
		
	}
}