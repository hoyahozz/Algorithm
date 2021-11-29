/*
 	BOJ 2908번 상수
 		
	문제	
	상근이의 동생 상수는 수학을 정말 못한다. 
	상수는 숫자를 읽는데 문제가 있다. 
	이렇게 수학을 못하는 상수를 위해서 상근이는 수의 크기를 비교하는 문제를 내주었다. 
	상근이는 세 자리 수 두 개를 칠판에 써주었다. 그 다음에 크기가 큰 수를 말해보라고 했다.
	
	상수는 수를 다른 사람과 다르게 거꾸로 읽는다. 
	예를 들어, 734와 893을 칠판에 적었다면, 
	상수는 이 수를 437과 398로 읽는다. 따라서, 상수는 두 수중 큰 수인 437을 큰 수라고 말할 것이다.
	
	두 수가 주어졌을 때, 상수의 대답을 출력하는 프로그램을 작성하시오.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 1차 하드코딩

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
		for(int i = A.length() - 1; i >= 0; i--) { // 길이를 이용하여 비교
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