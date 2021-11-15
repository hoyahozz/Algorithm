/*
 	BOJ 3052�� ������
	
	����
	�� �ڿ��� A�� B�� ���� ��, A%B�� A�� B�� ���� ������ �̴�. 
	���� ���, 7, 14, 27, 38�� 3���� ���� �������� 1, 2, 0, 2�̴�. 
	�� 10���� �Է¹��� ��, �̸� 42�� ���� �������� ���Ѵ�. 
	�� ���� ���� �ٸ� ���� �� �� �ִ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class Main {
	public static void main(String[] args) throws IOException {
 
		// with HashSet
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		
		HashSet<Integer> hs = new HashSet<Integer>();
		
		
		for (int i = 0; i < 10; i++) {			
			hs.add(Integer.parseInt(br.readLine()) % 42);
		}
		
		sb.append(hs.size());
		System.out.println(sb);
		
		
		// width Array
		
		boolean[] array = new boolean[42];
		
		for (int i = 0; i < 10; i++) {			
			array[Integer.parseInt(br.readLine()) % 42] = true;
		}
		
		int count = 0;
		
		for (int i = 0; i< array.length; i++) {
			if (array[i] == true) {
				count++;
			}
		}
		
		sb.append(count);
		System.out.println(sb);
		
	}
}
