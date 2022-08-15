/*
 	BOJ 2908�� ���
 		
	����	
	������� ���� ����� ������ ���� ���Ѵ�. 
	����� ���ڸ� �дµ� ������ �ִ�. 
	�̷��� ������ ���ϴ� ����� ���ؼ� ����̴� ���� ũ�⸦ ���ϴ� ������ ���־���. 
	����̴� �� �ڸ� �� �� ���� ĥ�ǿ� ���־���. �� ������ ũ�Ⱑ ū ���� ���غ���� �ߴ�.
	
	����� ���� �ٸ� ����� �ٸ��� �Ųٷ� �д´�. 
	���� ���, 734�� 893�� ĥ�ǿ� �����ٸ�, 
	����� �� ���� 437�� 398�� �д´�. ����, ����� �� ���� ū ���� 437�� ū ����� ���� ���̴�.
	
	�� ���� �־����� ��, ����� ����� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1�� �ϵ��ڵ�

//public class Main {
//	public static void main(String[] args) throws IOException {
//		StringBuilder sb = new StringBuilder();
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st;
//		
//		String answer = br.readLine();
//		st = new StringTokenizer(answer, " ");
//		
//		int A = Integer.parseInt(st.nextToken());
//		int B = Integer.parseInt(st.nextToken());
//	
//		A = (A / 100) + ((A % 100) / 10 * 10) + (A % 10 * 100);
//		B = (B / 100) + ((B % 100) / 10 * 10) + (B % 10 * 100);
//		
//		if (A > B) {
//			System.out.println(A);
//		} else {
//			System.out.println(B);
//		}
//		
//	}
//}

public class Main {
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		String answer = br.readLine();
		st = new StringTokenizer(answer, " ");
		
		String A = st.nextToken();
		String B = st.nextToken();
		String C = "";
		String D = "";
		for(int i = A.length() - 1; i >= 0; i--) { // ���̸� �̿��Ͽ� ��
			C += String.valueOf(A.charAt(i));
			D += String.valueOf(B.charAt(i));
		}
		
		if(Integer.parseInt(C) > Integer.parseInt(D)) {
			System.out.println(C);
		} else {
			System.out.println(D);
		}
		
	}
}