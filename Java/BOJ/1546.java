/*
 	BOJ 1546�� ���
	
	����
	�����̴� �⸻��縦 ���ƴ�. �����̴� ������ �����ؼ� ���� ��������� �ߴ�. 
	�ϴ� �����̴� �ڱ� ���� �߿� �ִ��� �����. 
	�� ���� M�̶�� �Ѵ�. �׸��� ���� ��� ������ ����/M*100���� ���ƴ�.
	
	���� ���, �������� �ְ����� 70�̰�, 
	���������� 50�̾����� ���������� 50/70*100�� �Ǿ� 71.43���� �ȴ�.
	
	�������� ������ ���� ������ ���� ������� ��, 
	���ο� ����� ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
 
		// with HashSet
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		

		float max = -1000000;
		float sum = 0;
		float avr = 0;
		
		int n = Integer.parseInt(br.readLine());
		
		float[] array = new float[n];

		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < n; i++) {
			array[i] = Float.parseFloat(st.nextToken());
			if (array[i] > max) {
				max = array[i];
			}
		}
		
		
		for(int i = 0; i < n; i++) {
			array[i] = (array[i] / max) * 100;
			sum += array[i];
		}
		
		avr = sum / n;
		
		sb.append(avr);
		System.out.println(sb);
		
	}
}
