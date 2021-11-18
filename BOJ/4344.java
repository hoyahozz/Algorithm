/*
 	BOJ 4344 ����� �Ѱ���
 		
	����
	���л� ��������� 90%�� �ڽ��� �ݿ��� ����� �Ѵ´ٰ� �����Ѵ�. ����� �׵鿡�� ���� ������ �˷���� �Ѵ�.
	
	ù° �ٿ��� �׽�Ʈ ���̽��� ���� C�� �־�����.
	��° �ٺ��� �� �׽�Ʈ ���̽����� �л��� �� N(1 �� N �� 1000, N�� ����)�� ù ���� �־�����, 
	�̾ N���� ������ �־�����. ������ 0���� ũ�ų� ����, 100���� �۰ų� ���� �����̴�.
	�� ���̽����� �� �پ� ����� �Ѵ� �л����� ������ �ݿø��Ͽ� �Ҽ��� ��° �ڸ����� ����Ѵ�.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
 
		int n = Integer.parseInt(br.readLine());

		for(int i =0; i < n; i++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			int count = Integer.parseInt(st.nextToken());
			
			double[] score = new double[count];
			double sum = 0;
			double people = 0;
			double avg = 0;
			double per = 0;
			
			for (int j = 0; j < count; j++) {
				score[j] = Double.parseDouble(st.nextToken());
				sum += score[j];
			}
			
			avg = sum / count;
			

			for (int k = 0; k < count; k++) {
				if(score[k] > avg) {
					people++;
				}
			}
			
			per = (people / count) * 100;			
			String result = String.format("%.3f", per);
			
			sb.append(result).append("%").append("\n");
		}
		System.out.println(sb);
	}
}
