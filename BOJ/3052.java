/*
 	BOJ 3052번 나머지
	
	문제
	두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다. 
	예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다. 
	수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다. 
	그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
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
