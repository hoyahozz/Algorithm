/*
 	BOJ 8958�� OX����
 		
	����
	"OOXXOXXOOO"�� ���� OX������ ����� �ִ�. 
	O�� ������ ���� ���̰�, X�� ������ Ʋ�� ���̴�. 
	������ ���� ��� �� ������ ������ �� �������� ���ӵ� O�� ������ �ȴ�.
	 ���� ���, 10�� ������ ������ 3�� �ȴ�.
	
	"OOXXOXXOOO"�� ������ 1+2+0+0+1+0+0+1+2+3 = 10���̴�.
	
	OX������ ����� �־����� ��, ������ ���ϴ� ���α׷��� �ۼ��Ͻÿ�.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
 


		int n = Integer.parseInt(br.readLine());


		for(int i =0; i < n; i++) {
			int count = 0;
			int result = 0;
			String[] array = br.readLine().split("");
			for (int j = 0; j < array.length; j++) {
				if(array[j].equals("O")) {
					count ++;
					result += count;
				} else {
					count = 0;
				}
			}
			sb.append(result).append("\n");
		}
	
		System.out.println(sb);
		
	}
}
